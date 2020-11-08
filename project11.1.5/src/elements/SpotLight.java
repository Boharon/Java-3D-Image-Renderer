package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight
{
	private Vector _direction;

	// ***************** Constructors ********************** //
	public SpotLight(Color _color, Point3D _position, double _kc, double _kl, double _kq, Vector _direction)
	{
		super(_color, _position, _kc, _kl, _kq);
		this._direction = new Vector(_direction);
		_direction.normalize();
	}

	public SpotLight()
	{
		super();
		this._direction = new Vector();
		_direction.normalize();
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpotLight [_direction=" + _direction + "]";
	}
	// ***************** Operations ******************** // 
	public Color getIntensity(Point3D point)
	{
		double d=point.distance(this._position);
		double mechane=_kc+_kl*d+_kq*d*d;
		int red,blue,green;
		red=this.get_color().getRed();
		green=this.get_color().getGreen();
		blue=this.get_color().getBlue();
		Vector D=new Vector(this._direction);
		D.normalize();
		double dl=D.dotProduct(this.getL(point));
		//if(mechane<1)
		//	mechane=1;
		//dl/=mechane;
		//if(dl<0)
		//	dl=0;
		//red=(int)((red*dl));
		//green=(int)((green*dl));
		//blue=(int)((blue*dl));
		red=(int)((red*dl)/mechane);
		green=(int)((green*dl)/mechane);
		blue=(int)((blue*dl)/mechane);
		//red=Math.abs(red);
		//green=Math.abs(green);
		//blue=Math.abs(blue);
		if(red<0)
			red=0;
		if(green<0)
			green=0;
		if(blue<0)
			blue=0;
		if(red>255)
			red=255;
		if(green>255)
			green=255;
		if(blue>255)
			blue=255;
		return new Color(red,green,blue);
	}
	public Vector getL(Point3D point)//לנרמל את הוקטור
	{
		Vector v1=new Vector(point);
		Vector v2=new Vector(_position);
		v1.subtract(v2);
		v1.normalize();
		return v1;
	}
}
