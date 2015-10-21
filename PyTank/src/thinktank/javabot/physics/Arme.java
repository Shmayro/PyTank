package thinktank.javabot.physics;


public class Arme {

	private int tempsDecharge = 3;
	private int tempsRestant = 0;
	
	protected Projectile creerProjectile(int x, int y, Direction direction, Terrain map)
	{
		return new Projectile(x, y, direction,map);

	}

	public int getTempsDecharge() {
		/**
	 	* renvoie le temps de recharge de l'arme
	 	*/
		return tempsDecharge;
	}

	public int getTempsRestant() {
		/**
	 	* renvoie le temps de recharge restant de l'arme
	 	*/
		return tempsRestant;
	}
	
	protected void initTempsRestant() {
		/**
	 	* initialise le temps de recharge de l'arme
	 	*/
		this.tempsRestant = tempsDecharge;
	}

	protected void reduireTempsRestant() {
		/**
	 	* reduit le temps de recharge de l'arme
	 	*/
		if(tempsRestant > 0)
			this.tempsRestant = tempsRestant - 1;
	}
}
