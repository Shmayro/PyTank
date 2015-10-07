package thinktank.javabot.physics;

public class Projectile extends Mobile{

	private int degatsProjectile = 20;
	private int vitesseProjectile = 0; // nombre d'iter a attendre avant d'avancer
	private static int idMort = -1;
	
	
	
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
	
	protected int avancer(){
		if (getLatence() > 0) {
			setLatence(getLatence() - 1);
			return -1;
		}
		int x = getCoordX();
		int y = getCoordY();
		int val_ret = super.avancer();
		if(x != getCoordX() || y!= getCoordY())
			setLatence(vitesseProjectile);
		return val_ret;
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
	
}
