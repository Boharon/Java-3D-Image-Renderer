package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

class myTests {

	//point3D
	@Test
	void testAddPoint3D()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		Coordinate c4=new Coordinate(4);
		Coordinate c5=new Coordinate(5);
		Coordinate c6=new Coordinate(6);
		
		Coordinate c7=new Coordinate(7);
		Coordinate c9=new Coordinate(9);
		
		Point3D p1=new Point3D(c1,c2,c3);
		Vector myVec=new Vector(new Point3D(c4,c5,c6));
		Point3D myTestVec=new Point3D(c5,c7,c9);
		
		p1.add(myVec);
		assertEquals(p1,myTestVec);
	}
	
	@Test
	void testSubtractPoint3D()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		
		Coordinate c4=new Coordinate(4);
		Coordinate c5=new Coordinate(5);
		Coordinate c6=new Coordinate(6);
		
		Coordinate c03=new Coordinate(-3);
		
		Point3D p1=new Point3D(c1,c2,c3);
		Point3D p2=new Point3D(c4,c5,c6);
		Point3D p3=new Point3D(c03,c03,c03);
		
		Vector myVec=new Vector(p2);
		
		p1.subtract(myVec);
		assertEquals(p1,p3);
	}
	
	//Vector
	@Test
	void testAddVector()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		
		Coordinate c4=new Coordinate(4);
		Coordinate c5=new Coordinate(5);
		Coordinate c6=new Coordinate(6);
		
		Coordinate c7=new Coordinate(7);
		Coordinate c9=new Coordinate(9);
		
		Vector myVec1=new Vector(new Point3D(c1,c2,c3));
		Vector myVec2=new Vector(new Point3D(c4,c5,c6));
		Vector myTestVec=new Vector(new Point3D(c5,c7,c9));
		
		myVec1.add(myVec2);
		assertEquals(myVec1,myTestVec);
	}
	
	@Test
	void testSubtractVector()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		
		Coordinate c4=new Coordinate(4);
		Coordinate c5=new Coordinate(5);
		Coordinate c6=new Coordinate(6);
		
		Coordinate c03=new Coordinate(-3);
		
		Vector myVec1=new Vector(new Point3D(c1,c2,c3));
		Vector myVec2=new Vector(new Point3D(c4,c5,c6));
		Vector myTestVec=new Vector(new Point3D(c03,c03,c03));
		
		myVec1.subtract(myVec2);
		assertEquals(myVec1,myTestVec);
	}
	
	@Test
	void testScaling()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		Coordinate c4=new Coordinate(4);
		Coordinate c6=new Coordinate(6);
		
		Vector myVec=new Vector(new Point3D(c1,c2,c3));
		myVec.scale(2);
		Vector myTestVec=new Vector(new Point3D(c2,c4,c6));
		assertEquals(myVec,myTestVec);
	}
	@Test
	void testDorProduct()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		Coordinate c4=new Coordinate(4);
		Coordinate c5=new Coordinate(5);
		Coordinate c6=new Coordinate(6);
		
		Vector myVec1=new Vector(new Point3D(c1,c2,c3));
		Vector myVec2=new Vector(new Point3D(c4,c5,c6));
		
		assertEquals(myVec1.dotProduct(myVec2),32);
	}
	
	@Test
	void testLength()
	{
		Coordinate c1=new Coordinate(0);
		Coordinate c2=new Coordinate(0);
		Coordinate c3=new Coordinate(1);
		
		Vector myVec=new Vector(new Point3D(c1,c2,c3));
		assertEquals(myVec.length(),1);
		
	}
	
	@Test
	void testNormalize()
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c2=new Coordinate(2);
		Coordinate c1=new Coordinate(1);
		
		Vector myVec=new Vector(new Point3D(c0,c2,c0));
		myVec.normalize();
		Vector myTestVec=new Vector(new Point3D(c0,c1,c0));
		assertEquals(myVec,myTestVec);
	}
	
	@Test
	void testCrossProduct()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Coordinate c3=new Coordinate(3);
		Coordinate c4=new Coordinate(4);
		Coordinate c5=new Coordinate(5);
		Coordinate c6=new Coordinate(6);
		
		Coordinate c03=new Coordinate(-3);
		
		Vector myVec1=new Vector(new Point3D(c1,c2,c3));
		Vector myVec2=new Vector(new Point3D(c4,c5,c6));
		Vector myVec3=new Vector(myVec1.crossProduct(myVec2));
		Vector myTestVec=new Vector(new Point3D(c03,c6,c03));
		
		assertEquals(myVec3,myTestVec);
	}
	
	//Plane
	@Test
	void testGetNormalPlane()
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		Point3D p=new Point3D(c0,c0,c0);
		Vector v=new Vector(new Point3D(c0,c2,c0));
		Plane plan=new Plane(p,v);
		Vector myTestVector=new Vector(new Point3D(c0,c1,c0));
		
		assertEquals(plan.getNormal(new Point3D(c0,c0,c0)),myTestVector);
	}
	
	@Test
	void testIntersectionPointsPlane()
	{
		LinkedList<Point3D> myList=new LinkedList<Point3D>();
		Coordinate c0=new Coordinate(0);
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(2);
		myList.add(new Point3D(c0,c0,c2));
		Plane myPlane=new Plane(new Point3D(c0,c0,c2),new Vector(new Point3D(c0,c0,c1)));
		assertEquals(myPlane.findIntersections(new Ray(new Point3D(c0,c0,c0),new Vector(new Point3D(c0,c0,c1)))),myList);
		
	}
	//Sphere
	@Test
	void testGetNormalSphere()
	{
		Point3D p = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
		Sphere sp = new Sphere(p, 3.3);
		Point3D pt = new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0));
		Vector myTest = new Vector(pt);
		assertEquals(myTest,sp.getNormal(pt));
	}
	@Test
	void testIntersectionPointsSphere()
	{
		LinkedList<Point3D> myList=new LinkedList<Point3D>();
		Coordinate c_3=new Coordinate(-3);
		Coordinate c0=new Coordinate(0);
		Coordinate c_1=new Coordinate(-1);
		Coordinate c_2=new Coordinate(-2);
		Coordinate c_4=new Coordinate(-4);
		myList.add(new Point3D(c0,c0,c_4));
		myList.add(new Point3D(c0,c0,c_2));
		Sphere mySphere=new Sphere(new Point3D(c0,c0,c_3),1);
		assertEquals(mySphere.findIntersections(new Ray(new Point3D(c0,c0,c0),new Vector(new Point3D(c0,c0,c_1)))),myList);
	}
	
	//Triangle
	@Test
	void testGetNormalTriangle()
	{
		Coordinate c1=new Coordinate(1);
		Coordinate c0=new Coordinate(0);
		Triangle t=new Triangle(new Point3D(c0,c0,c0),new Point3D(c1,c0,c0),new Point3D(c0,c1,c0));
		Vector myTest=new Vector(new Point3D(c0,c0,c1));
		assertEquals(myTest,t.getNormal(null));
		
	}
	
	@Test
	void testIntersectionPointsTriangle()
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c_200=new Coordinate(-200);
		Coordinate c_100=new Coordinate(-100);
		Coordinate c100=new Coordinate(100);
		Coordinate c_5=new Coordinate(-5);
		// creating the expected values
		
				List<Point3D> answerList = new ArrayList<Point3D>();		
				Point3D answerPoint = new Point3D(c0, c0, c_200);		
				answerList.add(answerPoint);
				
				// building the triangle
				
				Point3D p1 = new Point3D(c0, c100, c_200);
				Point3D p2 = new Point3D(c100, c_100, c_200);
				Point3D p3 = new Point3D(c_100, c_100, c_200);
				
				Triangle t1 = new Triangle(Color.white, p1, p2, p3);
				Triangle t2 = new Triangle(t1);			
				
				// building the ray that will intersect the triangle
				
				Point3D centerPoint = new Point3D(c0,c0,c0);		
				Vector vector = new Vector(new Point3D(c0, c0, c_5));
				Ray ray = new Ray(centerPoint, vector);
			
				// testing the findIntersection function
				
				List<Point3D> list = new ArrayList<Point3D>();
				list = t2.findIntersections(ray);
				assertEquals(answerList, list);
	}
	
	  //המבחן של ג'ויס,לא עובד לנו...
	@Test
	public void testSphereIntersections()
	{
		/*
		Point3D _center=new Point3D(0,-200,-500);
		Sphere s1=new Sphere(_center, 200);
		
		Vector v=new Vector(new Point3D(0,0,-1));
		Ray ray=new Ray(new Point3D(),v);
		List<Point3D> lst=s1.findIntersections(ray);
		if(!lst.isEmpty())
			System.out.print(lst);*/
		// creating the expected values
		List<Point3D> answerList1 = new ArrayList<Point3D>();
		List<Point3D> answerList2 = new ArrayList<Point3D>();
	
		Coordinate c0=new Coordinate(0);
		Coordinate c_200=new Coordinate(-200);
		Coordinate c_600=new Coordinate(-600);
		Coordinate c_50=new Coordinate(-50);
		Coordinate c50=new Coordinate(50);
		Coordinate c_400=new Coordinate(-400);
		Coordinate c_5=new Coordinate(-5);
		
		Point3D answerPoint1 = new Point3D(c0, c0, c_200);
		Point3D answerPoint2 = new Point3D(c0, c0, c_600);
		
		answerList2.add(answerPoint2);
		answerList2.add(answerPoint1);
		
	Point3D p1 = new Point3D(c0,c0, c_400);
	Point3D p2 = new Point3D(p1);		
	Point3D centerPoint = new Point3D(c0,c0,c0);
	
	Vector direction1 = new Vector(new Point3D(c50, c_50, c_50));
	Vector direction2 = new Vector(new Point3D(c0, c0, c_5));
	Sphere sphere1 = new Sphere(Color.white,p1, 200);
	Sphere sphere2= new Sphere(Color.white, p2,200);
	
	// building the ray that will intersect the spheres
	
	Ray ray1 = new Ray(centerPoint, direction1);
	Ray ray2 = new Ray(centerPoint, direction2);
	
	// testing the findIntersection functions
	List<Point3D> list1 = new ArrayList<Point3D>();
	
	list1 = sphere1.findIntersections(ray1);
	assertEquals(answerList1, list1);
	
	List<Point3D> list2 = new ArrayList<Point3D>();
	list2 = sphere2.findIntersections(ray2);
	assertEquals(answerList2, list2);
	}
	
	@Test
	public void testPlaneIntersections() 
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c_200=new Coordinate(-200);
		Coordinate c_1=new Coordinate(-1);
		Coordinate c100=new Coordinate(100);
		Coordinate c_5=new Coordinate(-5);

		// creating the expected values
		
		List<Point3D> answerList = new ArrayList<Point3D>();		
		Point3D answerPoint = new Point3D(c0,c0, c_200);		
		answerList.add(answerPoint);
		
		// building the plane
		
		Point3D directionPoint = new Point3D(c0,c0, c_1);
		Point3D planePoint = new Point3D(c0, c100, c_200);
				
		Vector direction = new Vector(directionPoint);
		
		Plane plane = new Plane(Color.white, planePoint, direction);
			
		// building the ray that will intersect the plane
		
		Point3D centerPoint = new Point3D(c0,c0,c0);
		Vector vector = new Vector(new Point3D(c0, c0, c_5));
		Ray ray = new Ray(centerPoint, vector);
	
		// testing the findIntersection function
		
		List<Point3D> list = new ArrayList<Point3D>();
		list = plane.findIntersections(ray);
		assertEquals(answerList, list);
	}
	
	

}
