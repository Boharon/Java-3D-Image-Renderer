package geometries;

import java.awt.Color;
import java.util.LinkedList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Triangle extends Geometry implements FlatGeometry
{
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	
	// ***************** Constructors ********************** //
	public Triangle(Color color,Material _material, Point3D _p1, Point3D _p2, Point3D _p3)
	{
		super(color,_material);
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	public Triangle(Color color, Point3D _p1, Point3D _p2, Point3D _p3)
	{
		super(color);
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3)
	{
		super();
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	public Triangle(Triangle other)
	{
		super(other.getColor(),other.get_material());
		this._p1 = new Point3D(other._p1);
		this._p2 = new Point3D(other._p2);
		this._p3 = new Point3D(other._p3);
	}
	
	// ***************** Getters/Setters ********************** //
	public Point3D get_p1()
	{
		return new Point3D(_p1);
	}
	public void set_p1(Point3D _p1)
	{
		this._p1 = new Point3D(_p1);
	}
	public Point3D get_p2()
	{
		return new Point3D(_p2);
	}
	public void set_p2(Point3D _p2)
	{
		this._p2 = new Point3D(_p2);
	}
	public Point3D get_p3()
	{
		return new Point3D(_p3);
	}
	public void set_p3(Point3D _p3)
	{
		this._p3 = new Point3D(_p3);
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
		Triangle other = (Triangle) obj;
		if(!super.equals(other))
			return false;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "Triangle ["+ _p1 + " , " + _p2 + " , " + _p3 + super.toString()+"]";
	}
	
	// ***************** Operations ******************** // 
	@Override
	public Vector getNormal(Point3D point)//לבדוק אם הנקודה נמצאת במשולש
	{
		
		Vector v1=new Vector(_p1);
		Vector v2=new Vector(_p2);
		Vector v3=new Vector(_p3);
		v2.subtract(v1);
		v3.subtract(v1);
		v2=v2.crossProduct(v3);
		v2.normalize();
		return v2;
		
	}
	public LinkedList<Point3D> findIntersections(Ray ray)
	{
		Plane plan=new Plane(this.getColor(),this.get_material(),_p1, this.getNormal(null));//לשים לב הגדרנו את החומר ממנו עשוי המשטח
		
		LinkedList<Point3D> myList=new LinkedList<Point3D>();
		
		myList=plan.findIntersections(ray);//בטוח שהרשימה שקיבלנו היא באורך 1
		if(myList.isEmpty())
			return myList;
		
		Vector d=new Vector(ray.get_direction()); 
		Vector v1=new Vector(_p1);
		v1.subtract(d);
		Vector v2=new Vector(_p2);
		v2.subtract(d);
		Vector v3=new Vector(_p3);
		v3.subtract(d);
		Vector n1= new Vector(v1.crossProduct(v2));
		Vector n2= new Vector(v2.crossProduct(v3));
		Vector n3= new Vector(v3.crossProduct(v1));
		n1.normalize();
		n2.normalize();
		n3.normalize();
		Point3D p1=new Point3D(myList.get(0));
		Point3D p2=new Point3D(myList.get(0));
		Point3D p3=new Point3D(myList.get(0));
		p1.subtract(d);
		p2.subtract(d);
		p3.subtract(d);
		double s1,s2,s3;
		s1= n1.dotProduct(new Vector(p1));
		s2= n2.dotProduct(new Vector(p2));
		s3= n3.dotProduct(new Vector(p3));
		
		if((s1>0 && s2>0 && s3>0)||(s1<0 && s2<0 && s3<0))
			return myList;
		return new LinkedList<Point3D>();
		
		
	}
}
