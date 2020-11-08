package elements;

import java.awt.Color;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light
{
	private Vector _direction;
	
	// ***************** Constructors ********************** //

	public DirectionalLight(Color _color, Vector _direction)
	{
		super(_color);
		this._direction =new Vector(_direction);
	}
	public DirectionalLight( Vector _direction)
	{
		super();
		this._direction =new Vector(_direction);
	}
	public DirectionalLight(Color _color)
	{
		super(_color);
		this._direction=new Vector();
	}
	public DirectionalLight()
	{
		super();
		this._direction=new Vector();
		
	}
	// ***************** Getters/Setters ********************** // 
	public Vector get_direction()
	{
		return new Vector(_direction);
	}
	public void set_direction(Vector _direction)
	{
		this._direction = new Vector(_direction);
	}
	// ***************** Administration  ******************** //
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "DirectionalLight [_direction=" + _direction + "]";
	}
	
	// ***************** Operations ******************** // 
	public Color getIntensity(Point3D point)
	{
		return this.get_color();
	}
	public Vector getL(Point3D point)
	{
		return new Vector(new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0)));
	}
}
