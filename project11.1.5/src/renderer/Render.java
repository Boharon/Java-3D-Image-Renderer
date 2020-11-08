package renderer;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import elements.Light;
import geometries.FlatGeometry;
import geometries.Geometry;
import geometries.Sphere;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class Render
{
	private static final int RECURSION_LEVEL =3;
	private Scene _scene;
	private ImageWriter _imageWriter;
	
	// ***************** Constructors ********************** // 
	
	public Render(Scene _scene, ImageWriter _imageWriter)
	{
		super();
		this._scene =_scene;
				//new Scene(_scene);
		this._imageWriter=_imageWriter;
		//=new ImageWriter(_imageWriter);
	}
	public Render(Render other)
	{
		super();
		this._scene =new Scene(other._scene);
		this._imageWriter =new ImageWriter(other._imageWriter);
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public Scene get_scene() 
	{
		return new Scene(_scene);
	}
	public void set_scene(Scene _scene) 
	{
		this._scene = new Scene(_scene);
	}
	public ImageWriter get_imageWriter() 
	{
		return new ImageWriter(_imageWriter);
	}
	public void set_imageWriter(ImageWriter _imageWriter) 
	{
		this._imageWriter = new ImageWriter(_imageWriter);
	}

	// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (_imageWriter == null) {
			if (other._imageWriter != null)
				return false;
		} else if (!_imageWriter.equals(other._imageWriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Render [scene=" + _scene + ", imageWriter=" + _imageWriter + "]";
	}
	
	// ***************** Operations ******************** // 
	public void printGrid(int interval)
	{
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
				if(i%interval==0||j%interval==0)
					_imageWriter.writePixel(i, j, Color.white);
	}
	public void renderImage()
	{
		for(int i=0;i<_imageWriter.getNx();i++)
			for(int j=0;j<_imageWriter.getNy();j++)
			{
				Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(),_imageWriter.getNy(),j, i,_scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				Map<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(ray);	
				if (intersectionPoints.isEmpty())
				{
					_imageWriter.writePixel(j, i, _scene.get_background());
				}
				else
				{
					 Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
					 for(Entry<Geometry, Point3D> myenEntry :closestPoint.entrySet())
						 _imageWriter.writePixel(j, i,calcColor(myenEntry.getKey(),myenEntry.getValue(),ray));
				}
			}
	}
	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray)
	{
		Iterator<Geometry> geometries =_scene.getGeometriesIterator();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		
		while (geometries.hasNext())
		{
			Geometry geometry=geometries.next();
			LinkedList<Point3D> geometryIntersectionPoints=new LinkedList<Point3D>(geometry.findIntersections(ray));
			if(!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry, geometryIntersectionPoints);
			
		}
		return intersectionPoints;
	}
	private Map<Geometry, Point3D>  getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints)
	{
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.get_camera().get_P0(); 
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		
		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
			for (Point3D point: entry.getValue())
				if (P0.distance(point) < distance && P0.distance(point)>_scene.get_screenDistance())//&& השני צריך?
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
		return minDistancePoint;
	}
	
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay)
	{
		return calcColor(geometry, point, inRay, 0);
	}
		
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay,int level)
	{
		if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
		Color ambientLight = _scene.get_ambientLight().getIntensity(point);//KAMIAM
		Color emissionLight =geometry.getEmission();//IE
		Color diffuseLight=new Color(0,0,0);
		Color specularLight =new Color(0,0,0);
		Color reflectedColor=new Color(0,0,0);
		Color refractedColor=new Color(0,0,0);
		
		Iterator<Light> lights=_scene.getLightsIterator();
		while(lights.hasNext())
		{
			Light light=lights.next();
			double occludedPercent=1-occluded(light, point, geometry);
			int red,blue,green;
			Color lightIntensity =light.getIntensity(point);
			if(occludedPercent!=0)
			{
			red=(int)(lightIntensity.getRed()*occludedPercent);
			blue=(int)(lightIntensity.getBlue()*occludedPercent);
			green=(int)(lightIntensity.getGreen()*occludedPercent);
			if(red>255)
				red=255;
			if(green>255)
				green=255;
			if(blue>255)
				blue=255;
			lightIntensity=new Color(red,green,blue);
			
			
			diffuseLight=addColor(diffuseLight,calcDiffusiveComp(geometry.get_material().get_Kd(),geometry.getNormal(point),light.getL(point),lightIntensity));
			specularLight=addColor(specularLight,calcSpecularComp(geometry.get_material().get_Ks(),point,_scene.get_camera().get_P0(),geometry.getNormal(point),light.getL(point),geometry.get_material().get_n(),lightIntensity));
			}
			
		}
		
		
		Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);

		Map<Geometry,Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
		if(reflectedEntry!=null)
		for(Entry<Geometry,Point3D> entry:reflectedEntry.entrySet())
		{
			if(entry.getValue() instanceof FlatGeometry)
				reflectedColor=new Color(0,0,0);
			else
				if(entry.getValue()!=null)
					
					reflectedColor = calcColor(entry.getKey(), entry.getValue(), reflectedRay, level + 1);
		}
		
		double kr = geometry.get_material().get_Kr();
			
		
		
		Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
		
		Map<Geometry,Point3D> refractedEntry = findClosesntIntersection(refractedRay);
		//System.out.println(refractedEntry);
		if(refractedEntry!=null)
		for(Entry<Geometry,Point3D> entry:refractedEntry.entrySet())
		{
			if(entry.getValue() instanceof FlatGeometry)
				refractedColor=new Color(0,0,0);
			else
				if(entry.getValue()!=null)
					refractedColor = calcColor(entry.getKey(), entry.getValue(), refractedRay, level + 1);
		}
		double kt = geometry.get_material().get_Kt();
		
		int red,blue,green;
		red=ambientLight.getRed() + emissionLight.getRed()+diffuseLight.getRed()+specularLight.getRed()+(int)(refractedColor.getRed()*kt)+(int)(reflectedColor.getRed()*kr);
		green=ambientLight.getGreen() + emissionLight.getGreen()+diffuseLight.getGreen()+specularLight.getGreen()+(int)(refractedColor.getGreen()*kt)+(int)(reflectedColor.getGreen()*kr);
		blue=ambientLight.getBlue() + emissionLight.getBlue()+diffuseLight.getBlue()+specularLight.getBlue()+(int)(refractedColor.getBlue()*kt)+(int)(reflectedColor.getBlue()*kr);
		if(red>255)
			red=255;
		if(green>255)
			green=255;
		if(blue>255)
			blue=255;
		Color I0 = new Color (red,green,blue);
		
		return I0;
	}
	private Color calcDiffusiveComp(double Kd,Vector N,Vector L,Color IL)
	{
		Kd*= N.dotProduct(L);
		int red,blue,green;
		red=(int)(IL.getRed()*Kd);
		green=(int)(IL.getGreen()*Kd);
		blue=(int)(IL.getBlue()*Kd);
		red=Math.abs(red);
		green=Math.abs(green);
		blue=Math.abs(blue);
		/*if(red<0)
			red=0;
		if(green<0)
			green=0;
		if(blue<0)
			blue=0;*/
		if(red>255)
			red=255;
		if(green>255)
			green=255;
		if(blue>255)
			blue=255;
		return new Color(red, green, blue);
	}
	private Color calcSpecularComp(double Ks,Point3D tv1,Point3D tv2,Vector N,Vector D,double n,Color IL)
	{
		int red,blue,green;
		Vector v=new Vector(tv1);
		Vector v2=new Vector(tv2);
		v2.subtract(v);
		v2.normalize();
		//R
		Vector R=new Vector(D);
		N.scale(2*(D.dotProduct(N)));
		R.subtract(N);
		double po=v2.dotProduct(R);
		if(po<0)
			po=0;
		Ks*=Math.pow(po,n);
		red=(int)(IL.getRed()*Ks);
		green=(int)(IL.getGreen()*Ks);
		blue=(int)(IL.getBlue()*Ks);
		red=Math.abs(red);
		green=Math.abs(green);
		blue=Math.abs(blue);
		
		/*if(red<0)
			red=0;
		if(green<0)
			green=0;
		if(blue<0)
			blue=0;*/
		if(red>255)
			red=255;
		if(green>255)
			green=255;
		if(blue>255)
			blue=255;
		return new Color(red, green, blue);
	}
	private Color addColor(Color c1,Color c2)
	{
		int red,blue,green;
		red=c1.getRed();
		green=c1.getGreen();
		blue=c1.getBlue();
		red+=c2.getRed();
		green+=c2.getGreen();
		blue+=c2.getBlue();
		if(red>255)
			red=255;
		if(green>255)
			green=255;
		if(blue>255)
			blue=255;
		return new Color(red, green, blue);
	}
	private double occluded(Light light, Point3D point, Geometry geometry)
	{
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		int count=0;
		int count2=0;
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);

		for(double i=0.0001;i<0.0007;i+=0.0001)
		{
			Point3D v=new Point3D(lightDirection.get_head());
			v.set_x(new Coordinate(v.get_x().get_coordinate()-i));
			geometryPoint.add(epsVector);
			Ray lightRay = new Ray(geometryPoint, new Vector(v));
			Map<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(lightRay);
			if (geometry instanceof FlatGeometry)
			{
				intersectionPoints.remove(geometry);
			}
			for(Entry<Geometry,List<Point3D>> entry: intersectionPoints.entrySet())
				if(entry.getKey().get_material().get_Kt()==0)
				{
					count++;
					count2++;
				}
				else
					count2++;
		}
		if(count2!=0)
			return (count/(double)(count2));
		return 0;
	}
	private Ray constructReflectedRay(Vector N,Point3D point,Ray D)
	{
		Vector vToR=new Vector(D.get_direction());
		N.scale(2*(D.get_direction().dotProduct(N)));
		vToR.subtract(N);
		Point3D newPoint=new Point3D(point);
		newPoint.add(vToR);
		return new Ray(newPoint,vToR);
	}
	private Ray constructRefractedRay(Vector N,Point3D point,Ray D)
	{
		Vector direc=new Vector(D.get_direction());
		Point3D newPoint=new Point3D(point);
		newPoint.add(direc);
		return new Ray(newPoint,D.get_direction());
	}
	
	
	private  Map<Geometry,Point3D> findClosesntIntersection(Ray ray)
	{
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
		if(intersectionPoints.isEmpty())
			return null;
		return getClosestPoint(intersectionPoints);
		
		
	}
}
