import java.awt.image.*;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;

class Main {
  public static void main(String[] args) {
    tests();
    try {
      long startTime = System.currentTimeMillis();
      System.out.println("Up and running");

      var width = 128;
      var height = 128;

      BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

      // Create our geometry

      var pointOne = new Vector3 (0, 0, 0);
      var pointTwo = new Vector3(1, 0, 0);
      var pointThree = new Vector3(0, 1, 0);
      var triangle = new Triangle(pointOne, pointTwo, pointThree);
      var mesh = new Mesh(new Triangle[] { triangle });

      // Camera points
      var cameraOrigin = new Vector3(0, 0, -10);
      var cameraLookAt = new Vector3(0, 0, 0);
      var cameraLookUp = new Vector3(0, 1, 0);
      var halfWidth = Math.PI / 4;

      var camera = new Camera(cameraOrigin, cameraLookAt, cameraLookUp, halfWidth);

      // Light points
      var light = new DirectionalLight(new Vector3(1, 1, 1).normalize(), 1);

      var scene = new Scene(new DirectionalLight[] { light }, camera, new Mesh[] { mesh });

      scene.render(outImage);

      for (var y = 0; y < height; y++) {
        for (var x = 0; x < width; x++) {
          var r = 1.0f;
          var g = x / (float) width;
          var b = y / (float) height;

          outImage.setRGB(x, y, new Color(r, g, b).getRGB());

        }
      }

      ImageIO.write(outImage, "png", new File("./out/out.png"));

      long endTime = System.currentTimeMillis();
      long runtime = endTime - startTime;
      System.out.println("Done in " + runtime + " millisecond(s)");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void tests() {
    var v0 = new Vector3(0, 0, 0);
    var v1 = new Vector3(1, 1, 1);
    var v2 = new Vector3(2, 2, 2);
    var v3 = new Vector3(-3, 2, -1);

    // Test the dot products
    var dot0 = v0.dot(v1);
    if (dot0 != 0)
      System.out.println("Error");

    var dot1 = v1.dot(v2);
    if (dot1 != 6)
      System.out.println("Error");

    // Test the normalization
    var n1 = v1.normalize();
    if (!n1.nearlyEquals(new Vector3(1 / Math.sqrt(3), 1 / Math.sqrt(3), 1 / Math.sqrt(3))))
      System.out.println("Error");

    var n2 = v2.normalize();
    if (!n2.nearlyEquals(new Vector3(1 / Math.sqrt(3), 1 / Math.sqrt(3), 1 / Math.sqrt(3))))
      System.out.println("Error");

    // Test the length
    if (v0.length() != 0)
      System.out.println("Error");

    if (v1.length() != Math.sqrt(3))
      System.out.println("Error");

    if (v2.length() != Math.sqrt(12))
      System.out.println("Error");

    // Test the squared length

    if (v0.lengthSquared() != 0)
      System.out.println("Error");

    if (v1.lengthSquared() != 3)
      System.out.println("Error");

    if (v2.lengthSquared() != 12)
      System.out.println("Error");

    // Test the cross product
    if (!v0.cross(v1).nearlyEquals(new Vector3(0, 0, 0)))
      System.out.println("Error");

    if (!v1.cross(v2).nearlyEquals(new Vector3(0, 0, 0)))
      System.out.println("Error");

    if (!v1.cross(v3).nearlyEquals(new Vector3(-3, -2, 5)))
      System.out.println("Error");

    if (!v2.cross(v3).nearlyEquals(new Vector3(-6, -4, 10)))
      System.out.println("Error");

    // Test addition
    if (!v0.plus(v1).nearlyEquals(v1))
      System.out.println("Error");

    if (!v1.plus(v2).nearlyEquals(new Vector3(3, 3, 3)))
      System.out.println("Error");

    if (!v1.plus(v3).nearlyEquals(new Vector3(-2, 3, 0)))
      System.out.println("Error");

    // Test substraction
    if (!v0.minus(v1).nearlyEquals(v1.negate()))
      System.out.println("Error");

    if (!v1.minus(v0).nearlyEquals(v1))
      System.out.println("Error");

    if (!v3.minus(v2).nearlyEquals(new Vector3(-5, 0, -3)))
      System.out.println("Error");

    // Test negation
    if (!v0.negate().equals(v0))
      System.out.println("Error");

    if (!v1.negate().equals(new Vector3(-1, -1, -1)))
      System.out.println("Error");


    //Test lines
    var line = new Line(1,2,3,4);
    if(line.A != 1 || line.B != 2 || line.C != 3 || line.D != 4)
      System.out.println("Error");
    
    var line2 = new Line(v0, v1);
    if(line2.A != -1/Math.sqrt(3) || line2.B != 1/Math.sqrt(3) || line2.C != 0 || line2.D != 0)
      System.out.println("Error");

    

  }
}