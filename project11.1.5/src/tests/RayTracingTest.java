package tests;

import java.awt.Color;

import org.junit.Test;

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

public class RayTracingTest
{

	
	@Test
	public void recursiveTest1(){
		
		Coordinate c0=new Coordinate(0);
		Coordinate c_1000=new Coordinate(-1000);
		Coordinate c_200=new Coordinate(-200);
		Coordinate c_150=new Coordinate(-150);
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere(new Color(0,0, 100), new Point3D(c0, c0, c_1000), 500);	
		Material material = new Material();		
		material.set_n(20); 
		material.set_Kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color (100, 20, 20),  new Point3D(c0, c0, c_1000), 250);
		material.set_Kt(0);	
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);
		
		Coordinate c2=new Coordinate(2);
		Coordinate c_3=new Coordinate(-3);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c_200,c_200, c_150), 0.1, 0.00001, 0.000005,  new Vector(new Point3D(c2, c2, c_3)))); // NOW
		ImageWriter imageWriter = new ImageWriter("Recursive Test1", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
		
	}
	
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Coordinate c0=new Coordinate(0);
		Coordinate c_1000=new Coordinate(-1000);

		
		Sphere sphere = new Sphere(Color.RED, new Point3D(c0, c0, c_1000), 500);
		Material material = new Material();
		material.set_n(20);
		material.set_Kt(1);
		sphere.set_material(new Material(material));	
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(Color.BLUE, new Point3D(c0, c0, c_1000), 250);
		material.set_Kt(0);
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);
		
		Coordinate c_200=new Coordinate(-200);
		Coordinate c_150=new Coordinate(-150);
		Coordinate c2=new Coordinate(2);
		Coordinate c_3=new Coordinate(-3);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c_200,c_200, c_150), 0.1, 0.00001, 0.000005,  new Vector(new Point3D(c2, c2, c_3)))); // NOW
			
		ImageWriter imageWriter = new ImageWriter("Recursive Test2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}
	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Coordinate c_1000=new Coordinate(-1000);
		Coordinate c_550=new Coordinate(-550);
		Coordinate c_500=new Coordinate(-500);

		Sphere sphere = new Sphere(new Color(0, 0, 100),new Point3D(c_550,c_500, c_1000),300);
		Material material = new Material();
		material.set_n(20); 
		material.set_Kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20),new Point3D(c_550,c_500, c_1000),150);
		Material material2 = new Material();
		material2.set_n(20);
		material2.set_Kt(0);		
		sphere2.set_material(new Material(material2));
		scene.addGeometry(sphere2);
		
		Coordinate c1500=new Coordinate(1500);
		Coordinate c_1500=new Coordinate(-1500);
		Coordinate c200=new Coordinate(200);
		Coordinate c_375=new Coordinate( -375);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  c1500,c_1500,c_1500),
				 new Point3D( c_1500,  c1500, c_1500),
				 new Point3D(c200,c200,c_375));

		Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Point3D(  c1500,c_1500,c_1500),
				 new Point3D( c_1500,  c1500, c_1500),
				  new Point3D( c_1500, c_1500, c_1500));

		
	
		Material material3 = new Material();		
		material3.set_Kr(1);		
		triangle.set_material(new Material(material3));
		
		Material material4 = new Material();		
		material4.set_Kr(0.5);		
		triangle2.set_material(new Material(material4));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		Coordinate c_200=new Coordinate(-200);
		Coordinate c_150=new Coordinate(-150);
		Coordinate c2=new Coordinate(2);
		Coordinate c_3=new Coordinate(-3);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c_200,c_200, c_150), 0.1, 0.00001, 0.000005,  new Vector(new Point3D(c2, c2, c_3)))); // NOW
			
		ImageWriter imageWriter = new ImageWriter("Recursive Test3", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		render.renderImage();
	//	render.printGrid(50);
		imageWriter.writeToimage();		
	}
	
	
}
