import java.awt.image.BufferedImage;
import java.awt.*;

public class Scene {

  public DirectionalLight[] lights;
  public Camera camera;
  public Mesh[]  meshes;

  public Scene(DirectionalLight[] light, Camera camera, Mesh[] mesh) {
    this.lights = light;
    this.camera = camera;
    this.meshes = mesh;
  }

  public void render(BufferedImage outImage) {
    for(var y = 0; y < outImage.getHeight(); y++){
      for(var x = 0; x < outImage.getWidth(); x++){
        float r = 1.0f;
        float g = x/(float)outImage.getWidth();;
        float b = y/(float)outImage.getHeight();
        
        outImage.setRGB(x, y, new Color(r,g,b).getRGB());
        
      }
    }
  }

}
