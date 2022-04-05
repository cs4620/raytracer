public class PhongMaterial implements Material{
  private Vector3 color;

  public PhongMaterial(Vector3 color){
    this.color = color;
  }
  public Vector3 Shade(Vector3 position, Vector3 normal, DirectionalLight directionalLight){
    return this.color;
  }

  
  
}
