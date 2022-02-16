public class Camera {

  public Point origin;
  public Point lookAt;
  public Point lookUp;
  double halfWidth;

  public Camera(Point origin, Point lookAt, Point lookUp, double halfWidth){
    this.origin = origin;
    this.lookAt = lookAt;
    this.lookUp = lookUp;
    this.halfWidth = halfWidth;
  }
  
}
