package scene;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;

import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;
import primitives.Point3D;

public class Scene
{
	String _sceneName;
	Color _background;
	LinkedList<Geometry> _geometries;
	Camera _camera;
	double _screenDistance;
	AmbientLight _ambientLight;
	LinkedList<Light> _lights;
	
	// ***************** Constructors ********************** //
	
	public Scene(String _sceneName, Color _background, LinkedList<Geometry> _geometries, Camera _camera, double _screenDistance,AmbientLight _ambientLight,LinkedList<Light> _lights)
	{
		super();
		this._sceneName = _sceneName;
		this._background = _background;
		this._geometries =new LinkedList<Geometry>(_geometries);
		this._camera =new Camera( _camera);
		this._screenDistance = _screenDistance;
		this._ambientLight=new AmbientLight(_ambientLight);
		this._lights=new LinkedList<Light>(_lights);
	}
	public Scene()
	{
		this._sceneName = "defult";
		this._background = Color.black;
		this._geometries =new LinkedList<Geometry>();
		this._camera =new Camera();
		this._screenDistance = 100;
		this._ambientLight=new AmbientLight();
		this._lights=new LinkedList<Light>();
	}
	public Scene(Scene other)
	{
		super();
		this._sceneName = other._sceneName;
		this._background = other._background;
		this._geometries =new LinkedList<Geometry>(other._geometries);
		this._camera =new Camera( other._camera);
		this._screenDistance = other._screenDistance;
		this._ambientLight=new AmbientLight(other._ambientLight);
		this._lights=new LinkedList<Light>(other._lights);
	}
	
	// ***************** Getters/Setters ********************** //
	public String get_sceneName()
	{
		return _sceneName;
	}
	public void set_sceneName(String _sceneName)
	{
		this._sceneName = _sceneName;
	}
	public Color get_background()
	{
		return _background;
	}
	public void set_background(Color _background)
	{
		this._background = _background;
	}
	public LinkedList<Geometry> get_geometries()
	{
		return  new LinkedList<Geometry>(_geometries);
	}
	public void set_geometries(LinkedList<Geometry> _geometries)
	{
		this._geometries = new LinkedList<Geometry>(_geometries);
	}
	public Camera get_camera()
	{
		return new Camera(_camera);
	}
	public void set_camera(Camera _camera)
	{
		this._camera = new Camera(_camera);;
	}
	public double get_screenDistance()
	{
		return _screenDistance;
	}
	public void set_screenDistance(double _screenDistance)
	{
		this._screenDistance = _screenDistance;
	}
	public AmbientLight get_ambientLight()
	{
		return new AmbientLight(_ambientLight);
	}
	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = new AmbientLight(_ambientLight);
	}
	public LinkedList<Light> get_lights() {
		return new LinkedList<Light>(_lights);
	}
	public void set_lights(LinkedList<Light> _lights) {
		this._lights = new LinkedList<Light>(_lights);
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
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _geometries=" + _geometries
				+ ", _camera=" + _camera + ", _screenDistance=" + _screenDistance + ", _ambientLight=" + _ambientLight
				+ ", _lights=" + _lights + "]";
	}
	// ***************** Operations ******************** //
	public void addGeometry(Geometry g)
	{
		if(g!=null)
			_geometries.add(g);
	}
	
	public Iterator<Geometry> getGeometriesIterator()
	{
		return _geometries.iterator();

	}
	public void addLight(Light newLight)
	{
		if(newLight!=null)
			_lights.add(newLight);
	}
	public Iterator<Light> getLightsIterator()
	{
		return _lights.iterator();
	}

}
