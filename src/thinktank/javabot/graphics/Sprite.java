package thinktank.javabot.graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	Image img;
	
	public Sprite(String filepath){
		try {
		    img = ImageIO.read(new File(filepath));
		} catch (IOException e) {
		}
	}
	
	public Image getImg() {
		return img;
	}
	
}
