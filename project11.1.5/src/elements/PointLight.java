package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light
{
	Point3D _position;
	double _kc;
	double _kl;
	double _kq;
	
	// ***************** Constructors ********************** //
	public PointLight(Color _color, Point3D _position, double _kc, double _kl, double _kq)
	{
		super(_color);
		this._position = new Point3D(_position);
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
	}

	public PointLight()
	{
		super();
		this._position = new Point3D();
		this._kc = 0;
		this._kl = 0;
		this._kq = 0;
	}
	// ***************** Getters/Setters ********************** // 

	public Point3D get_position() {
		return _position;
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_kc() {
		return _kc;
	}

	public void set_kc(double _kc)
	{
		this._kc = _kc;
	}

	public double get_kl()
	{
		return _kl;
	}

	public void set_kl(double _kl)
	{
		this._kl = _kl;
	}

	public double get_kq()
	{
		return _kq;
	}

	public void set_kq(double _kq)
	{
		this._kq = _kq;
	}
	
	// ***************** Administration  ******************** //
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}

	
	// ***************** Operations ******************** // 
	public Color getIntensity(Point3D point)
	{
		double d=point.distance(this._position);
		double mechane=_kc+_kl*d+_kq*d*d;
		int red,blue,green;
		//if(mechane<1)
		//	mechane=1;
		red=(int)(this.get_color().getRed()/mechane);
		green=(int)(this.get_color().getGreen()/mechane);
		blue=(int)(this.get_color().getBlue()/mechane);
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
		Vector v1=new Vector(point);
		Vector v2=new Vector(_position);
		v1.subtract(v2);
		v1.normalize();
		return v1;
	}
}

