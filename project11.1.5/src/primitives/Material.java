package primitives;

public class Material
{
	private double _Kd; // Diffusion attenuation coefficient – פיזור האור 
	private double _Ks; // Specular attenuation coefficient – החזרת האור
	private double _n;  // Refraction index
	private double _Kr; //השתקפות
	private double _Kt;//שקיפות
	
	// ***************** Constructors ********************** //
	public Material(double _Kd, double _Ks, double _n,double _Kr,double _Kt)
	{
		super();
		this._Kd = _Kd;
		this._Ks = _Ks;
		this._n = _n;
		this._Kr =_Kr;
		this._Kt =_Kt;
	}
	public Material(Material other)
	{
		this._Kd = other._Kd;
		this._Ks = other._Ks;
		this._n = other._n;
		this._Kr = other._Kr;
		this._Kt = other._Kt;
	}
	public Material()
	{
		super();
		this._Kd =1;
		this._Ks =1;
		this._n =19;
		this._Kr =0;
		this._Kt =0;
	}
	// ***************** Getters/Setters ********************** //
	public double get_Kd() {
		return _Kd;
	}
	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}
	public double get_Ks() {
		return _Ks;
	}
	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}
	public double get_n() {
		return _n;
	}
	public void set_n(double _n) {
		this._n = _n;
	}
	public double get_Kr() {
		return _Kr;
	}
	public void set_Kr(double _Kr) {
		this._Kr = _Kr;
	}
	public double get_Kt() {
		return _Kt;
	}
	public void set_Kt(double _Kt) {
		this._Kt = _Kt;
	}
	// ***************** Administration  ******************** //
	
	@Override
	public String toString() {
		return "Material [_Kd=" + _Kd + ", _Ks=" + _Ks + ", _n=" + _n + ", _Kr=" + _Kr + ", _Kt=" + _Kt + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_Kd) != Double.doubleToLongBits(other._Kd))
			return false;
		if (Double.doubleToLongBits(_Kr) != Double.doubleToLongBits(other._Kr))
			return false;
		if (Double.doubleToLongBits(_Ks) != Double.doubleToLongBits(other._Ks))
			return false;
		if (Double.doubleToLongBits(_Kt) != Double.doubleToLongBits(other._Kt))
			return false;
		if (Double.doubleToLongBits(_n) != Double.doubleToLongBits(other._n))
			return false;
		return true;
	}



	
	
	
	
	

}
