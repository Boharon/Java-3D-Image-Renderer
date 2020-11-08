package geometries;

import java.awt.Color;
import java.util.LinkedList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends Geometry
{
	private Point3D _center;
	private double _radius;
	
	// ***************** Constructors ********************** //
	public Sphere(Color color,Material _material,Point3D _center, double _radius) 
	{
		super(color,_material);
		this._center =new Point3D (_center);
		this._radius = _radius;
	}
	public Sphere(Color color,Point3D _center, double _radius) 
	{
		super(color);
		this._center =new Point3D (_center);
		this._radius = _radius;
	}
	public Sphere( Point3D _center, double _radius) 
	{
		super();
		this._center =new Point3D (_center);
		this._radius = _radius;
	}
	public Sphere(Sphere other)
	{
		super(other.getColor(),other.get_material());
		this._center =new Point3D (other._center);
		this._radius = other._radius;
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D get_center() 
	{
		return new Point3D(_center);
	}
	public void set_center(Point3D _center)
	{
		this._center =new Point3D(_center);
	}
	public double get_radius() 
	{
		return _radius;
	}
	public void set_radius(double _radius) 
	{
		this._radius = _radius;
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
		Sphere other = (Sphere) obj;
		if(!super.equals(other))
			return false;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return "Sphere [center="+ _center + " ,radius=" + _radius +super.toString()+"]";
	}
	
	
	// ***************** Operations ******************** // 
	public Vector getNormal(Point3D point)//לבדוק אם הנקודה נמצאת על המעגל
	{
		Vector p = new Vector(point);
		Vector cen = new Vector(_center);
		p.subtract(cen);
		p.normalize();
		return p;
	}
	
	public LinkedList<Point3D> findIntersections(Ray ray)
	{
		LinkedList<Point3D> myList = new LinkedList<Point3D>();
		double tm,d,th,t1,t2;
		Vector u=new Vector(_center);
		u.subtract(new Vector(ray.get_P00()));
		Vector direc=ray.get_direction();
		direc.normalize();
		tm=u.dotProduct(direc);
		d=Math.sqrt(Math.pow(u.length(),2)-Math.pow(tm, 2));
		if(d>_radius)
			return myList;
		th=Math.sqrt(Math.pow(_radius,2)-Math.pow(d, 2));
		t1=tm+th;
		t2=tm-th;
		
		if(t1>=0)
		{
			Point3D p1=new Point3D(ray.get_P00());
			Vector tv1=new Vector(ray.get_direction());
			tv1.scale(t1);
			p1.add(tv1);
			myList.add(p1);
		}
		if(t2>=0)
		{
			Point3D p2=new Point3D(ray.get_P00());
			Vector tv2=new Vector(ray.get_direction());
			tv2.scale(t2);
			p2.add(tv2);
			myList.add(p2);
		}
		//System.out.println(myList);
		return myList;
	}

}
