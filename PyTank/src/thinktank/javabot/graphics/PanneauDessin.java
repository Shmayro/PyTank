package thinktank.javabot.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import thinktank.javabot.intelligences.Action;
import thinktank.javabot.physics.ObjetTT;
import thinktank.javabot.physics.Physique;
import thinktank.javabot.physics.Tank;


@SuppressWarnings("serial")
public class PanneauDessin extends JPanel implements MouseListener {

	private static int tailleCase = 24;
	Physique physique;
	ObjetTT contenu;
	SpriteSet sp = new SpriteSet();
	Sprite mur = new Sprite("src/ressources/wall1.png");
	Sprite sol = new Sprite("src/ressources/sand.png");
	Sprite projectile = new Sprite("src/ressources/shot.png");
	Point lastRegisteredMousePosition = new Point();
	AffineTransformOp op;
	
	public PanneauDessin(Physique physique){
		super();
		this.physique =  physique;
		this.addMouseListener(this);
		
	}
	
	public int getTailleCase()
	{
		return tailleCase;
	}
	
	private void paintLifeStick(Graphics g, int x, int y, int vie)
	{
		g.setColor(Color.CYAN);
		g.fillRect(x, y - 10, 24*vie/100, 5);
		g.setColor(Color.WHITE);
		g.drawRect(x, y - 10, 24, 5);
	}
	
	private void paintSelectedArea(Graphics g, int x, int y)
	{
		g.setColor(Color.blue);
		g.drawRect(x - 15, y - 15, 50, 50);
	}
	
	
	private AffineTransformOp computeRotation(Image image, Action action, int avancement)
	{
		double rotationRequired;
		if (action == Action.turnClockwise)
		{
			rotationRequired = Math.toRadians (-90 + ((100 - avancement) / 100.0) * 90);
		}
		else if (action == Action.turnCounterClockwise)
		{
			rotationRequired = Math.toRadians (90 - ((100 - avancement) / 100.0) * 90);
		}
		else
		{
			rotationRequired = Math.toRadians (0);
		}
		 
		double locationX = image.getWidth(null) / 2;
		double locationY = image.getHeight(null) / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op;
	}
	
	
	private int getPositionXFluide(Tank contenu, int x, int ni)
	{
		
		
		int posx = x;
		
		if (((Tank)contenu).getDeplacementStatus() == Action.moveForward || 
				((Tank)contenu).getDeplacementStatus() == Action.moveBackward)
		{
			switch (ni)
			{
				
				case 2: //GAUCHE
					posx = (int) (x + (((Tank)contenu).getAvancement() / 100.0) * tailleCase);
					
				break;
				
				case 3: //DROITE
				
					posx = (int) (x - (((Tank)contenu).getAvancement() / 100.0) * tailleCase);
					
				
				break;
				
				default: //BAS ET HAUT
					posx = x;
					break;
		}
				}
		return posx;
	}
	
	private int getPositionYFluide(Tank contenu, int y, int ni)
	{
		
		
		int posy = y;
		if (((Tank)contenu).getDeplacementStatus() == Action.moveForward || 
				((Tank)contenu).getDeplacementStatus() == Action.moveBackward)
		{
			switch (ni)
			{
				case 0: //HAUT
					
					posy = (int) (y + (((Tank)contenu).getAvancement() / 100.0) * tailleCase);
				
				
				break;
				
				case 1: //BAS
					
					posy = (int) (y - (((Tank)contenu).getAvancement() / 100.0) * tailleCase);
				
				break;
				
				default: //GAUCHE ET DROITE
					
					posy = y;

				break;
				
		}
				}
		return posy;
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
				
				int x = i * tailleCase;
				int y = j * tailleCase;
				
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
					int ni = 0;
					
					
					if (dy > 0)
						ni = 1;
					else if (dx != 0)
						ni = dx < 0 ? 2 : 3;
					
					
					int vie = Integer.valueOf(((Tank)contenu).getPointsDeVie());

					
					 try {
						 
						op = computeRotation(
								 sp.getImg(ni,((Tank)contenu).tc), 
								(((Tank)contenu).getDeplacementStatus()), 
								(((Tank)contenu).getAvancement())
										);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int posx = getPositionXFluide((Tank) contenu, x, ni);
					int posy = getPositionYFluide((Tank) contenu, y, ni);
					try {
						g.drawImage(op.filter(sp.getImg(ni,((Tank)contenu).tc), null), posx, posy, /*tailleCase, tailleCase,*/ null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					paintLifeStick(g, posx, posy, vie);
					
					if (GraphicInterface.getSelectedTank() == (Tank)contenu)
					{
						paintSelectedArea(g, posx, posy);
					}
				}
				else if(contenu.getType() == Physique.type.projectile){
					g.drawImage(projectile.getImg() ,x,y,tailleCase,tailleCase,null);
				}		
			}
			
			if (GraphicInterface.TankChoice != "")
			{
				try {
					g.drawImage(sp.getImg(1,GraphicInterface.TankChoice), (int)(lastRegisteredMousePosition.getX())/tailleCase * tailleCase,(int)(lastRegisteredMousePosition.getY())/tailleCase * tailleCase,  null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1)
		{
			System.out.println("x: "+e.getX()+"y: "+e.getY());
			for (Tank t: physique.getTanks())
			{
				int dy = t.getDirection().getDy();
				int dx = t.getDirection().getDx();
				int ni = 0;
				if (dy > 0)
					ni = 1;
				else if (dx != 0)
					ni = dx < 0 ? 2 : 3;
				int posX = getPositionXFluide(t, t.getCoordX()*tailleCase, ni);
				int posY = getPositionYFluide(t, t.getCoordY()*tailleCase, ni);
				System.out.println("TANK POSX: "+posX+ " POSY: "+posY);
				if (e.getX() >= posX - tailleCase && e.getX() <= posX + tailleCase && e.getY() <= posY + tailleCase && e.getY() >= posY - tailleCase)
				{
					
					GraphicInterface.setSelectedTank(t);
					return;
				}
				
			}
			GraphicInterface.checkCodeUpdates();
			GraphicInterface.setSelectedTank(null);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("x: "+e.getX()+"y: "+e.getY());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("x: "+e.getX()+"y: "+e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	public Physique getPhysique()
	{
		return physique;
	}



}
