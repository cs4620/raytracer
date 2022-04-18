public class Triangle implements Geometry{

  public Vector3[] points = new Vector3[3];

  public Triangle(Vector3[] points){
    for(var i = 0; i < 3; i++){
      this.points[i] = points[i];
    }
  }

  public Triangle(Vector3 one, Vector3 two, Vector3 three){
    this.points[0] = one;
    this.points[1] = two;
    this.points[2] = three;
  }

  public Vector3 get(int index){
    return this.points[index];
  }

  public Vector3 getOne(){
    return this.points[0];
  }
  
  public Vector3 getTwo(){
    return this.points[1];
  }
  public Vector3 getThree(){
    return this.points[2];
  }

  public void setOne(Vector3 one){
    this.points[0] = one;
  }
  
  public void setTwo(Vector3 two){
    this.points[1] = two;
  }
  public void setThree(Vector3 three){
    this.points[2] = three;
  }

  @Override
  public TAndNormal intersect(Ray ray) {
    if(ray.direction.x == 0 && ray.direction.y == 0 && ray.direction.z == 0){
      System.out.println("Debug");
    }
    var planeTAndNormal = new Plane(this.points).intersect(ray);

    var collisionPoint = ray.origin.plus(ray.direction.scale(planeTAndNormal.t));
    var normal = planeTAndNormal.normal.normalize();

    Plane plane1 = new Plane(points[1], points[0], points[1].plus(normal));
    Plane plane2 = new Plane(points[2], points[1], points[2].plus(normal));
    Plane plane3 = new Plane(points[0], points[2], points[0].plus(normal));

    float distance1 = plane1.offset(collisionPoint);
    float distance2 = plane2.offset(collisionPoint);
    float distance3 = plane3.offset(collisionPoint);

    if(distance1 < 0 || distance2 < 0 || distance3 < 0){
      return new TAndNormal(-1, null);
    }

    return planeTAndNormal;
  }

  
}
