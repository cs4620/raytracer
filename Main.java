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

    
    for(var y = 0; y < height; y++){
      for(var x = 0; x < width; x++){
        var r = 255;
        var g = 0;
        var b = 0;
        
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