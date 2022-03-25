public class Plane implements Geometry{
  public Vector3 ABC;
  public float D;

  public Plane(Vector3 ABC, float D) {
    this.ABC = ABC;
    this.D = D;
  }

  @Override
  public float intersect(Ray ray) {
    
    float numerator = -D+-ABC.dot(ray.origin);
    float denominator = ABC.dot(ray.direction);
    float result = numerator/denominator;
    
    return result;
  }
}
