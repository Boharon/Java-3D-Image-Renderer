package tests;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import geometries.Triangle;
import primitives.Coordinate;
import primitives.Point3D;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTest 
{
	@Test
	void myTest()
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c100=new Coordinate(100);
		Coordinate c_150=new Coordinate(-150);
		Coordinate c_100=new Coordinate(-100);
		Coordinate c_149=new Coordinate(-149);
		Sphere sphere=new Sphere(new Color(130,200,170),new Point3D(c0,c0,c_150), 50);
		Triangle triangle1=new Triangle(new Color(200,100,0), new Point3D(c100,c0,c_149),new Point3D(c0,c100,c_149),new Point3D(c100,c100,c_149));
		Triangle triangle2=new Triangle( new Color(100,200,50),new Point3D(c100,c0,c_149),new Point3D(c0,c_100,c_149),new Point3D(c100,c_100,c_149));
		Triangle triangle3=new Triangle(new Color(30,20,115), new Point3D(c_100,c0,c_149),new Point3D(c0,c100,c_149),new Point3D(c_100,c100,c_149));
		Triangle triangle4=new Triangle(new Color(185,73,90), new Point3D(c_100,c0,c_149),new Point3D(c0,c_100,c_149),new Point3D(c_100,c_100,c_149));
		
		Scene myScene =new Scene();
		
		myScene.addGeometry(triangle1);
		myScene.addGeometry(sphere);
		myScene.addGeometry(triangle2);
		myScene.addGeometry(triangle3);
		myScene.addGeometry(triangle4);
		ImageWriter imageW=new ImageWriter("myImage", 500, 500, 500, 500);

		Render render=new Render(myScene, imageW);
		render.renderImage();
		render.printGrid(50);
		
		imageW.writeToimage();
		//render.get_imageWriter().writeToimage();
	}
}
