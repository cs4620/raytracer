public class Sphere implements Geometry {

  public Vector3 center;
  public float radius;
  
  public Sphere(Vector3 center, float radius){
    this.center = center;
    this.radius = radius;
  }

  @Override
  public float intersect(Ray ray) {
    // TODO Auto-generated method stub
    return 0;
  }
}
