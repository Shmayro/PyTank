package thinktank.javabot.physics;

import java.io.File;
import java.util.ArrayList;

import thinktank.javabot.graphics.GraphicInterface;
import thinktank.javabot.intelligences.Action;

public class Physique {
	
	public enum type{
		tank,
		vide,
		projectile,
		mur
	}

	private int tour = 0;
	private Terrain map;

	
	public boolean isAffichageOn() {
		return map.isAffichageOn();
	}
	
	public void AffichageOn() {
		map.AffichageOn();
	}
	
	public void AffichageOff() {
		map.AffichageOff();
	}
	
	public Physique(int lignes, int colonnes){
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
	
	public Tank addTank(String filepath)
	/**
	 * ajoute un tank avec l'ia dans le fichier filepath
	 * @param filepath  position du fichier
	 */
	{
		return map.addTank(filepath);
	}
	
	public Tank addTank(int x, int y, String filepath)
	/**
	 * ajoute un tank avec l'ia dans le fichier filepath à la position(x,y)
	 * @param x  coordonée x du tank
	 * @param y  coordonée y du tank
	 * @param filepath position du fichier
	 */
	{
		if(estLibre(x, y))
			return map.addTank(x,y,filepath,this);
		else
			System.out.println("pas libre ! ");
		return null;
	}
	
	/*public ArrayList<Projectile> getProjectiles()
	**
	 * retourne la liste des Projectiles
	 *
	{
		return map.getProjectiles();
	}*/

	
	public ArrayList<Mobile> getMobiles()
	/**
	 * retourne la liste des Mobiles
	 */
	{
		ArrayList<Mobile> m = new ArrayList<Mobile>();
		for(Tank t : getTanks())
			m.add(t);

	/*	for(Projectile p : getProjectiles())
			m.add(p);*/

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
	
	public boolean iterFluidite(Mobile t)
	{
		if (t.getAvancement() != 0)
		{
			if (t.getDeplacementStatus() == null)
				return true;
			if (t.getDeplacementStatus() ==  Action.moveBackward)
			{
				t.incAvancement(Mobile.vitesseAvancement);
				return true;
			}
			else
			{
				
				t.decAvancement(Mobile.vitesseAvancement);
				return true;
			}
		}
		return false;
	}
	
	public void iter(){
		/**
	 	* lance la prochaine action de tout les éléments du Terrain
	 	*/
		GraphicInterface.updateOutputArea();

		Tank t;
		int mobId;
		System.out.println(map.getProjectile());
		if (map.getProjectile() != null)
		{
			if (iterFluidite(map.getProjectile()))
				return;
			
			mobId = map.getProjectile().avancer();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			/* Si un tank est détruit et qu'il était placé avant ou à à l'emplacement du tour courant dans la liste, on ne modifie pas le tour courant
			 * La suppression d'un élément d'un arraylist décale automatiquement tous les autres éléments vers la gauche.
			 * tour = tour - 1;
			 */
			if (mobId != -1) /* Un tank est détruit par le projectile */
			{
				for (int j = 0; j < getTanks().size() && j <= tour; j++ )
				{
					if (getTanks().get(j).getId() == mobId)
					{
						tour--;
						break;
					}
				}
			}
			
		}
		else
		{
			if (getTanks().size() != 0)
			{
				t = getTanks().get(tour % getTanks().size());
				
				if (iterFluidite(t))
					return;
				
				
				t.setDeplacementStatus(null);
				tour = (tour + 1) % getTanks().size();
				System.out.println("Tour numero "+tour);
					
					t = getTanks().get(tour);
					t.lancerIA();
					
					t.reduireTempsRestant();
					
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if (GraphicInterface.stoped == 2)
					{
						GraphicInterface.stoped = 1;
						
					}
					
					t.getAction();
					if (GraphicInterface.getSelectedTank() == t)
					{
						GraphicInterface.updateHighlight(t.getIntel().getScript().getCurrentLine());
					}
					
				
					GraphicInterface.NextStepFlag = false;
					
					
			
			}
		
		
		}
	
	}

	public void destroyTank(Tank selectedTank) {
		System.out.println(getTanks().size());
	 for (int i = 0; i < getTanks().size(); i++)
		{
		 Tank t = getTanks().get(i);
			if (t == selectedTank)
			{
				File file = new File("src/ressources/"+t.getIntel().getScript().getTmpFileName());
				file.delete();
				map.erase(t.getCoordX(), t.getCoordY());
				getTanks().remove(t);
				map.removeTank(t);
				tour = 0;
			}
		}
		
	}
	
	

}


