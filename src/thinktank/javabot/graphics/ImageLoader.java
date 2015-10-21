package thinktank.javabot.graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static final String images_folder = "ressources/images/";
	
	BufferedImage img[] = new BufferedImage[8];
	
	public enum SpriteName{
		MUR,
		MISSILE,
		SOL,
		TANKH,
		TANKB,
		TANKD,
		TANKG,
		HIGHLIGHT
	}
	
	public ImageLoader(){
		try {
		    img[SpriteName.MUR.ordinal()] = 
		    		toBufferedImage(ImageIO.read(new File(images_folder + "mur.png")));
		    img[SpriteName.MISSILE.ordinal()] =
		    		toBufferedImage(ImageIO.read(new File(images_folder + "missile.png")));
		    img[SpriteName.SOL.ordinal()] =
		    		toBufferedImage(ImageIO.read(new File(images_folder + "sol.png")));
		    img[SpriteName.TANKH.ordinal()] = 
		    		toBufferedImage(ImageIO.read(new File(images_folder + "tankH.png")));
		    img[SpriteName.TANKB.ordinal()] = 
		    		toBufferedImage(ImageIO.read(new File(images_folder + "tankB.png")));
		    img[SpriteName.TANKD.ordinal()] = 
		    		toBufferedImage(ImageIO.read(new File(images_folder + "tankD.png")));
		    img[SpriteName.TANKG.ordinal()] = 
		    		toBufferedImage(ImageIO.read(new File(images_folder + "tankG.png")));
		    img[SpriteName.HIGHLIGHT.ordinal()] = 
		    		toBufferedImage(ImageIO.read(new File(images_folder + "select.png")));
		} catch (IOException e) {
			System.out.println("Problème d'ouverture des images.");
		}
	}
	
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    return bimage;
	}
	
	public BufferedImage getSprite(int sprite){
		return img[sprite];
	}

}
