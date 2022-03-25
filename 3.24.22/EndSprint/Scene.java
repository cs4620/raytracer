import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Scene {

  public DirectionalLight[] lights;
  public Camera camera;
  public Mesh[]  meshes;
  public Vector3[][] colors;

  public Scene(DirectionalLight[] light, Camera camera, Mesh[] mesh) {
    this.lights = light;
    this.camera = camera;
    this.meshes = mesh;
    

  }

  public void render(BufferedImage outImage) {
    this.colors = new Vector3[outImage.getWidth()][outImage.getHeight()];

    for(var y = 0; y < outImage.getHeight(); y++){
      for(var x = 0; x < outImage.getWidth(); x++){
        float r = 1.0f;
        float g = x/(float)outImage.getWidth();;
        float b = y/(float)outImage.getHeight();
        
        colors[x][y] = new Vector3(r,g,b);
        
      }
    }



    save(outImage);
  }

  private void save(BufferedImage outImage){
    for(var y = 0; y < outImage.getHeight(); y++){
      for(var x = 0; x < outImage.getWidth(); x++){
        Vector3 color = colors[x][y];
        float r = color.x;
        float g = color.y;
        float b = color.z;
        
        outImage.setRGB(x, y, new Color(r,g,b).getRGB());
        
      }
    }
  }

}
