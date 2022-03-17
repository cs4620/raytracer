public class Vector3 {

  double x, y, z;

  public Vector3(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Vector3 normalize() {
    var length = this.length();
    var toReturn = new Vector3(x/length, y/length, z/length);
    return toReturn;

  }

  public double length() {
    return Math.sqrt(this.lengthSquared());
  }

  public double lengthSquared() {
    return x * x + y * y + z * z;
  }

  public double dot(Vector3 other){
    return x*other.x + y*other.y+z*other.z;
  }

  public Vector3 cross(Vector3 other){
    var x  = y*other.z-z*other.y;
    var y = z*other.x-x*other.z;
    var z = x*other.y-y*other.x;
    return new Vector3(x,y,z);
  }

}
