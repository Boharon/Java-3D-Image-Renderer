package geometries;

import java.awt.Color;
import java.util.LinkedList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Geometry
{
	private Color color;
	private Material _material;
	
	// ***************** Constructors ********************** // 
	
	public Geometry(Color color,Material _material) 
	{
		super();
		this.color = color;
		this._material=new Material(_material);
	}
	public Geometry(Color color) 
	{
		super();
		this.color = color;
		this._material=new Material();
	}
	public Geometry()
	{
		super();
		this.color=Color.white;
		this._material=new Material();
	}


	// ***************** Getters/Setters ********************** // 
	//לשים לב שלא עשינו new בget set//
	
	public Color getColor()
	{
		return color;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public Material get_material() {
		return new Material(_material);
	}

	public void set_material(Material _material) {
		this._material = new Material(_material);
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
		Geometry other = (Geometry) obj;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "color=" + color + ", _material=" + _material;
	}
	// ***************** Operations ******************** // 

	public abstract Vector getNormal(Point3D point);
	public abstract LinkedList<Point3D> findIntersections(Ray ray);
	public Color getEmission()
	{
		return color;
	}


}
