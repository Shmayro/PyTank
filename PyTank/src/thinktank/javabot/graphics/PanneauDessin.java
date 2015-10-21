package thinktank.javabot.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import thinktank.javabot.physics.ObjetTT;
import thinktank.javabot.physics.Physique;
import thinktank.javabot.physics.Tank;


@SuppressWarnings("serial")
public class PanneauDessin extends JPanel {

	private static int tailleCase = 24;
	Physique physique;
	ObjetTT contenu; // Inutile ! à enlever ! - Pacôme
	SpriteSet sp = new SpriteSet();
	Sprite mur = new Sprite("ressources/mur.png");
	Sprite sol = new Sprite("ressources/sol.png");
	Sprite projectile = new Sprite("ressources/shot.png");
	
	public PanneauDessin(Physique physique){
		super();
		this.physique =  physique;
	}
	
	
	/**
	 * Fonctions de dessins pour les divers éléments du jeu
	 * @param g Outil de dessin permettant de définir l'affichage à l'écran
	 **/
	public void paintComponent(Graphics g) 
    {     
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int lx = 42;
		int ly = 24;
		
		for(int i = 0; i < lx; i++){
			for(int j = 0; j< ly; j++){
				
				int x = i*tailleCase;
				int y = j*tailleCase;
				
				contenu = physique.detail(i, j);
				
				if(contenu.getType() == Physique.type.vide){
					//g.drawImage(sol.getImg(),x,y,tailleCase,tailleCase,null);
					
				}
				else if(contenu.getType() == Physique.type.mur){
					g.drawImage(mur.getImg(),x,y,tailleCase,tailleCase,null);
				}
				else if(contenu.getType() == Physique.type.tank){
					
					
					int dy = ((Tank)contenu).getDirection().getDy();
					int dx = ((Tank)contenu).getDirection().getDx();
					int ni=0;
					
					if(dx < 0)
						ni = 2;
					if(dx > 0)
						ni = 3;
					if(dy < 0)
						ni = 0;
					if(dy > 0)
						ni = 1;
					
					
					int vie = Integer.valueOf(((Tank)contenu).getPointsDeVie());
					
					g.drawImage(sp.getImg(ni),x,y,tailleCase,tailleCase,null);
					g.setColor(Color.CYAN);
					g.fillRect(x, y-10, 24*vie/100, 5);
					g.setColor(Color.WHITE);
					g.drawRect(x, y-10, 24, 5);
	
					
				}
				else if(contenu.getType() == Physique.type.projectile){
					g.drawImage(projectile.getImg(),x,y,tailleCase,tailleCase,null);
				}		
			}
		}
		
		
		
    }


}
