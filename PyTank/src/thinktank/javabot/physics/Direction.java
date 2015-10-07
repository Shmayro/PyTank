package thinktank.javabot.physics;

public class Direction {
	/**
 	* Classe permettant de connaitre et changer la direction d'un mobile (sous forme de vecteur)
 	*/

	private int dx;
	private int dy;

	protected Direction (int dx, int dy)
	{
		this.dx = dx;
		this.dy = dy;
	}

	public int getDx ()
	{
		/**
	 	* renvoie dx
	 	*/
		return dx;
	}

	public int getDy ()
	{
		/**
	 	* renvoie dy
	 	*/
		return dy;
	}

	protected void tournerDroite()
	{
		/**
	 	* permet la rotation droite d'un mobile
	 	*/
		int tmp = dx;

		dx = -dy; /*dx * 0 + dy * -1;*/
		dy = tmp; /*tmp * 1 + dy * 0;*/ 

	}
	
	protected void tournerGauche()
	{
		/**
	 	* permet la rotation gauche d'un mobile
	 	*/
		int tmp = dx;

		dx = dy; /*dx * 0 + dy * 1;*/
		dy = -tmp; /*tmp * -1 + dy * 0;*/ 

	}


}