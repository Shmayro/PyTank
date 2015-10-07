package thinktank.javabot.physics;

import java.util.ArrayList;

import thinktank.javabot.graphics.GraphicInterface;


public class Terrain {
	
	private ObjetTT terrain[][];
	private ArrayList<Tank> tanks = new ArrayList<Tank>();
	/*private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();*/
	/* Un seul projectile à la fois sur le terrain !*/
	private Projectile projectile;
	private int x, y;
	private boolean affichageOn = true;
	
	public boolean isAffichageOn() {
		return affichageOn;
	}
	
	protected void AffichageOn() {
		affichageOn = true;
	}
	
	protected void AffichageOff() {
		affichageOn = false;
	}
	
	protected Terrain(int x, int y)
	{
		terrain = new ObjetTT [x][y];

		for (int i = 0; i< x; i++){					// initialise la map avec des murs tout autour
			for (int j = 0; j< y; j++){
				if(i == 0 || i == x-1  || j == 0|| j == y-1)
					terrain[i][j] = Mur.getMur();
				else
					terrain[i][j] = Vide.getVide();
			}
		}

		this.x = x;
		this.y = y;
	}

	public ObjetTT[][] getMap() 
	/**
 	* renvoie le Terrain (tableau d'objet)
 	*/
	{
		return terrain;
	}
	
	protected ObjetTT detail (int x, int y)
	/**
 	* renvoie l'objet sur la case de coordonnée (x,y)
	* @param x  absyss
 	* @param y  ordonnée
 	*/
	{
		if(x < 0 || y < 0 || x >= tailleX()|| y >= tailleY())
			return Mur.getMur();
		return terrain[x][y];
	}

	public ArrayList<Tank> getTanks()
	/**
 	* renvoie la liste des tanks
 	*/
	{
		return tanks;
	}
	
	public Projectile getProjectile()
	{
		return projectile;
	}
	/*
	public ArrayList<Projectile> getProjectiles()
	/**
 	* renvoie la liste des projectiles
 	
	{
		return projectiles;
	}
*/
	
	protected Tank addTank()
	/**
 	* rajoute un tank au Terrain, ainsi qu'a la liste des tanks
 	*/
	{
		Tank t =new Tank(this);
		tanks.add(t);
		addObjetTT(t.getCoordX(), t.getCoordY(), t);
		return t;
	}
	
	protected Tank addTank(String filepath)
	/**
 	* rajoute un tank au Terrain, ainsi qu'a la liste des tanks
 	* @param filepath chemin vers l'ia
 	*/
	{
		Tank t =new Tank(this,filepath);
		tanks.add(t);
		addObjetTT(t.getCoordX(), t.getCoordY(), t);
		return t;
	}
	
	protected Tank addTank(int x, int y ,String filepath, Physique physique)
	/**
 	* rajoute un tank au Terrain, ainsi qu'a la liste des tanks
 	* @param filepath chemin vers l'ia
 	* @param x  absyss
 	* @param y  ordonnée
 	*/
	{
		Tank t = new Tank(x,y,this,filepath,physique,GraphicInterface.TankChoice);
		tanks.add(t);
		addObjetTT(t.getCoordX(), t.getCoordY(), t);
		return t;
	}
	

	protected void removeTank(Tank tank)
	/**
 	* enleve le tank désigné de la liste
	* @param tank  le tank à enlever
 	*/
	{
		tanks.remove(tank);
	}

	public Mobile getMobFromId(int id)
	/**
 	* renvoie le mobile d'identifiant id
	* @param id  identifiant d'un mobile
 	*/
	{
		for(Tank t : tanks)
			if(t.getId() == id)
				return t;

		/*for(Projectile p : projectiles)
			if(p.getId() == id)
				return p;*/
		if (projectile.getId() == id)
			return projectile;
		return null;
	}

	public Tank getTankFromId(int id)
	/**
 	* renvoie le Tank d'identifiant id
	* @param id  l'identifiant d'un Tank
 	*/
	{
		for(Tank t : tanks)
			if(t.getId() == id)
				return t;
		return null;
	}


