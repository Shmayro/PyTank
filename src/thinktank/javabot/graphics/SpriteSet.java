package thinktank.javabot.graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSet {
	
	Image img[] = new Image[4]; 
	
	
	public SpriteSet() {
		
		try {
		    img[0] = ImageIO.read(new File("ressources/tankHBleu.png"));
		    img[1] = ImageIO.read(new File("ressources/tankBBleu.png"));
		    img[2] = ImageIO.read(new File("ressources/tankGBleu.png"));
		    img[3] = ImageIO.read(new File("ressources/tankDBleu.png"));
		} catch (IOException e) {
		}
    
    }


	public Image getImg(int num) {
		return img[num];
	}
	

}
