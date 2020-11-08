package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import elements.Camera;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTests 
{
	@Test
	void testRaysConstruction()
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c_1=new Coordinate(-1);
		Coordinate c50=new Coordinate(50);
		Coordinate c_50=new Coordinate(-50);
		Coordinate c_100=new Coordinate(-100);
		
		Camera c=new Camera();
		c.set_vToward(new Vector(new Point3D(c0,c0,c_1)));
		Ray myRay=new Ray (c.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150));
		Ray myTestRay=new Ray(new Point3D(c0,c0,c0),new Vector(new Point3D(c50,c_50,c_100)));
		assertEquals(myRay,myTestRay);
	}
}