	public Projectile getProFromId(int id)
	/**
 	* renvoie le Projectile d'identifiant id
	* @param id  identifiant d'un Projectile
 	*/
	{
		/*for(Projectile p : projectiles)
			if(p.getId() == id)
				return p;*/
		if (projectile.getId() == id)
			return projectile;
		return null;
	}
/*
	protected void addProjectile(Projectile proj)
	**
 	* ajoute un Projectile à la liste des Projectiles
	* @param proj  Projectile à ajouter à la liste des Projectiles
 	*
	{
		projectiles.add(proj);
		addObjetTT(proj.getCoordX(), proj.getCoordY(), proj);
		
	}
*/
	protected void setProjectile(Projectile proj)
	{
		projectile = proj;
	}
	protected void removeProjectile(Projectile proj)
	/**
 	* enleve un Projectile à la liste des Projectiles
	* @param proj  Projectile à enlever de la liste des Projectiles
 	*/
	{
		/*projectiles.remove(proj);*/
		projectile = null;
	}


	protected boolean estLibre(int x, int y)
	/**
 	* renvoie true si la case(x,y) contient un Vide, sinon renvoie false
	* @param x   absyss
	* @param y   ordonnée
 	*/
	{
		return  detail(x,y) == Vide.getVide();
	}

	public int tailleX()
	/**
 	* renvoie la taille en absyss du Terrain
 	*/
	{
		return x;
	}
	
	public int tailleY()
	/**
 	* renvoie la taille en ordonnée du Terrain
 	*/
	{
		return y;
	}

	protected Physique.type caseContent(int x, int y)
	/**
 	* renvoie la nature de l'objet en (x,y)
	* @param x  absyss
	* @param y  ordonnée
 	*/
	{
		if(x <= terrain.length && y <= terrain[x].length){
			if(terrain[x][y] == Mur.getMur())
				return Physique.type.mur;
			if(terrain[x][y] == Vide.getVide())
				return Physique.type.vide;
			return terrain[x][y].getType();
		}
		else
			return Physique.type.mur;
	}

	
/* Valeur de retour: 
 *  -2: Deplacement impossible
 *  -1: Deplacement possible
 *  >= 0: Pour les projectiles uniquement: indice du mobile rencontré.	
 */
	protected int TestAndSetCase(Mobile mob,int newX, int newY)
	{
		
		int x = mob.getCoordX();
		int y = mob.getCoordY();
		

		if(estLibre(newX, newY)){
			erase(x,y);
			terrain[newX][newY] = mob;
			return -1;
		}
		if(mob.getType() == Physique.type.projectile){
			if(caseContent(newX,newY) == Physique.type.mur ){ // un mur
				mob.tuer();
				return -1;
			}
		/*	if(caseContent(newX, newY) == Physique.type.projectile)
			{
				Projectile p =((Projectile) detail(newX, newY));
				mob.tuer();
				Projectile.setIdMort(p.getId());
				p.tuer();
				return true;
			}
			*/
			if(caseContent(newX, newY) == Physique.type.tank)
			{
				mob.tuer();
				Tank t = (Tank)detail(newX, newY);
				t.Subit(((Projectile)mob).getDegatsProjectile());
				return t.getId();
			}

		}
		
	/*	if(mob.getType() == Physique.type.tank){
			if(caseContent(newX, newY) == Physique.type.projectile)
			{
				((Tank) mob).Subit(((Projectile)detail(newX, newY)).getDegatsProjectile());
				((Projectile) detail(newX, newY)).tuer();
				return true;
			}
		}
	*/	
		return -2;
	}

	protected void erase(int x, int y)
	/**
 	* enleve du Terrain l'objet en (x,y)
	* @param x  absyss
	* @param y  ordonnée
 	*/
	{
		terrain[x][y] = Vide.getVide();
	}

	protected void addObjetTT(int x, int y, ObjetTT obj)
	/**
 	* ajoute obj sur le Terrain
	* @param x    absyss
	* @param y    ordonnée
	* @param obj  objet à ajouter
 	*/
	{
		terrain[x][y] = obj;
	}
	
	protected void setMap(ObjetTT terrain[][])
	/**
 	* met à jours le Terrain (tableau d'objet)
	* @param terrain
	* */
	{
		this.terrain = terrain;
	}
	
	protected void newMur(int x, int y){
		if(estLibre(x,y))
			terrain[x][y] = Mur.getMur();
	}

}
