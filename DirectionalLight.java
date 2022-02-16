public class DirectionalLight {

  public Point directionToLight;
  public double intensity;

  public DirectionalLight(Point directionToLight, double intensity){
    this.directionToLight = directionToLight;
    this.intensity = intensity;
  }

  public DirectionalLight normalize(){
    directionToLight = directionToLight.normalize();
    return this;
  }
  
}
