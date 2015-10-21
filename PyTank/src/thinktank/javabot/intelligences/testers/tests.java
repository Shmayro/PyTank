package thinktank.javabot.intelligences.testers;

import thinktank.javabot.intelligences.Intelligence;
import thinktank.javabot.intelligences.Intelligences;

/**
 * Classe de test pout la partie intelligence artificielle.
 * @author cedric
 *
 */

public class tests {

	/**
	 * Crée de nombreuses IAs et les lances.
	 */
	public static void main(String[] args) {
		Intelligences intels = new Intelligences();
		
		int nbIntels = 10;
		
		Intelligence intel[] = new Intelligence[nbIntels];
		for(int i=0;i<nbIntels;i++){
			intel[i]=intels.newIntelligence("ressources/tankytourne.py",null);
			intel[i].initialize();
		}
		
		int i=0;
		int j=0;
		
		while(true){
			
			j++;
			intels.computeAllActions();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(i=0;i<nbIntels;i++)
				System.out.println("Action d'ia"+i+": "+intel[i].getAction());
			
			System.out.println("Iter n°"+j);
		}
	}	
}