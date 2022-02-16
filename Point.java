public class Point {

  double x, y, z;

  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Point normalize() {
    var length = this.length();
    x /= length;
    y /= length;
    z /= length;
    return this;
  }

  public Point normalizeCopy() {
    var length = this.length();
    return new Point(x/length, y/length, z/length);
  }

  public double length() {
    return Math.sqrt(this.lengthSquared());
  }

  public double lengthSquared() {
    return x * x + y * y + z * z;
  }

}
