public class Sphere implements Geometry {

  public Vector3 center;
  public float radius;
  
  public Sphere(Vector3 center, float radius){
    this.center = center;
    this.radius = radius;
  }

  @Override
  public float intersect(Ray ray) {
    float A = ray.direction.dot(ray.direction);
    float B = 2*ray.direction.dot(ray.origin.minus(center));
    Vector3 oc = ray.origin.minus(center);
    float C = oc.dot(oc)-radius*radius;

    float inSqrt = B*B-4*A*C;
    if(inSqrt < 0) return -1;

    float num = -2*B-(float)Math.sqrt(B*B-4*A*C);
    float den = 2*A;
    return num/den;
  }
}
