package thinktank.javabot.physics;

import java.awt.Graphics;
import java.awt.Image;

import thinktank.javabot.graphics.GraphicArena;
import thinktank.javabot.graphics.ImageLoader;

public class Vide implements ObjetTT{
	final static Vide v = new Vide(GraphicArena.imgLoader);
	Image sprite;

	public Vide(ImageLoader img){
		sprite = img.getSprite(ImageLoader.SpriteName.SOL.ordinal());
	}
	public static Vide getVide()
	{
		return v;
	}

	public Physique.type getType(){
		return Physique.type.vide;
	}

	@Override
	public void paint(Graphics g, int x, int y){
		g.drawImage(sprite, x, y, null);
	}
}