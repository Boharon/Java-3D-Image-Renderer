package primitives;

public class Main {

	public static void main(String[] args)
	{
		Coordinate a=new Coordinate(1);
		Coordinate b=new Coordinate(2);
		Coordinate c=new Coordinate(3);
		
		Point3D r2=new Point3D(a,b,c);
		Point3D r7=new Point3D(a,b,b);
		Vector myVec=new Vector(r2);
		Vector myVec2=new Vector(r7);
		Ray r=new Ray(r2,myVec);
		Point3D r5=new Point3D(r2);
		System.out.println(r2);
		System.out.println(r5);
		System.out.println(myVec);
		System.out.println(myVec);
		myVec.add(myVec);
		System.out.println(myVec);
		myVec.subtract (myVec2);
		System.out.println(myVec);
		myVec.scale(8);
		System.out.println(myVec);
		System.out.println(myVec.crossProduct (myVec2));
		System.out.println(myVec.length());
		myVec.normalize();
		System.out.println(myVec.dotProduct(myVec2));
		if(myVec.equals(myVec))
			System.out.println("yessssss");

	}

}
