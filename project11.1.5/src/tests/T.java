package tests;

import java.awt.Color;

import org.junit.Test;

import elements.SpotLight;
import geometries.Plane;
import geometries.Sphere;
import geometries.Square;
import geometries.Triangle;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class T 
{
	@Test
	 public void testPart3_01() throws Exception
	{
		Scene scene = new Scene();
		scene.set_screenDistance(150);
		Coordinate c0=new Coordinate(0);
		Coordinate c10=new Coordinate(10);
		Coordinate c200=new Coordinate(200);
		Coordinate c_300=new Coordinate(-300);
		Coordinate c_50=new Coordinate(-50);
		Coordinate c_90=new Coordinate(-90);
		Coordinate c50=new Coordinate(50);	
	  
	  Triangle triangle1 = new Triangle(new Color(31,195,243),new Point3D( c0, c10, c_300), new Point3D(  c_50, c50, c_300), new Point3D(  c_50, c_50, c_300) );
	  Triangle triangle2 = new Triangle(new Color(0,99,175),new Point3D( c0, c10, c_300), new Point3D( c0, c_90, c_300), new Point3D(  c_50, c_50, c_300));
	  Triangle triangle3 = new Triangle(new Color(37,33,96),new Point3D( c0, c10, c_300),new Point3D(  c50, c50, c_300), new Point3D(  c50, c_50, c_300));
	  Triangle triangle4 = new Triangle(new Color(158,31,98),new Point3D( c0, c10, c_300),new Point3D( c0, c_90, c_300), new Point3D(  c50, c_50, c_300));
	  Material materialforT=new Material(1,0.6,20,0,0);
	  triangle1.set_material(materialforT);
	  triangle2.set_material(materialforT);
	  triangle3.set_material(materialforT);
	  triangle4.set_material(materialforT);
	  
	  Sphere sphere = new Sphere(new Color(0,20,20), new Point3D(c0,c10,c_300),150);
	  
	  Material material = new Material();
	  material.set_n(20);
		material.set_Kd(0.5);
		material.set_Kt(1);
		material.set_Ks(0.6);
		material.set_Kr(0);
		
		 Coordinate c_1=new Coordinate(-1);
		  Coordinate c_2=new Coordinate(-2);
		  Coordinate c2=new Coordinate(2);
		  Coordinate c_150=new Coordinate(-150);
		  Coordinate c_500=new Coordinate(-500);
		  Coordinate c300=new Coordinate(300);
		  Coordinate c400=new Coordinate(400);
		  Coordinate c_3=new Coordinate(-3);
		  Coordinate c_10=new Coordinate(-10);
		  Coordinate c3=new Coordinate(3);
		  Coordinate c1=new Coordinate(1);
		  Coordinate c_05=new Coordinate(-0.5);
			sphere.set_material(new Material(material));
			
			//оецащ
			Material material2=new Material(1,0.6,20,0,1);
			sphere.set_material(new Material(material2));
			sphere.setColor(new Color(0, 20,20));
			Plane plane=new Plane(new Color(0, 0, 0),new Point3D(new Coordinate(0), new Coordinate(-200),new Coordinate(-300)),new Vector(new Point3D(c0,c1,c0)));
			//Plane plane=new Plane(new Color(0, 0, 0),new Point3D(new Coordinate(0), new Coordinate(-300),new Coordinate(-300)),new Vector(new Point3D(c0,c1,c_05)));
			plane.set_material(new Material(0.7,0.7,16,1,0.0001));
			scene.addGeometry(plane);
			
			//-500
			Plane plane1=new Plane(new Point3D (c_300, c0, c_300), new Vector(new Point3D(c_3,c0,c_1)));
			Plane plane2=new Plane(new Point3D (c300, c0, c_300), new Vector(new Point3D(c3,c0,c_1)));
			  material.set_n(10);
				material.set_Ks(0);
			material.set_Kr(0.7);
			
			plane1.setColor(new Color(0,0,0));
			plane1.set_material(new Material(material));	
			plane2.setColor(new Color(0,0,0));
			plane2.set_material(new Material(material));
			
			Square s=new Square(new Point3D(c_10, c200,c_300),new Point3D(c10, c200,c_300),new Point3D(c10, c400,c_300),new Point3D(c_10, c400,c_300));
			s.setColor(Color.black);
			
			//оецащ
		
			  scene.addLight(new SpotLight(new Color(100,100,100), new Point3D(c200,c200, c_150), 0.1, 0.00001, 0.000005,  new Vector(new Point3D(c_2, c2, c_3)))); // NOW
		  scene.addGeometry(triangle1);
		  scene.addGeometry(triangle2);
		  scene.addGeometry(triangle3);
		  scene.addGeometry(triangle4);
		scene.addGeometry(sphere);
		scene.addGeometry(plane1);
		scene.addGeometry(plane2);
			 scene.addGeometry(s);
		 ImageWriter imageWriter = new ImageWriter("T", 500, 500, 500, 500);
		 Render render = new Render(scene,imageWriter);
		 render.renderImage();
		 imageWriter.writeToimage();
}
}	
