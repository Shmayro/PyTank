package thinktank.javabot.graphics;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import thinktank.javabot.physics.Physique;


@SuppressWarnings("serial")
public class MainWindow extends JFrame{

	private static PanneauDessin game;
	public static MainWindow window = new MainWindow();
	private static JPanel container;
	public static Physique phy;
	
	/**
	 * Affichage principal de l'application
	 **/

	public MainWindow() {
		int lx = 30;
		int ly = 22;
		phy = new Physique(lx, ly);
		game = new PanneauDessin(phy);
		
		this.setTitle("JavaBot");
		this.setSize(740, 560);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container = new JPanel();
        

		container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
		

		
		container.add(game);
		
		
		
		this.setContentPane(container);
		this.setResizable(false);
		this.setVisible(true); 
		game.repaint();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		GraphicInterface NewGame = new GraphicInterface();
		//NewGame.lancement();
		
		
		NewGame.jPanel5.add(container);
		
		//NewGame.setResizable(false);
		
		
		//NewGame.jPanel5.add(c2);
		NewGame.setVisible(true);
		Point p = NewGame.getLocationOnScreen();
		System.out.println(p.getX());
		System.out.println(p.getY());
		this.setVisible(false); 
	
	}
	
	public static PanneauDessin getPanneauDessin()
	{
		return game;
	}
	
	public static JPanel getContainer()
	{
		return container;
	}
	
	/**
	 * Ajoute un block de mur aux coordonées (x;y). Retourne true s'il n'y a 
	 * pas eu d'erreur. Méthode verbeuse sur l'erreur.
	 * 
	 * @param x coordonnée sur les abscisses
	 * @param y coordonnée sur les ordonnées
	 * @return false s'il s'est produit une erreur
	 */
	public boolean addWall(int x, int y) {
		if(x < 0 || y < 0) {
			System.err.println("Error : impossible to add a wall at (" + x + "," + y + ")");
			return false;
		}
		phy.newMur(x, y);
		return true;
	}
	
	public void mainLoop() {
		while (true) {
			if (GraphicInterface.stoped != 1 || GraphicInterface.NextStepFlag) {
				phy.iter();
				/*
				 * if(GraphicInterface.NextStepFlag)
				 * GraphicInterface.NextStepFlag=false;
				 */
			}
			game.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}