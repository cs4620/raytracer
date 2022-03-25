import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Scene {

  public DirectionalLight[] lights;
  public Camera camera;
  public Mesh[] meshes;
  public Vector3[][] colors;

  public Scene(DirectionalLight[] light, Camera camera, Mesh[] mesh) {
    this.lights = light;
    this.camera = camera;
    this.meshes = mesh;

  }

  public void render(BufferedImage outImage) {
    this.colors = new Vector3[outImage.getWidth()][outImage.getHeight()];

    for (var y = 0; y < outImage.getHeight(); y++) {
      for (var x = 0; x < outImage.getWidth(); x++) {
        float xPercent = x / (float) outImage.getWidth();
        float yPercent = y / (float) outImage.getHeight();

        float xWeight = xPercent * 2 - 1;
        float yWeight = yPercent * 2 - 1;
        // Flip so positive y is up
        yWeight *= -1;

        Vector3 up = camera.lookUp;
        Vector3 forward = camera.lookAt.minus(camera.origin).normalize();
        Vector3 right = up.cross(forward);

        Vector3 rightAdd = right.scale(xWeight);
        Vector3 upAdd = up.scale(yWeight);
        Vector3 pixelWorldLocation = camera.lookAt.plus(rightAdd).plus(upAdd);
        Vector3 rayDirection = pixelWorldLocation.minus(camera.origin).normalize();

        Vector3 rayOrigin = this.camera.origin;

        Ray ray = new Ray(rayOrigin, rayDirection);

        float closestDistance = Float.MAX_VALUE;
        Vector3 closestColor = null;
        Vector3 closestNormal = null;

        for (var i = 0; i < meshes.length; i++) {
          var mesh = meshes[i];
          var material = mesh.material;
          var geometry = mesh.geometry;
          float r = material.color.x;
          float g = material.color.y;
          float b = material.color.z;

          // Now do the ray cast.

          TAndNormal tn = geometry.intersect(ray);
          if (tn.t <= 0)
            continue;
          if (tn.t < closestDistance) {
            closestDistance = tn.t;
            closestNormal = tn.normal;
            closestColor = new Vector3(r, g, b);
          }
        }

        if (closestColor == null)
          colors[x][y] = new Vector3(0, 0, 0);
        else {
          float strength = closestNormal.dot(new Vector3(0, 1, 0));
          if (strength < 0)
            strength = 0;
          colors[x][y] = closestColor.scale(strength);
        }

      }
    }

    save(outImage);
  }

  private void save(BufferedImage outImage) {
    for (var y = 0; y < outImage.getHeight(); y++) {
      for (var x = 0; x < outImage.getWidth(); x++) {
        Vector3 color = colors[x][y];
        float r = color.x;
        float g = color.y;
        float b = color.z;

        outImage.setRGB(x, y, new Color(r, g, b).getRGB());

      }
    }
  }

}
