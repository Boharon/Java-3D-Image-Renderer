package primitives;

public class Vector implements Comparable<Vector>
{
	private Point3D _head;

	// ***************** Constructors ********************** // 
	public Vector(Point3D _head) 
	{
		super();
		this._head = new Point3D(_head);
	}

	public Vector() 
	{
		super();
		this._head = new Point3D();
	}

	public Vector(Vector _copyVector) 
	{
		super();
		this._head = new Point3D(_copyVector._head);
	}

	// ***************** Getters/Setters ********************** //
	public Point3D get_head()
	{
		return new Point3D (_head);
	}

	public void set_head(Point3D _head)
	{
		this._head =new Point3D (_head);
	}

	// ***************** Administration  ******************** // 
	@Override
	public String toString()
	{
		return _head.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (_head == null)
		{
			if (other._head != null)
				return false;
		} 
		else if (!_head.equals(other._head))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Vector other)
	{
		return _head.compareTo(other._head);
	}
	// ***************** Operations ******************** // 
	

	public void add (Vector vector)
	{
		this._head.add(vector);
	}
	public void subtract(Vector vector )
	{
		this._head.subtract(vector);
	}
	
	public void scale(double scalingFactor)
	{
		_head.set_x(new Coordinate(_head.get_x().get_coordinate()*scalingFactor));
		_head.set_y(new Coordinate(_head.get_y().get_coordinate()*scalingFactor));
		_head.set_z(new Coordinate(_head.get_z().get_coordinate()*scalingFactor));
	}
	public Vector crossProduct(Vector vector)
	{
		Vector newVector=new Vector();
		newVector._head.set_x(new Coordinate((_head.get_y().get_coordinate())*(vector.get_head().get_z().get_coordinate())-((_head.get_z().get_coordinate())*(vector.get_head().get_y().get_coordinate()))));
		newVector._head.set_y(new Coordinate((_head.get_z().get_coordinate())*(vector.get_head().get_x().get_coordinate())-((_head.get_x().get_coordinate())*(vector.get_head().get_z().get_coordinate()))));
		newVector._head.set_z(new Coordinate((_head.get_x().get_coordinate())*(vector.get_head().get_y().get_coordinate())-((_head.get_y().get_coordinate())*(vector.get_head().get_x().get_coordinate()))));
		return newVector;
	}
	public double length() 
	{
		return Math.sqrt(Math.pow(_head.get_x().get_coordinate(),2)+Math.pow(_head.get_y().get_coordinate(),2)+Math.pow(_head.get_z().get_coordinate(),2));
		
	}
	public void normalize()
	{
		double length=length();
		_head.set_x(new Coordinate(_head.get_x().get_coordinate()/length));
		_head.set_y(new Coordinate(_head.get_y().get_coordinate()/length));
		_head.set_z(new Coordinate(_head.get_z().get_coordinate()/length));
	}
	public double dotProduct(Vector vector)
	{
		return (_head.get_x().get_coordinate())*(vector.get_head().get_x().get_coordinate())+(_head.get_y().get_coordinate())*(vector.get_head().get_y().get_coordinate())+(_head.get_z().get_coordinate())*(vector.get_head().get_z().get_coordinate());
	}
	

	

	
}
