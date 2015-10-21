package thinktank.javabot.sensors;


import thinktank.javabot.physics.Physique;
import thinktank.javabot.physics.Tank;


public class DetectionLigneDroite implements Sensors {
	private Tank objTank;
	private Physique physique;
	
	public DetectionLigneDroite(Tank objTank, Physique physique) {
		this.objTank = objTank;
		this.physique = physique;
	}
	
	
	public ResultsDLD detection() {
		int x = objTank.getCoordX();
		int y = objTank.getCoordY();
		int dx = objTank.getDirection().getDx();
		int dy = objTank.getDirection().getDy();
		
		for(int i=1;i<=10;i++){
			Physique.type contenu = physique.caseContent(x+i*dx,y+i*dy);
			if(contenu != Physique.type.vide){
				return  new ResultsDLD(i, contenu);
			}
		}
		
		return new ResultsDLD(0, Physique.type.vide);
	}

}
