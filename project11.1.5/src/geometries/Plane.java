package geometries;

import java.awt.Color;
import java.util.LinkedList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry
{
	private Point3D _Q;
	private Vector _N;
	// ***************** Constructors ********************** //
	public Plane(Color color,Material _material, Point3D _Q, Vector _N)
	{
		super(color,_material);
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
		this._N.normalize();
	}
	public Plane(Color color, Point3D _Q, Vector _N)
	{
		super(color);
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
		this._N.normalize();
	}
	public Plane(Point3D _Q, Vector _N)
	{
		super();
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
		this._N.normalize();
	}
	public Plane(Plane other)
	{
		super(other.getColor(),other.get_material());
		this._Q = new Point3D(other._Q);
		this._N = new Vector(other._N);
		_N.normalize();
	}
	// ***************** Getters/Setters ********************** //
	public Point3D get_Q() 
	{
		return new Point3D(_Q);
	}
	public void set_Q(Point3D _Q) 
	{
		this._Q = new Point3D(_Q);;
	}
	public Vector get_N() 
	{
		return new Vector(_N);
	}
	public void set_N(Vector _N) 
	{
		this._N = new Vector(_N);
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
		Plane other = (Plane) obj;
		if(!super.equals(other))
			return false;
		if (_N == null) {
			if (other._N != null)
				return false;
		} else if (!_N.equals(other._N))
			return false;
		if (_Q == null) {
			if (other._Q != null)
				return false;
		} else if (!_Q.equals(other._Q))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Plane [Q=" + _Q + ", N=" + _N +super.toString()+ "]";
	}
	
	// ***************** Operations ******************** // 
	public Vector getNormal(Point3D point)
	{
		Vector myNormal=new Vector(_N);
		myNormal.normalize();
		return myNormal;
	}
	public LinkedList<Point3D> findIntersections(Ray ray)
	{
		double t;
		LinkedList<Point3D> myList = new LinkedList<Point3D>();
		Point3D p=new Point3D(ray.get_P00());
		Vector vp=new Vector(ray.get_P00());
		Vector mone2=new Vector(_Q);
		mone2.subtract(vp);

		Vector dic=new Vector(ray.get_direction());
		dic.normalize();
		if(_N.dotProduct(dic)==0)
			return myList;
		t=_N.dotProduct(mone2);
		t=t/(_N.dotProduct(dic));
		if(t<=0)
			return myList;
		Vector tv=new Vector(dic);
		tv.scale(t);
		p.add(tv);
		myList.add(p);
		return myList;
	}

	
}