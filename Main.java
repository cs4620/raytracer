import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

class Main{
  public static void main(String[] args) {
    try{
    long startTime = System.currentTimeMillis();
    System.out.println("Up and running");


    BufferedImage outImage = new BufferedImage(128,128, BufferedImage.TYPE_4BYTE_ABGR);

    ImageIO.write(outImage, "png", new File("./out/out.png"));


    long endTime = System.currentTimeMillis();
    long runtime = endTime - startTime;
    System.out.println("Done in " + runtime + " millisecond(s)");
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}