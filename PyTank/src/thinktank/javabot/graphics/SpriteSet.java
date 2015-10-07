package thinktank.javabot.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSet {
	
	BufferedImage img[] = new BufferedImage[4]; 
	
	
	public SpriteSet() {
    
    }


	public BufferedImage getImg(int num,String tc) throws IOException {
		img[0] = ImageIO.read(new File("src/ressources/TankH"+tc+".png"));
	    img[1] = ImageIO.read(new File("src/ressources/TankB"+tc+".png"));
	    img[2] = ImageIO.read(new File("src/ressources/TankG"+tc+".png"));
	    img[3] = ImageIO.read(new File("src/ressources/TankD"+tc+".png"));
		return img[num];
	}
	

}
