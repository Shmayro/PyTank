package thinktank.javabot.physics;

import java.util.Random;

import com.ziclix.python.sql.handler.UpdateCountDataHandler;

import thinktank.javabot.graphics.GraphicInterface;
import thinktank.javabot.intelligences.Action;
import thinktank.javabot.intelligences.Intelligence;
import thinktank.javabot.intelligences.Intelligences;
import thinktank.javabot.sensors.DetectionLigneDroite;
import thinktank.javabot.sensors.Sensors;

public class Tank extends Mobile {
	private Arme arme;
	private int pointsDeVie = 100;
	//private int i=0;//pour les testes sans l'ia
	private Intelligence ia;
	private static Intelligences intels = new Intelligences();
	private Sensors sensor;
	public String tc;
	

	public Sensors getSensor() {
		return sensor;
	}

	public void setSensor(Sensors sensor) {
		this.sensor = sensor;
	}

	public static Intelligences getIntels() {
		return intels;
	}
	public Intelligence getIntel()
	{
		return ia;
	}
	private int Alea(int valeurMin, int valeurMax) 
	/**
 	* renvoie un nombre entre borne inférieure et borne supérieure
	* @param valeurMin borne inférieure
 	* @param valeurMax borne supérieure
 	*/
	{
		Random r = new Random();
		return valeurMin + r.nextInt(valeurMax - valeurMin);
	}

	protected Tank(Terrain map) {
		setId(newId());
		setCoordX(Alea(1, map.tailleX() - 1));
		setCoordY(Alea(1, map.tailleY() - 1));

		while (!map.estLibre(getCoordX(), getCoordY())) {
			setCoordX(Alea(1, map.tailleX() - 1));
			setCoordY(Alea(1, map.tailleY() - 1));
		}

		arme = new Arme();
		setArme(arme);
		setMap(map);
		setDirection(new Direction(0, 1));
		ia = intels.newIntelligence("src/ressources/tank1.py",this);
		ia.initialize();
	}
	
	public void setIntelligence(Intelligence i)
	{
		ia = i;
		ia.start();
	}
	
	protected Tank(Terrain map, String filepath) {
		setId(newId());
		setCoordX(Alea(1, map.tailleX() - 1));
		setCoordY(Alea(1, map.tailleY() - 1));

		while (!map.estLibre(getCoordX(), getCoordY())) {
			setCoordX(Alea(1, map.tailleX() - 1));
			setCoordY(Alea(1, map.tailleY() - 1));
		}
		

		arme = new Arme();
		setArme(arme);
		setMap(map);
		setDirection(new Direction(0, 1));
		ia = intels.newIntelligence(filepath,this);
		ia.initialize();
	}

	protected Tank(int x, int y, Terrain map,String tc) {
		setId(newId());
		this.tc=tc;
		setCoordX(x);
		setCoordY(y);

		arme = new Arme();
		setArme(arme);
		setMap(map);
		setDirection(new Direction(0, 1));
		ia = intels.newIntelligence("src/ressources/tank1.py",this);
		ia.initialize();
		
	}
	
	protected Tank(int x, int y, Terrain map,String filepath, Physique physique,String tc) {
		setId(newId());
		this.tc=tc;
		setCoordX(x);
		setCoordY(y);

		arme = new Arme();
		setArme(arme);
		setMap(map);
		setDirection(new Direction(0, 1));
		ia = intels.newIntelligence(filepath,this);
		ia.start();
		sensor = new DetectionLigneDroite(this, physique);
	}


	protected void reduireTempsRestant() {
		/**
	 	* reduit le temps de recharge de l'arme
	 	*/
		arme.reduireTempsRestant();
	}
	
	public Arme getArme()
	/**
 	* renvoie l'arme équipée sur le tank
 	*/
	{
		return arme;
	}

	protected void setArme(Arme arme) 
	/**
 	* met à jours l'arme équipée
	* @param arme  nouvelle arme
 	*/
	{
		this.arme = arme;
	}

	protected void tirer() 
	/**
 	* crée un Projectile devant le tank, ou reduit le temps de rechage de l'arme
 	*/
	{
		if (getMap().estLibre(getCoordX() + getDirection().getDx(),
				getCoordY() + getDirection().getDy())) {
			Direction d = new Direction(getDirection().getDx(), getDirection().getDy());
			Projectile p = arme.creerProjectile(getCoordX()
					+ getDirection().getDx(), getCoordY()
					+ getDirection().getDy(), d, getMap());

			getMap().setProjectile(p);

		} 
	}

	public int getPointsDeVie() 
	/**
 	* renvoie les points de vie du tank
 	*/
	{
		return pointsDeVie;
	}

	protected void Subit(int dommage) 
	/**
 	* reduit les points de vies du tank de "dommage"
	* @param dommage  degats subit par le tank
 	*/
	{
		this.pointsDeVie = pointsDeVie - dommage;
		if(pointsDeVie <= 0){ 
			pointsDeVie = 0;
			tuer();
		}
	}

	public Physique.type getType()
	/**
 	* renvoie le type tank
 	*/
	{
		return Physique.type.tank;
	}

	protected void tuer() {
		
		getMap().erase(getCoordX(), getCoordY());
		meurt();
		
		if (GraphicInterface.getSelectedTank() == this)
			GraphicInterface.setSelectedTank(null);
		getMap().removeTank(this);
		
		if (GraphicInterface.getSelectedTank() == null)
		{
			System.out.println("UPDATE");
			GraphicInterface.updateListTanksOnMap();
			

			
		}
	}

	protected void action(Action act) 
	/**
 	* réalise l'action donnée par l'IA
	* @param act  action donnée par l'IA
 	*/
	{
		System.out.println("Action "+act);
		if (getLatence() > 0) {
			setLatence(getLatence() - 1);
			return;
		}
		
		if (pointsDeVie <= 0)
			return;

		switch (act) {
		case moveForward:
			if (avancer() != -2) /*Si le mobile peut avancer */
			{
				setDeplacementStatus(Action.moveForward);
				initAvancement(100);
			}
			setLatence(0);
			break;

		case moveBackward:
			if (reculer() != -2) /*Si le mobile peut reculer */
			{
				setDeplacementStatus(Action.moveBackward);
				initAvancement(-100);
			}
			setLatence(0);
			break;

		case shoot:
			tirer();
			setLatence(0);
			break;

		case turnClockwise:
			getDirection().tournerDroite();
			setDeplacementStatus(Action.turnClockwise);
			initAvancement(100);
			setLatence(0);
			break;

		case turnCounterClockwise:
			getDirection().tournerGauche();
			setDeplacementStatus(Action.turnCounterClockwise);
			initAvancement(100);
			setLatence(0);
			break;

		default:
			break;
		}

	}
	
	protected void lancerIA(){
		if (getLatence() == 0) {
			ia.computeAction();
		}
	}

	public void getAction() 
	/**
 	* renvoie l'action ordonnée par l'IA
 	*/
	{
		Action act =  Action.noAction;
		if (getLatence() > 0) {
			setLatence(getLatence() - 1);
			return;
		}
		
		if(ia.getAction() != null){
			act = ia.getAction();
			if(getMap().isAffichageOn())
				System.out.println("id: "+getId()+" act: "+act);
		}
		action(act);
	}




}
