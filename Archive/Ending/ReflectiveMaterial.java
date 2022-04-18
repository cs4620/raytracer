public class ReflectiveMaterial implements Material {
  private Vector3 color;

  public ReflectiveMaterial(Vector3 color) {
    this.color = color;
  }

  public Vector3 Shade(Vector3 fromDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight,
      Scene scene, int remainingBounces) {

    Vector3 phongHalf = new PhongMaterial(this.color).Shade(fromDirection, position, normal, directionalLight, scene, remainingBounces);

    if (remainingBounces == 0)
      return phongHalf.scale(.5f);

    Vector3 bounceDirection = fromDirection.reflect(normal);
    var intersection = scene.shootRay(
        new Ray(
            position.plus(bounceDirection.scale(.1f)),
            bounceDirection));
    if (intersection == null)
      return phongHalf.scale(.5f);

    var collisionPosition = position.plus(bounceDirection.scale(intersection.t));
    var closestColor = intersection.mesh.material.Shade(
        fromDirection,
        collisionPosition,
        intersection.normal,
        directionalLight,
        scene,
        remainingBounces - 1);

    closestColor = closestColor.scale(.5f).plus(phongHalf.scale(.5f));

    return closestColor;
    // return this.color;
  }

}
