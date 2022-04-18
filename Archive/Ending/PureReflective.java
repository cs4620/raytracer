public class PureReflective implements Material{
  
  public PureReflective(){
    
  }
  public Vector3 Shade(Vector3 fromDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight, Scene scene, int remainingBounces){
   
    if (remainingBounces == 0)
      return Vector3.Zero;

    Vector3 bounceDirection = fromDirection.reflect(normal);
    var intersection = scene.shootRay(
        new Ray(
            position.plus(bounceDirection.scale(.1f)),
            bounceDirection));
    if (intersection == null)
      return Vector3.Zero;

    var collisionPosition = position.plus(bounceDirection.scale(intersection.t));
    var closestColor = intersection.mesh.material.Shade(
        fromDirection,
        collisionPosition,
        intersection.normal,
        directionalLight,
        scene,
        remainingBounces - 1);

    closestColor = closestColor.scale(.9f);

    return closestColor;
  }

  
  
}
