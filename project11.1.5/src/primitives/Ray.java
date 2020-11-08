package primitives;

public class Ray 
{
	private Point3D _P00;
	private Vector _direction;
	
	// ***************** Constructors ********************** // 
	public Ray(Point3D _P00, Vector _direction) 
	{
		super();
		this._P00 = new Point3D(_P00);
		this._direction = new Vector(_direction);
	}
	
	public Ray() 
	{
		super();
		this._P00 = new Point3D();
		this._direction = new Vector();
	}
	public Ray(Ray _copyRay) 
	{
		super();
		this._P00 = new Point3D(_copyRay._P00);
		this._direction = new Vector(_copyRay._direction);
	}
	
	// ***************** Getters/Setters ********************** // 
	public Point3D get_P00()
	{
		return new Point3D(_P00);
	}

	public void set_P00(Point3D _P00)
	{
		this._P00 = new Point3D(_P00);
	}

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
	public String toString() {
		return "Ray [Source point=" + _P00 + ", direction=" + _direction + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (_P00 == null) {
			if (other._P00 != null)
				return false;
		} else if (!_P00.equals(other._P00))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	
}
