package primitives;

public class Point3D extends Point2D
{
	private Coordinate _z;
	
	
	// ***************** Constructors ********************** // 
	public Point3D(Coordinate _x, Coordinate _y,Coordinate _z)
	{
		super(_x,_y);
		this._z= new Coordinate(_z);
	}

	public Point3D() 
	{
		super();
		this._z =new Coordinate();
	}
	
	public Point3D(Point3D _copyPoint3D) 
	{
		super((Point2D)_copyPoint3D);
		this._z =new Coordinate(_copyPoint3D._z);
	}
	// ***************** Getters/Setters ********************** // 

	public Coordinate get_x() 
	{
		return super.get_x();
	}
	public void set_x(Coordinate _x)
	{
		super.set_x(_x);
	}
	
	public Coordinate get_y() 
	{
		return super.get_y();
	}
	public void set_y(Coordinate _y)
	{
		super.set_y(_y);
	}
	
	public Coordinate get_z() 
	{
		return new Coordinate(_z);
	}

	public void set_z(Coordinate _z)
	{
		this._z = new Coordinate(_z);
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
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + _x + "," + _y + "," + _z + ")";
	}
	
	
	public int compareTo(Point3D other) 
	{
		double lengthP1=Math.sqrt(Math.pow(this._x.get_coordinate(),2)+Math.pow(this._y.get_coordinate(),2)+Math.pow(this._z.get_coordinate(),2));
		double lengthP2=Math.sqrt(Math.pow(other._x.get_coordinate(),2)+Math.pow(other._y.get_coordinate(),2)+Math.pow(other._z.get_coordinate(),2));
		if (lengthP1>lengthP2)
			return 1;
		if (lengthP1<lengthP2)
			return -1;
		return 0;
	}
	
	// ***************** Operations ******************** // 
	public void add (Vector vector)
	{
		this._x.add(vector.get_head().get_x());
		this._y.add(vector.get_head().get_y());
		this._z.add(vector.get_head().get_z());
	}
	public void subtract(Vector vector)
	{
		this._x.subtract(vector.get_head().get_x());
		this._y.subtract(vector.get_head().get_y());
		this._z.subtract(vector.get_head().get_z());
	}
	public double distance(Point3D point)
	{
		return Math.sqrt(Math.pow(this._x.get_coordinate()-point._x.get_coordinate(),2)+Math.pow(this._y.get_coordinate()-point._y.get_coordinate(),2)+Math.pow(this._z.get_coordinate()-point._z.get_coordinate(),2));
	}
	
}
