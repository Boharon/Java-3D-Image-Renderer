package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public abstract class Light
{
	private Color _color;
	
	// ***************** Constructors ********************** // 
	public Light(Color _color)
	{
		this._color = _color;
	}
	public Light()
	{
		this._color=Color.white;
	}
	public Light(Light other)
	{
		this._color=other._color;
	}
	// ***************** Getters/Setters ********************** // 
	public Color get_color()
	{
		return _color;
	}
	public void set_color(Color _color)
	{
		this._color = _color;
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
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Light [_color=" + _color + "]";
	}
	
	// ***************** Operations ******************** // 
	public abstract Color getIntensity(Point3D point);
	public abstract Vector getL(Point3D point);
}
