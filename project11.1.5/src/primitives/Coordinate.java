package primitives;

public class Coordinate implements Comparable<Coordinate>
{
	private double _coordinate;
	
	// ***************** Constructors ********************** // 
	public Coordinate(double _coordinate) 
	{
		super();
		this._coordinate = _coordinate;
	}
	public Coordinate() 
	{
		super();
		this._coordinate = 0;
	}
	public Coordinate(Coordinate _copyCoordinate) 
	{
		super();
		this._coordinate = _copyCoordinate._coordinate;
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public double get_coordinate()
	{
		return  _coordinate;
	}
	public void set_coordinate(double _coordinate) 
	{
		this._coordinate = _coordinate;
	}
	
	// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return ""+_coordinate;
	}
	
	@Override
	public int compareTo(Coordinate other)
	{
		if (Double.doubleToLongBits(_coordinate) > Double.doubleToLongBits(other._coordinate))
			return 1;
		if (Double.doubleToLongBits(_coordinate) < Double.doubleToLongBits(other._coordinate))
			return -1;
		return 0;
	}
	// ***************** Operations ******************** // 
	public void add(Coordinate other)
	{
		this._coordinate+=other._coordinate;
	}
	
	public void subtract (Coordinate other)
	{
		this._coordinate-=other._coordinate;
	}
	
	
	
	
}
