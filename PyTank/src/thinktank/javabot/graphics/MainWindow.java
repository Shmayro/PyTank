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

//	private static JFileChooser chooser = new JFileChooser();
	
	public static MainWindow window = new MainWindow();
	
	/* Coordonnées saisies par le user */
//	private static int setX;
//	private static int setY;
	
	private static JPanel container;/* = new JPanel();*/
//	private JPanel c2 = new JPanel();
	
	public static Physique phy;
	
	
	public static JPanel getContainer()
	{
		return container;
	}
	
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
	
	/**Graphics
	 * Fonction main principale
	 **/
	public static void main(String args[]) {
		
		System.out.println("TEST");

		// MAP HARD CODE
		for(int i = 5; i < 10; i++)
		{
			MainWindow.phy.newMur(i,5);
	
		}
		for(int i = 18; i < 25; i++)
		{
			MainWindow.phy.newMur(i,15);
	
		}
		for(int i = 5; i < 10 ; i++)
		{
			MainWindow.phy.newMur(30,i);
	
		}
		for(int i = 28; i < 33; i++)
		{
			//window.phy.newMur(i,20);
	
		}
		for(int i = 10; i < 15 ; i++)
		{
			MainWindow.phy.newMur(8,i);
	
		}
		
		System.out.println("TEST2");
		
		while(true){
			
			if(GraphicInterface.stoped != 1 || GraphicInterface.NextStepFlag){
				MainWindow.phy.iter();
				/*if(GraphicInterface.NextStepFlag)
					GraphicInterface.NextStepFlag=false;*/
			}
			MainWindow.game.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static PanneauDessin getPanneauDessin()
	{
		return game;
	}





}