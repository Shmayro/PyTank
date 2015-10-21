package thinktank.javabot.physics;


public abstract class Mobile implements ObjetTT{
	private static int idMob = 0;
	private int id;
	private int coordX;
	private int coordY;
	private Terrain map;
	private Direction direction;
	private int latence = 0;
	private boolean mort = false;
	
	public boolean getMort(){
		return mort;
	}
	
	protected void meurt() {
		mort = true;
	}

	public int getLatence() {
		return latence;
	}
	
	protected void setLatence(int latence) {
		this.latence = latence;
	}
	protected int newId(){
		idMob++;
		return idMob-1;
	}
	
	protected void avancer()
	/**
 	* permet le mouvement dans le sens de la direction
 	*/
	{
		int old_x = coordX, old_y = coordY;
		
		if( map.TestAndSetCase(this,coordX + direction.getDx(),coordY + direction.getDy()))
		{
			coordX = coordX + direction.getDx();
			coordY = coordY + direction.getDy();
			map.erase(old_x,old_y);

		}
		//System.out.println("type: "+getType()+" id:"+getId()+" newX: "+coordX+" newY: "+coordY);

	}
	
	protected void reculer()
	/**
 	* permet le mouvement dans le sens de la direction
 	*/
	{
		int old_x = coordX, old_y = coordY;
		
		if( map.TestAndSetCase(this,coordX - direction.getDx(),coordY - direction.getDy()))
		{
			coordX = coordX -direction.getDx();
			coordY = coordY - direction.getDy();
			map.erase(old_x,old_y);

		}
		//System.out.println("type: "+getType()+" id:"+getId()+" newX: "+coordX+" newY: "+coordY);

	}
	
	
	public int getId()
	/**
 	* renvoie l'identifiant du mobile
 	*/
	{
		return id;
	}

	protected void setId(int id)
	/**
 	* met à jours l'identifiant
	* @param id identifiant fourni
 	*/
	{
		this.id = id;
	}

	public int getCoordX() 
	/**
 	* renvoie la coordonnée en absyss
 	*/
	{
		return coordX;
	}

	public void setCoordX(int coordX) 
	/**
 	* met à jours la coordonnée en absyss
	* @param coordX nouvelle coordonnée en absyss
 	*/
	{
		this.coordX = coordX;
	}

	public int getCoordY()
	/**
 	* renvoie la coordonnée en ordonnée
 	*/
	{
		return coordY;
	}

	public void setCoordY(int coordy)
	/**
 	* met à jours la coordonnée en absyss
	* @param coordY nouvelle coordonnée en ordonnée
 	*/
	{
		this.coordY = coordy;
	}

	public Direction getDirection()
	/**
 	* renvoie la Direction du mobile
 	*/
	{
		return direction;
	}

	protected void setDirection(Direction direction) 
	/**
 	* met à jours la Direction
	* @param direction  nouvelle Direction
 	*/
	{
		this.direction = direction;
	}

	public Terrain getMap()
	/**
 	* renvoie le Terrain
 	*/
	{
		return map;
	}

	protected void setMap(Terrain map) 
	/**
 	* met à jours le Terrain
	* @param map  nouveau Terrain
 	*/
	{
		this.map = map;
	}
	
	protected abstract void tuer();
	/**
 	* permet de detruire l'objet
 	*/


}
