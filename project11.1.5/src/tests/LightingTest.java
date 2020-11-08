package tests;

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

public class LightingTest {

/*	
	@Test 
	public void emmissionTest()
	{
		
		Scene scene = new Scene();
		Coordinate c0=new Coordinate(0);
		Coordinate c100=new Coordinate(100);
		Coordinate c_100=new Coordinate(-100);
		Coordinate c_149=new Coordinate(-149);
		
		scene.addGeometry(new Sphere(Color.blue,new Point3D(c0,c0, c_149),50));
		
		Triangle triangle = new Triangle(Color.red,
										new Point3D( c100, c0, c_149),
				 						 new Point3D(  c0, c100, c_149),
				 						 new Point3D( c100, c100, c_149));
		
		Triangle triangle2 = new Triangle(Color.green,new Point3D( c100, c0, c_149),
				 			 			  new Point3D(  c0, c_100, c_149),
				 			 			  new Point3D( c100,c_100, c_149));
		
		Triangle triangle3 = new Triangle( Color.orange,new Point3D(c_100, c0, c_149),
				 						  new Point3D( c0, c100, c_149),
				 						  new Point3D(c_100, c100, c_149));
		
		Triangle triangle4 = new Triangle(Color.pink,new Point3D(c_100, c0, c_149),
				 			 			  new Point3D(  c0,  c_100, c_149),
				 			 			  new Point3D(c_100, c_100, c_149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Emmitiontest", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToimage();
	}
	
	@Test
	public void spotLightTest2(){
		
		Scene scene = new Scene();
		Coordinate c0=new Coordinate(0);
		Coordinate c_1000=new Coordinate(-1000);
		Coordinate c_125=new Coordinate(-125);
		Coordinate c_260=new Coordinate(-260);
		Coordinate c_225=new Coordinate(-225);
		Coordinate c_270=new Coordinate(-270);
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(c0, c0, c_1000),500);
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),new Point3D(c_125, c_225, c_260),
										 new Point3D(c_225, c_125, c_260),
										 new Point3D(c_225, c_225, c_270)
										 );
		Material m1=new Material();
		m1.set_n(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
		
		Coordinate c_200=new Coordinate(-200);
		Coordinate c_150=new Coordinate(-150);
		Coordinate c2=new Coordinate(2);
		Coordinate c_3=new Coordinate(-3);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c_200, c_200, c_150)
				,1, 0.00001, 0.000005,new Vector(new Point3D(c2, c2, c_3))));
	
		ImageWriter imageWriter = new ImageWriter("Spottest2", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
	
	}
	
	

 @Test public void spotLightTest()
 {
  Scene scene = new Scene();
  scene.set_screenDistance(100);
  Coordinate c0=new Coordinate(0);
  Coordinate c_1000=new Coordinate(-1000);
  Sphere sphere = new Sphere(new Color(0, 0,100), new Point3D(c0,c0,c_1000),800);
  Material m=new Material();
  m.set_n(20);
  sphere.set_material(m);
  scene.addGeometry(sphere);
  Coordinate c_200=new Coordinate(-200);
  Coordinate c_100=new Coordinate(-100);
  Coordinate c2=new Coordinate(2);
  Coordinate c_3=new Coordinate(-3);
  
  scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c_200,c_200, c_100) , 1, 0.00001, 0.000005,new Vector(new Point3D(c2, c2, c_3))));
  
  ImageWriter imageWriter = new ImageWriter("Spottest", 500, 500, 500, 500);
  
  Render render = new Render(scene,imageWriter);
  
  render.renderImage(); imageWriter.writeToimage(); 
  }
  
  
  @Test public void pointLightTest(){
  
  Scene scene = new Scene();
  scene.set_screenDistance(100);
  Coordinate c0=new Coordinate(0);
  Coordinate c_1000=new Coordinate(-1000);
  Sphere sphere = new Sphere(new Color(0, 0,100), new Point3D(c0,c0,c_1000),800);
  Material m=new Material();
  m.set_n(20);
  sphere.set_material(m);
  scene.addGeometry(sphere);
  Coordinate c_200=new Coordinate(-200);
  Coordinate c_100=new Coordinate(-100);
  scene.addLight(new PointLight(new Color(255,100,100), new Point3D(c_200,c_200, c_100), 1, 0.00001, 0.000005));
  
  ImageWriter imageWriter = new ImageWriter("Pointtest", 500, 500, 500, 500);
  
  Render render = new Render(scene,imageWriter);
  
  render.renderImage(); imageWriter.writeToimage();
  
  
  }
  
  @Test public void spotLightTest3(){
  
  Scene scene = new Scene();
  scene.set_screenDistance(100);
  Coordinate c0=new Coordinate(0);
  Coordinate c3500=new Coordinate(3500);
  Coordinate c_3500=new Coordinate(-3500);
  Coordinate c_2000=new Coordinate(-2000);
  Coordinate c_1000=new Coordinate(-1000);
  
  Triangle triangle = new Triangle(new Color(0,0,0),new Point3D( c3500, c3500,c_2000), new Point3D( c_3500, c_3500, c_1000), new Point3D( c3500, c_3500, c_2000) );
  
  Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D( c3500, c3500,c_2000), new Point3D( c_3500, c3500, c_1000), new Point3D( c_3500,c_3500,c_1000) );
  scene.addGeometry(triangle);
  scene.addGeometry(triangle2);

  Coordinate c200=new Coordinate(200); Coordinate c_100=new Coordinate(-100);
  Coordinate c_2=new Coordinate(-2); Coordinate c_3=new Coordinate(-3);
  scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(c200,c200, c_100) ,0, 0.000001, 0.0000005,new Vector(new Point3D(c_2, c_2, c_3))));
 
 ImageWriter imageWriter = new ImageWriter("Spottest3", 500, 500, 500, 500);
 
  Render render = new Render(scene,imageWriter);
  
  render.renderImage(); imageWriter.writeToimage();
  
  }*/
  
  @Test public void pointLightTest2()
  { 
	  Scene scene = new Scene();
	  scene.set_screenDistance(100);
	  Coordinate c0=new Coordinate(0);
	  Coordinate c3500=new Coordinate(3500);
	  Coordinate c_3500=new Coordinate(-3500);
	  Coordinate c_2000=new Coordinate(-2000);
	  Coordinate c_1000=new Coordinate(-1000);
	  Sphere sphere = new Sphere(new Color(0,0,100), new Point3D(c0,c0,c_1000),500);
	  Material m=new Material();
	  m.set_n(20);
	  sphere.set_material(m);
	  Triangle triangle = new Triangle(new Color(0,0,0),new Point3D( c3500, c3500, c_2000), new Point3D( c_3500, c_3500,c_1000), new Point3D( c3500, c_3500, c_2000) );
	  Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D( c3500, c3500,c_2000), new Point3D( c_3500, c3500, c_1000), new Point3D( c_3500,c_3500,c_1000) );
  
	  scene.addGeometry(sphere);
	  scene.addGeometry(triangle);
	  scene.addGeometry(triangle2);
	  Coordinate c200=new Coordinate(200);
	  Coordinate c_200=new Coordinate(-200);
	  Coordinate c_100=new Coordinate(-100);
	  scene.addLight(new PointLight(new Color(255,100,100), new Point3D(c_200, c200,c_100),0.6, 0.000001, 0.0000005));
  
  
	 ImageWriter imageWriter = new ImageWriter("Pointtest2", 500, 500, 500, 500);
	 Render render = new Render(scene,imageWriter);
	 render.renderImage();
	 imageWriter.writeToimage();
  
  }

}