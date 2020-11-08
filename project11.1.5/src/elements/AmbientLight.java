package elements;

import java.awt.Color;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class AmbientLight extends Light
{
	private double _ka = 0.1;
	
	// ***************** Constructors ********************** //

	public AmbientLight(Color _color, double _ka)
	{
		super(_color);
		this._ka = _ka;
	}
	public AmbientLight(double _ka)
	{
		super();
		this._ka = _ka;
	}
	public AmbientLight(Color _color)
	{
		super(_color);
	}
	public AmbientLight()
	{
		super();
	}
	public AmbientLight(AmbientLight other)
	{
		super(other.get_color());
		this._ka = other._ka;
	}
	// ***************** Getters/Setters ********************** // 
	public double get_ka()
	{
		return _ka;
	}
	public void set_ka(double _ka)
	{
		this._ka = _ka;
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
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AmbientLight [_ka=" + _ka + "]";
	}
	
	// ***************** Operations ******************** // 
	public Color getIntensity(Point3D point)
	{
		int red,blue,green;
		red=(int)(this.get_color().getRed()*this._ka);
		green=(int)(this.get_color().getGreen()*this._ka);
		blue=(int)(this.get_color().getBlue()*this._ka);
		if(red>255)
			red=255;
		if(green>255)
			green=255;
		if(blue>255)
			blue=255;
		return new Color(red, green, blue);
	}
	public Vector getL(Point3D point)
	{
		return new Vector(new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0)));
	}
}
