package geometries;

import java.awt.Color;
import java.util.LinkedList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Square extends Geometry
{
	Point3D p1;
	Point3D p2;
	Point3D p3;
	Point3D p4;
	public Square(Point3D p1, Point3D p2, Point3D p3, Point3D p4)
	{
		super();
		this.p1 = new Point3D(p1);
		this.p2 = new Point3D(p2);
		this.p3 = new Point3D(p3);
		this.p4 = new Point3D(p4);
	}
	
	public Point3D getP3() {
		return new Point3D(p3);
	}
	public void setP3(Point3D p3) {
		this.p3 = new Point3D(p3);
	}
	public Point3D getP4() {
		return new Point3D(p4);
	}
	public void setP4(Point3D p4) {
		this.p4 = new Point3D(p4);
	}

	public Point3D getP2() {
		return new Point3D(p2);
	}
	public void setP2(Point3D p2) {
		this.p2 = new Point3D(p2);
	}
	public Point3D getP1() {
		return new Point3D(p1);
	}
	public void setP1(Point3D p1) {
		this.p1 = new Point3D(p1);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		if (p4 == null) {
			if (other.p4 != null)
				return false;
		} else if (!p4.equals(other.p4))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pentagon [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
	}

	@Override
	public Vector getNormal(Point3D point) {
		Vector v1=new Vector(p1);
		Vector v2=new Vector(p2);
		Vector v3=new Vector(p3);
		v2.subtract(v1);
		v3.subtract(v1);
		v2=v2.crossProduct(v3);
		v2.normalize();
		return v2;
	}

	
	@Override
	public LinkedList<Point3D> findIntersections(Ray myRay)
	{
		Triangle t1=new Triangle(p1, p2, p3);
		Triangle t2=new Triangle(p4, p1, p3);

		LinkedList<Point3D> intersec1 = new LinkedList<Point3D>(t1.findIntersections(myRay));
		LinkedList<Point3D> intersec2 = new LinkedList<Point3D>(t2.findIntersections(myRay));
		for (int i = 0; i < intersec2.size(); i++)
		{
			intersec1.add(intersec2.get(i));
		}

		return intersec1;	
	}
}
