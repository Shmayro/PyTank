package thinktank.javabot.physics;

import java.awt.Graphics;
import java.awt.Image;

import thinktank.javabot.graphics.GraphicArena;
import thinktank.javabot.graphics.ImageLoader;

public class Projectile extends Mobile{

	private int degatsProjectile = 20;
	private int vitesseProjectile = 0; // nombre d'iter a attendre avant d'avancer
	private static int idMort = -1;
	private Image sprite;
	private Image background_sprite;
	
	
	protected static int getIdMort() {
		return idMort;
	}
	
	protected static void initIdMort() {
		idMort=-1;
	}

	protected static void setIdMort(int idMort) {
		Projectile.idMort = idMort;
	}

	protected Projectile(int x, int y, Direction direction, Terrain map)
	{
		setId(newId());
		setMap(map);
		setCoordX(x);
		setCoordY(y);
		setDirection(direction);
		sprite = GraphicArena.imgLoader.getSprite(ImageLoader.SpriteName.MISSILE.ordinal());
		background_sprite = GraphicArena.imgLoader.getSprite(ImageLoader.SpriteName.SOL.ordinal());
	}
	
	protected Projectile(int x, int y, Direction direction, Terrain map, int dmg, int vitesse)
	{
		setId(newId());
		setMap(map);
		setCoordX(x);
		setCoordY(y);
		setDirection(direction);
		setDegatsProjectile(dmg);
	}
	
	protected void avancer(){
		if (getLatence() > 0) {
			setLatence(getLatence() - 1);
			return;
		}
		int x = getCoordX();
		int y = getCoordY();
		super.avancer();
		if(x != getCoordX() || y!= getCoordY())
			setLatence(vitesseProjectile);
	}
	

	public int getDegatsProjectile() 
	/**
 	* renvoie les degats du Projectile
 	*/
	{
		return degatsProjectile;
	}

	protected void setDegatsProjectile(int degatsProjectile)
	/**
 	* met à jours les degats du Projectile
	* @param degatsProjectile  nouveaux degats du Projectile
 	*/
	{
		this.degatsProjectile = degatsProjectile;
	}

	@Override
	public Physique.type getType()
	/**
 	* renvoie le type projectile
 	*/
	{
		return Physique.type.projectile;
	}
	
	protected void tuer(){
		getMap().erase(getCoordX(),getCoordY());
		meurt();
		getMap().removeProjectile(this);
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(background_sprite, x, y, null);
		g.drawImage(sprite, x, y, null);
		
	}
	
}
