package primitives;

public class Point2D  implements Comparable<Point2D>
{
	protected Coordinate _x;
	protected Coordinate _y;
	
	// ***************** Constructors ********************** // 
	public Point2D(Coordinate _x, Coordinate _y)
	{
		super();
		this._x = new Coordinate(_x);
		this._y = new Coordinate(_y);
	}

	public Point2D() 
	{
		super();
		this._x =new Coordinate();
		this._y =new Coordinate();
	}
	
	public Point2D(Point2D _copyPoint2D) 
	{
		super();
		this._x =new Coordinate(_copyPoint2D._x);
		this._y =new Coordinate(_copyPoint2D._y);
	}

	// ***************** Getters/Setters ********************** // 
	public Coordinate get_x() 
	{
		return new Coordinate(_x);
	}

	public void set_x(Coordinate _x) 
	{
		this._x = new Coordinate(_x);
	}

	public Coordinate get_y() 
	{
		return new Coordinate(_y);
	}

	public void set_y(Coordinate _y) 
	{
		this._y = new Coordinate(_y);
	}
	
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "(" + _x + "," + _y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (_x == null) {
			if (other._x != null)
				return false;
		} else if (!_x.equals(other._x))
			return false;
		if (_y == null) {
			if (other._y != null)
				return false;
		} else if (!_y.equals(other._y))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Point2D other) 
	{
		double lengthP1=Math.sqrt(Math.pow(this._x.get_coordinate(),2)+Math.pow(this._y.get_coordinate(),2));
		double lengthP2=Math.sqrt(Math.pow(other._x.get_coordinate(),2)+Math.pow(other._y.get_coordinate(),2));
		if (lengthP1>lengthP2)
			return 1;
		if (lengthP1<lengthP2)
			return -1;
		return 0;
	}
	
}
