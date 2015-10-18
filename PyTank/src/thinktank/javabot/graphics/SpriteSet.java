package thinktank.javabot.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

public class SpriteSet {
	
	BufferedImage img[] = new BufferedImage[4];
	BufferedImage Brun[] = new BufferedImage[4];
	BufferedImage Cyan[] = new BufferedImage[4]; 
	BufferedImage Jaune[] = new BufferedImage[4]; 
	BufferedImage Red[] = new BufferedImage[4]; 
	BufferedImage Rose[] = new BufferedImage[4]; 
	BufferedImage Vert[] = new BufferedImage[4]; 
	BufferedImage Violet[] = new BufferedImage[4];
	
	public SpriteSet(){
		
		try {
			Brun[0] = ImageIO.read(new File("src/ressources/TankHBrun.png"));
			Brun[1] = ImageIO.read(new File("src/ressources/TankBBrun.png"));
			Brun[2] = ImageIO.read(new File("src/ressources/TankGBrun.png"));
			Brun[3] = ImageIO.read(new File("src/ressources/TankDBrun.png"));
		    
		    Cyan[0] = ImageIO.read(new File("src/ressources/TankHCyan.png"));
		    Cyan[1] = ImageIO.read(new File("src/ressources/TankBCyan.png"));
		    Cyan[2] = ImageIO.read(new File("src/ressources/TankGCyan.png"));
		    Cyan[3] = ImageIO.read(new File("src/ressources/TankDCyan.png"));
		    
		    Jaune[0] = ImageIO.read(new File("src/ressources/TankHJaune.png"));
		    Jaune[1] = ImageIO.read(new File("src/ressources/TankBJaune.png"));
		    Jaune[2] = ImageIO.read(new File("src/ressources/TankGJaune.png"));
		    Jaune[3] = ImageIO.read(new File("src/ressources/TankDJaune.png"));
		    
		    Red[0] = ImageIO.read(new File("src/ressources/TankHRed.png"));
		    Red[1] = ImageIO.read(new File("src/ressources/TankBRed.png"));
		    Red[2] = ImageIO.read(new File("src/ressources/TankGRed.png"));
		    Red[3] = ImageIO.read(new File("src/ressources/TankDRed.png"));
		    
		    Rose[0] = ImageIO.read(new File("src/ressources/TankHRose.png"));
		    Rose[1] = ImageIO.read(new File("src/ressources/TankBRose.png"));
		    Rose[2] = ImageIO.read(new File("src/ressources/TankGRose.png"));
		    Rose[3] = ImageIO.read(new File("src/ressources/TankDRose.png"));
		    
		    Vert[0] = ImageIO.read(new File("src/ressources/TankHVert.png"));
		    Vert[1] = ImageIO.read(new File("src/ressources/TankBVert.png"));
		    Vert[2] = ImageIO.read(new File("src/ressources/TankGVert.png"));
		    Vert[3] = ImageIO.read(new File("src/ressources/TankDVert.png"));
		    
		    Violet[0] = ImageIO.read(new File("src/ressources/TankHViolet.png"));
		    Violet[1] = ImageIO.read(new File("src/ressources/TankBViolet.png"));
		    Violet[2] = ImageIO.read(new File("src/ressources/TankGViolet.png"));
		    Violet[3] = ImageIO.read(new File("src/ressources/TankDViolet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }


	public BufferedImage getImg(int num,String tc) throws IOException{

		img[0] = ImageIO.read(new File("src/ressources/TankH"+tc+".png"));
	    img[1] = ImageIO.read(new File("src/ressources/TankB"+tc+".png"));
	    img[2] = ImageIO.read(new File("src/ressources/TankG"+tc+".png"));
	    img[3] = ImageIO.read(new File("src/ressources/TankD"+tc+".png"));

	    java.awt.Image tmp = img[num].getScaledInstance(PanneauDessin.tailleCase, PanneauDessin.tailleCase, java.awt.Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(PanneauDessin.tailleCase, PanneauDessin.tailleCase, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}
	

}
