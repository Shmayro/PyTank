package thinktank.javabot.intelligences;

import thinktank.javabot.physics.Physique;
import thinktank.javabot.physics.Tank;
import thinktank.javabot.sensors.DetectionLigneDroite;

// TODO: Auto-generated Javadoc
/**
 * The Class TankRemote.
 */
public class TankRemote {
	
	/** The tank phy. */
	Tank tankPhy;
	
	/** The lock. */
	boolean lock = true; //Verrou de la télécommande
	
	/** The ia. */
	Intelligence ia;
	
	/**
	 * Instantiates a new tank remote.
	 *
	 * @param ia the ia
	 * @param tankPhy the tank phy
	 */
	TankRemote(Intelligence ia, Tank tankPhy){
		this.ia = ia;
		this.tankPhy = tankPhy;
	}
	
	/**
	 *  Vérrouille la télécommande, l'IA associée s'endors. */
	public synchronized void lock()
	
	{
		lock = true;
	}
	
	/**
	 *  dévérrouille la télécommande, l'IA associée est solicité pour un calcul d'action. */
	public synchronized void unlock()
	{
		lock = false;
		notifyAll();
	}
	
	/**
	 *  Renvoie l'état du vérrou de la télécommande.
	 *
	 * @return true, if is locked
	 */
	public boolean isLocked()
	{
		return lock;
	}
	
	/**
	 *  Endors l'IA (et donc le script python) jusqu'à la prochaine demande d'action. */
	public synchronized void bePrepared()
	{
		try {
				this.lock();
				ia.noMoreRunning();
				while(isLocked())
					wait();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/* Commandes accessibles pour les scripts IA (jython/python).*/
	
	/**
	 * Do nothing.
	 */
	public void doNothing(int lineno){
		ia.setAction(Action.noAction);
		ia.getScript().setCurrentLine(lineno);
		bePrepared();
}
	
	/**
	 * Move forward.
	 */
	public void moveForward(int lineno){
			ia.setAction(Action.moveForward);
			ia.getScript().setCurrentLine(lineno);
			bePrepared();
	}
	
	/**
	 * Move backward.
	 */
	public void moveBackward(int lineno){
		ia.setAction(Action.moveBackward);
		ia.getScript().setCurrentLine(lineno);
		bePrepared();
	}
	
	/**
	 * Turn clockwise.
	 */
	public void turnClockwise(int lineno){
		ia.setAction(Action.turnClockwise);
		ia.getScript().setCurrentLine(lineno);
		bePrepared();
	}
	
	/**
	 * Turn counter clockwise.
	 */
	public void turnCounterClockwise(int lineno){
		ia.setAction(Action.turnCounterClockwise);
		ia.getScript().setCurrentLine(lineno);
		bePrepared();
	}
	
	/**
	 * Shoot.
	 */
	public void shoot(int lineno){
		ia.setAction(Action.shoot);
		ia.getScript().setCurrentLine(lineno);
		bePrepared();
	}
	
	/**
	 * Radar.
	 *
	 * @return the int
	 */
	public int radar(int lineno){
		ia.getScript().setCurrentLine(lineno);
		return 42;
	}
	
	/**
	 * Look forward.
	 *
	 * @return the intregex
	 */
	public int distanceOfForwardObstacle(int lineno){
		DetectionLigneDroite dld = ((DetectionLigneDroite) tankPhy.getSensor());
		ia.getScript().setCurrentLine(lineno);
		return  dld.detection().getDistance();
	}
	
	
	public Physique.type typeOfForwardObstacle(int lineno){
		DetectionLigneDroite dld = ((DetectionLigneDroite) tankPhy.getSensor());
		ia.getScript().setCurrentLine(lineno);
		return  dld.detection().getType();
	}
	
}