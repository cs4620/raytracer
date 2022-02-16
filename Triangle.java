public class Triangle {

  public Point[] points = new Point[3];

  public Triangle(Point[] points){
    for(var i = 0; i < 3; i++){
      this.points[i] = points[i];
    }
  }

  public Triangle(Point one, Point two, Point three){
    this.points[0] = one;
    this.points[1] = two;
    this.points[2] = three;
  }

  public Point get(int index){
    return this.points[index];
  }

  public Point getOne(){
    return this.points[0];
  }
  
  public Point getTwo(){
    return this.points[1];
  }
  public Point getThree(){
    return this.points[2];
  }

  public void setOne(Point one){
    this.points[0] = one;
  }
  
  public void setTwo(Point two){
    this.points[1] = two;
  }
  public void setThree(Point three){
    this.points[2] = three;
  }

  
}
