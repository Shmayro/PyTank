package thinktank.javabot.physics;

import java.util.ArrayList;




public class Physique {
	
	private Terrain map;
	private int lignes = 42;
	private int colonnes = 24;
	
	public enum type{
		tank,
		vide,
		projectile,
		mur
	}
	
	public int getLignes(){
		return lignes;
	}
	
	public int getColonnes(){
		return colonnes;
	}
	
	public boolean isAffichageOn() {
		return map.isAffichageOn();
	}
	
	public void AffichageOn() {
		map.AffichageOn();
	}
	
	public void AffichageOff() {
		map.AffichageOff();
	}

	
	public Physique(){
		map = new Terrain(lignes, colonnes);
	}
	public Terrain getMap(){
		return map;
	}
	
	public ObjetTT[][] getTerrain() 
	/**
	 * retourne la matrice du terrain
	 */
	{
		return map.getMap();
	}
	
	public int tailleX()
	/**
	 * retourne la taille abscisse de la matrice
	 */
	{
		return map.tailleX();
	}
	
	public int tailleY()
	/**
	 * retourne la taille ordonnée de la matrice
	 */
	{
		return map.tailleY();
	}
	
	public ObjetTT detail (int x, int y)
	/**
	 * retourne l'objet à la position (x,y)
	 */
	{
			return map.detail(x, y);
	}
	
	public boolean estLibre(int x, int y){
		return map.estLibre(x, y);
	}
	
	public ArrayList<Tank> getTanks()
	/**
	 * retourne la liste des Tanks
	 */
	{
		return map.getTanks();
	}
	
	public void addTank()
	/**
	 * ajoute un tank par defaut
	 */
	{
		map.addTank();
	}
	
	public void addTank(Tank tank){
		map.addTank(tank);
	}
	
	public void removeTank(Tank tank){
		map.removeTank(tank);
	}
	
	public void addTank(String filepath)
	/**
	 * ajoute un tank avec l'ia dans le fichier filepath
	 * @param filepath  position du fichier
	 */
	{
		map.addTank(filepath);
	}
	
	public void addTank(int x, int y, String filepath)
	/**
	 * ajoute un tank avec l'ia dans le fichier filepath à la position(x,y)
	 * @param x  coordonée x du tank
	 * @param y  coordonée y du tank
	 * @param filepath position du fichier
	 */
	{
		if(estLibre(x, y))
			map.addTank(x,y,filepath,this);
	}
	
	public ArrayList<Projectile> getProjectiles()
	/**
	 * retourne la liste des Projectiles
	 */
	{
		return map.getProjectiles();
	}
	
	public ArrayList<Mobile> getMobiles()
	/**
	 * retourne la liste des Mobiles
	 */
	{
		ArrayList<Mobile> m = new ArrayList<Mobile>();
		for(Tank t : getTanks())
			m.add(t);
		for(Projectile p : getProjectiles())
			m.add(p);
		return m;
	}
	
	public type caseContent(int x, int y)
	/**
	 * retourne le type contenu dans la case(x,y)
	 */
	{
		return map.caseContent(x, y);
	}
	
	public void newMur(int x, int y){
		map.newMur(x, y);
	}
	
	public void iter(){
		/**
	 	* lance la prochaine action de tout les éléments du Terrain
	 	*/
		
		int i = 0;
		
		for(Tank t : getTanks()){
			t.lancerIA();
			t.reduireTempsRestant();
		}
		
		ArrayList<Projectile> ps = map.getProjectiles();
		if(ps.size() > 0){
			Projectile p = ps.get(i);
			while(p != null && i < ps.size()){
				p.avancer();
				if(i < ps.size()){
					if( !p.getMort()){
						i++;
						if(i < ps.size())
							p = ps.get(i);
					}
					else
						if(Projectile.getIdMort() == -1)
							p=ps.get(i);
						else{
							if(p.getId() > Projectile.getIdMort()){
								i = i--;
								if(i < ps.size())
									p = ps.get(i);
							}
							else{
								if(i < ps.size())
									p = ps.get(i);
							}
							Projectile.initIdMort();
						}
				}
			}
		}
		
		
		//Tank.getIntels().waitForAllActions();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		i = 0;
		ArrayList<Tank> ts = getTanks();
		if(ts.size() > 0){
			Tank t = ts.get(i);
			while(t != null && i < ts.size()){
				t.getAction();
				if(i < ts.size()){
					if( !t.getMort()){
						i++;
						if(i< ts.size())
							t = ts.get(i);
					}
				else
					t = ts.get(i);
				}
			}
		}
		
		
	}
	
	
	
	
}


