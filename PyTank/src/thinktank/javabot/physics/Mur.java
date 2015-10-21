package thinktank.javabot.physics;

import java.awt.Graphics;
import java.awt.Image;

import thinktank.javabot.graphics.GraphicArena;
import thinktank.javabot.graphics.ImageLoader;

public class Mur implements ObjetTT{
	final static Mur m = new Mur(GraphicArena.imgLoader);
	Image sprite;

	public Mur(ImageLoader img){
		sprite = img.getSprite(ImageLoader.SpriteName.MUR.ordinal());
	}

	public static Mur getMur()
	/**
 	* renvoie le Mur de la classe
 	*/
	{
		return m;
	}

	public Physique.type getType()
	/**
 	* renvoie un type mur
 	*/
	{
		return Physique.type.mur;
	}
	public void paint(Graphics g, int x, int y){
		g.drawImage(sprite, x, y, null);
	}
}