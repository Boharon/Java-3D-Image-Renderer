package elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera 
{
	private Point3D _P0;
	private Vector _vUp;
	private Vector _vToward;
	private Vector _vRight;
	
	// ***************** Constructors ********************** //
	public Camera(Point3D _P0, Vector _vUp, Vector _vTo, Vector _vRight)
	{
		this._P0 = new Point3D(_P0);
		this._vUp = new Vector(_vUp);
		this._vToward = new Vector(_vTo);
		this._vRight = new Vector(_vRight);
	}
	public Camera()
	{
		Coordinate c0=new Coordinate(0);
		Coordinate c1=new Coordinate(1);
		Coordinate c_1=new Coordinate(-1);
		
		this._P0 = new Point3D(c0,c0,c0);
		this._vUp = new Vector(new Point3D(c0,c1, c0));
		this._vToward =  new Vector/*(new Point3D(c1,c0, c_1));*/(new Point3D(c0,c0, c_1));
		this._vRight = new Vector(new Point3D(c1,c0, c0));
	}
	public Camera(Camera other)
	{
		this._P0 = new Point3D(other._P0);
		this._vUp =new Vector(other._vUp);
		this._vToward =new Vector(other._vToward);
		this._vRight =new Vector( other._vRight);
	}
	
	// ***************** Getters/Setters ********************** //
	public Point3D get_P0() {
		return new Point3D(_P0);
	}
	public void set_P0(Point3D _P0) {
		this._P0 =new Point3D(_P0);
	}
	public Vector get_vUp() {
		return new Vector(_vUp);
	}
	public void set_vUp(Vector _vUp) {
		this._vUp = new Vector(_vUp);
	}
	public Vector get_vToward() {
		return new Vector(_vToward);
	}
	public void set_vToward(Vector _vToward) {
		this._vToward = new Vector(_vToward);
	}
	public Vector get_vRight() {
		return new Vector(_vRight);
	}
	public void set_vRight(Vector _vRight) {
		this._vRight = new Vector(_vRight);
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
		Camera other = (Camera) obj;
		if (_P0 == null) {
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vToward == null) {
			if (other._vToward != null)
				return false;
		} else if (!_vToward.equals(other._vToward))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Camera [P0=" + _P0 + ", vUp=" + _vUp + ", vToward=" + _vToward + ", vRight=" + _vRight + "]";
	}
	
	// ***************** Operations ******************** // 
	public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y,double screenDist, double screenWidth,double screenHeight)
	{
		//Image center
		Coordinate c0=new Coordinate(0);
		Coordinate c_1=new Coordinate(-1);
		Point3D Pc=new Point3D(_P0);
		Vector dVto=new Vector(/*_vToward*/new Point3D(c0, c0,c_1));
		dVto.scale(screenDist);
		Pc.add(dVto);
		//Ratio (pixel width)
		double Rx=screenWidth/Nx;
		double Ry=screenHeight/Ny;
		Point3D P=new Point3D(Pc);
		Vector moveR=new Vector(_vRight);
		moveR.scale((x-(Nx/(double)2))*Rx-(Rx/(double)2));
		
		Vector moveU=new Vector(_vUp);
		moveU.scale((y-(Ny/(double)2))*Ry-(Ry/(double)2));
		moveR.subtract(moveU);
		P.add(moveR);
		Vector v=new Vector(P);
		v.subtract(new Vector(_P0));
		v.normalize();
		Ray myRay=new Ray(_P0,v);
		return myRay;
	}

}
