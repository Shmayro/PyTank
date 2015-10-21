package thinktank.javabot.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import thinktank.javabot.graphics.ImageLoader;

public class DTank extends Tank {
	
	
	private Color color;
	private String script_path;
	private Image sprite[] = new Image[4];
	private Image background_sprite;
	
	public enum Orientation{
		TANKH,
		TANKB,
		TANKD,
		TANKG
	}

	
	public DTank (Terrain map, String filepath, Color color, String script_path, ImageLoader img ){
		super(map, filepath);
		this.script_path=script_path;
		this.color= color;
		loadSprite(img);
	}
	
	public DTank (Terrain map, Color color, String script_path,  ImageLoader img ){
		super(map, script_path);
		this.color= color;
		this.script_path=script_path;
		loadSprite(img);
	}
	
	public DTank (int x, int y, Terrain map, Color color, String script_path,  ImageLoader img, Physique physique){
		super(x, y, map, script_path, physique);
		this.color= color;
		this.script_path=script_path;
		loadSprite(img);
	}
	
	public void loadSprite(ImageLoader img){
		sprite[Orientation.TANKH.ordinal()] = img.getSprite(ImageLoader.SpriteName.TANKH.ordinal());
		sprite[Orientation.TANKB.ordinal()] = img.getSprite(ImageLoader.SpriteName.TANKB.ordinal());
		sprite[Orientation.TANKD.ordinal()] = img.getSprite(ImageLoader.SpriteName.TANKD.ordinal());
		sprite[Orientation.TANKG.ordinal()] = img.getSprite(ImageLoader.SpriteName.TANKG.ordinal());
		background_sprite = img.getSprite(ImageLoader.SpriteName.SOL.ordinal());
	}
	
	public Color getColor() {
		return color;
	}
	 
	public String getScript_path(){
		return script_path;
	}
	public int getEnumDirection(){
		if(this.getDirection().getDx() == 1)
			return Orientation.TANKD.ordinal();
		if(this.getDirection().getDx() == -1)
			return Orientation.TANKG.ordinal();
		if(this.getDirection().getDy() == -1)
			return Orientation.TANKH.ordinal();
		else
			return Orientation.TANKB.ordinal();
	}
	
	public void paint(Graphics g, int x, int y){

		g.drawImage(background_sprite, x, y, null);
		g.drawImage(sprite[getEnumDirection()], x, y, null);
	}
}

