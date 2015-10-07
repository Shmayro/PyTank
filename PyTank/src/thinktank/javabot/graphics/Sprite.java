package thinktank.javabot.graphics;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sprite {
	Image img;
	
	public Sprite(String filepath){
		
		try {
			
			 img = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public Image getImg() {
		return img;
	}
	
}
