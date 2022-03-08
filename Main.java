import java.awt.image.*;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;

class Main{
  public static void main(String[] args) {
    try{
    long startTime = System.currentTimeMillis();
    System.out.println("Up and running");

    var width = 128;
    var height = 128;


    BufferedImage outImage = new BufferedImage(width,height, BufferedImage.TYPE_4BYTE_ABGR);


    //Create our geometry

    var pointOne = new Point(0,0,0);
    var pointTwo = new Point(1,0,0);
    var pointThree = new Point(0,1,0);
    var triangle = new Triangle(pointOne, pointTwo, pointThree);
    var mesh = new Mesh(new Triangle[]{triangle});
    

    //Camera points
    var cameraOrigin = new Point(0,0,-10);
    var cameraLookAt = new Point(0,0,0);
    var cameraLookUp = new Point(0,1,0);
    var halfWidth = Math.PI/4;

    var camera = new Camera(cameraOrigin, cameraLookAt, cameraLookUp, halfWidth);

    //Light points
    var light = new DirectionalLight(new Point(1,1,1).normalize(), 1);

    var scene = new Scene(new DirectionalLight[]{light}, camera, new Mesh[]{mesh});

    scene.render(outImage);



    
    for(var y = 0; y < height; y++){
      for(var x = 0; x < width; x++){
        var r = 1.0f;
        var g = x/(float)width;
        var b = y/(float)height;
        
        outImage.setRGB(x, y, new Color(r,g,b).getRGB());
        
      }
    }
    
    ImageIO.write(outImage, "png", new File("./out/out.png"));

    long endTime = System.currentTimeMillis();
    long runtime = endTime - startTime;
    System.out.println("Done in " + runtime + " millisecond(s)");
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}