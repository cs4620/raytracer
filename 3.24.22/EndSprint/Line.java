public class Line {
  public double A,B,C,D;

  public Line(double A, double B, double C, double D){
    this.A = A;
    this.B = B;
    this.C = C;
    this.D = D;
  }

  public Line(Vector3 one, Vector3 two){
    var tangent = two.minus(one);
    tangent = tangent.normalize();
    var normal = new Vector3(-tangent.y, tangent.x, 0);
    var d = one.negate().dot(normal);
    this.A = normal.x;
    this.B = normal.y;
    this.C = normal.z;
    this.D = d;
  }
  
}
