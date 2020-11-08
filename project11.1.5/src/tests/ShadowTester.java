	package tests;

	import static org.junit.Assert.*;

	import java.awt.Color;

	import org.junit.Test;

	import elements.PointLight;
	import elements.SpotLight;
	import geometries.Sphere;
	import geometries.Triangle;
	import primitives.Coordinate;
	import primitives.Material;
	import primitives.Point3D;
	import primitives.Vector;
	import renderer.ImageWriter;
	import renderer.Render;
	import scene.Scene;

	public class ShadowTester
	{
		
		@Test
		public void testShadow(){
			Coordinate c0=new Coordinate(0);
			Coordinate c_1000=new Coordinate(-1000);
			Coordinate c_125=new Coordinate(-125);
			Coordinate c_260=new Coordinate(-260);
			Coordinate c_225=new Coordinate(-225);
			Coordinate c_270=new Coordinate(-270);
			Scene scene = new Scene();
			scene.set_screenDistance(200);
			
			Sphere sphere = new Sphere (new Color(0,0,100), new Point3D(c0,c0,c_1000),500);
			
			Material m=new Material();
			m.set_n(20);
			sphere.set_material(m);
			scene.addGeometry(sphere);
			
			Triangle triangle = new Triangle(new Color (0, 0, 100),
											 new Point3D(c_125, c_225, c_260),
											 new Point3D(c_225, c_125, c_260),
											 new Point3D(c_225, c_225, c_270)
										);
			Coordinate c_200=new Coordinate(-200);
			Coordinate c_150=new Coordinate(-150);
			Coordinate c2=new Coordinate(2);
			Coordinate c_3=new Coordinate(-3);
			Material m1=new Material();
			m1.set_n(4);
			triangle.set_material(m);
			scene.addGeometry(triangle);
		
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c_200, c_200, c_150), 
						  1, 0.00001, 0.000005,   new Vector(new Point3D(c2,c2,c_3))));
		

			ImageWriter imageWriter = new ImageWriter("Shadow Test", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
		}
	}

