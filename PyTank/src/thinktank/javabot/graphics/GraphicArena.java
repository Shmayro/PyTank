package thinktank.javabot.graphics;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;

import demaciatanks.swinginterface.MainPanel;
import demaciatanks.swinginterface.StartButton;
import thinktank.javabot.physics.DTank;
import thinktank.javabot.physics.ObjetTT;
import thinktank.javabot.physics.Physique;
import thinktank.javabot.physics.SmartCursor;
import thinktank.javabot.physics.Tank;

public class GraphicArena extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 46483486L;
	
	public static final int pixel_size = 32;
	
	private Physique physics = new Physique();
	private Tank highlightTank;
	private SmartCursor cursor;
	public final static int tailleCase = 32;
	public final static ImageLoader imgLoader = new ImageLoader();
	@SuppressWarnings("unused")
	private MainPanel panel;
	private SimulationThread thread;
	
	private List<TankSelectionListener> selection_listeners;
	
	public interface TankSelectionListener {
		public void onSelection(DTank tank);
	}
	
	private List<SimulationListener> simulation_listeners;
	
	public interface SimulationListener {
		public void onStart();
		public void onStop();
	}
	
	public GraphicArena(MainPanel panel, SmartCursor cursor){
		this.panel = panel;
		this.cursor = cursor;
		thread = null;
		selection_listeners = new LinkedList<TankSelectionListener>();
		simulation_listeners = new LinkedList<SimulationListener>();
		/*addDTank(1, 1);
		addDTank(10, 10);
		addDTank(30, 20);
		addDTank(15, 17);*/
		GraphicArenaMouseListener list = new GraphicArenaMouseListener();
		this.addMouseListener(list);
		this.addMouseMotionListener(list);
	}
	
	public void setStartButton(StartButton button) {
		button.addActionListener(new SimulationLauncher());
	}
	
	public void addTankSelectionListener(TankSelectionListener listener) {
		selection_listeners.add(listener);
	}
	
	public void removeTankSelectionListener(TankSelectionListener listener) {
		selection_listeners.remove(listener);
	}
	
	public void triggerTankSelectionListeners(DTank selected_tank) {
		for(TankSelectionListener listener : selection_listeners)
			listener.onSelection(selected_tank);
	}
	
	public void addSimulationListener(SimulationListener listener) {
		simulation_listeners.add(listener);
	}
	
	public void removeSimulationListener(SimulationListener listener) {
		simulation_listeners.remove(listener);
	}
	
	public void onSimulationStart() {
		for(SimulationListener listener : simulation_listeners)
			listener.onStart();
	}
	
	public void onSimulationStop() {
		for(SimulationListener listener : simulation_listeners)
			listener.onStop();
	}
	
	void moveTankTo(Tank tank, int coord_x, int coord_y) {
		int old_x = tank.getCoordX(), old_y = tank.getCoordY();
		if(coord_x == old_x && coord_y == old_y) return;
		
		if(coord_x < 0 || coord_x >= physics.getLignes() ||
		   coord_y < 0 || coord_y >= physics.getColonnes())
			physics.getMap().erase(old_x,old_y);
		else if( physics.getMap().TestAndSetCase(tank, coord_x, coord_y))
		{
			tank.setCoordX(coord_x);
			tank.setCoordY(coord_y);
			physics.getMap().erase(old_x,old_y);

		}
	}
	
	void eraseTank(Tank tank) {
		if( tankIsIn(tank) )
			physics.getMap().erase(tank.getCoordX(), tank.getCoordY());
	}
	
	boolean findOpenSpace(int x, int y, int radius, Point point) {
		if( radius <= 0 ) return false;
		
		if( physics.getMap().estLibre(x + 1, y + 0) ) {
			point = 		new Point(x + 1, y + 0);
			return true;
		}
		
		if( physics.getMap().estLibre(x - 1, y + 0) ) {
			point = 		new Point(x - 1, y + 0);
			return true;
		}
		
		if( physics.getMap().estLibre(x + 0, y + 1) ) {
			point = 		new Point(x + 0, y + 1);
			return true;
		}
		
		if( physics.getMap().estLibre(x + 0, y - 1) ) {
			point = 		new Point(x + 0, y - 1);
			return true;
		}
		
		if( findOpenSpace(x + 1, y + 0, radius - 1, point) )
			return true;
		if( findOpenSpace(x - 1, y + 0, radius - 1, point) )
			return true;
		if( findOpenSpace(x + 0, y + 1, radius - 1, point) )
			return true;
		if( findOpenSpace(x + 0, y - 1, radius - 1, point) )
			return true;
			
			
		return false;
	}
	
	class SimulationThread extends Thread {
		 @Override
		 public void run() {
			while(true){
					
				physics.iter();
				repaint();
					
			}
		 }
	}
	
	class SimulationLauncher implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if( ! (e.getSource() instanceof StartButton) ) return;
			
			StartButton button = (StartButton) e.getSource();
			
			if(thread == null) {
				thread = new SimulationThread();
				onSimulationStart();
				button.setStopText();
				thread.start();
			}
			else {
				onSimulationStop();
				button.setStartText();
				thread.stop();
				thread = null;
			}
		}
		
	}
	
	class GraphicArenaMouseListener 
		implements MouseListener, MouseMotionListener{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			ObjetTT contenu;
			Point2D pointUsable = getPhysicPoint(arg0.getX(), arg0.getY());
			int i = (int) (pointUsable.getX());
			int j = (int) (pointUsable.getY());
			
			contenu = physics.detail(i, j);
			if(contenu.getType()==Physique.type.tank) {
				highlightTank = (Tank) contenu;
				triggerTankSelectionListeners((DTank) contenu);
			}
			else
				highlightTank = null;
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			if(cursor.isActive()){
				
				Point2D pointGraphic = getPhysicPoint(arg0.getX(), arg0.getY());

				/*if(! physics.getMap().estLibre((int) pointGraphic.getX(), (int) pointGraphic.getY()) )
					if( ! findOpenSpace((int) pointGraphic.getX(), (int) pointGraphic.getY(), 3, (Point) pointGraphic) )
						return;*/
				
				int x = (int) (pointGraphic.getX());
				int y = (int) (pointGraphic.getY());

				addDTank(cursor.getTank());
				moveTankTo(cursor.getTank(), x, y);
				cursor.desactivate();
				repaint();
			}
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			if(cursor.isActive()){
				removeObject(cursor.getTank());
				repaint();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			if(! cursor.isActive()){
				Point2D pointGraphic = getPhysicPoint(arg0.getX(), arg0.getY());
				
				Tank tank = getTankAt((int) pointGraphic.getX(), (int) pointGraphic.getY());
				if( tank != null ) {
					cursor.setTank((DTank) tank); 
					//eraseTank(tank);
					repaint();
				}
				
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			if(cursor.isActive()){
				Point2D pointGraphic = getPhysicPoint(arg0.getX(), arg0.getY());
				
				int x = (int) (pointGraphic.getX());
				int y = (int) (pointGraphic.getY());

				moveTankTo(cursor.getTank(), x, y);
				cursor.desactivate();
				repaint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			if(cursor.isActive()){
				Point2D pointGraphic = getPhysicPoint(arg0.getX(), arg0.getY());
				
				int x = (int) (pointGraphic.getX());
				int y = (int) (pointGraphic.getY());

				moveTankTo(cursor.getTank(), x, y);
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			if(cursor.isActive()){
				Point2D pointGraphic = getPhysicPoint(arg0.getX(), arg0.getY());
				
				int x = (int) (pointGraphic.getX());
				int y = (int) (pointGraphic.getY());

				moveTankTo(cursor.getTank(), x, y);
				cursor.desactivate();
				repaint();
			}
		}
		
	}

	/*public Point2D create_point(int x, int y){
		Point2D point = new Point(x,y), pointUsable = new Point();
		try {
			transform.createInverse().transform(point, pointUsable);
		} catch (NoninvertibleTransformException e) {}
			// TODO Auto-generated catch block
		return translatePointToMainPanelInput(pointUsable);
		
	}*/
	
	public Point2D getPhysicPoint(int x, int y) {
		 int virtual_width = physics.getLignes() * pixel_size;
		 int virtual_height = physics.getColonnes() * pixel_size;
		 int real_width = getWidth();
		 int real_height = getHeight();
		 double width_ratio = real_width / (double) virtual_width;
		 double height_ratio = real_height  / (double) virtual_height;
		 double choosen_ratio = Math.min(width_ratio, height_ratio);
		 double painting_width = choosen_ratio * virtual_width;
		 double painting_height = choosen_ratio * virtual_height;
		 
		 int final_x = -1;
		 int final_y = -1;
		 
		 if( width_ratio < height_ratio ) { // cas où ça colle sur les cotés
			 final_x = (int) (x / choosen_ratio);
			 double offset_height = Math.max(real_height - painting_height, painting_height - real_height);
			 final_y = (int) ((y - offset_height/2) / choosen_ratio);
		 }
		 else {
			 final_y = (int) (y / choosen_ratio);
			 double offset_width = Math.max(real_width - painting_width, painting_width - real_width);
			 final_x = (int) ((x - offset_width/2) / choosen_ratio);
		 }
		 
		 return new Point(final_x / pixel_size, final_y / pixel_size);
	}

	public void addDTank(DTank tank){
		DTank dTank = new DTank(physics.getLignes()/2, physics.getColonnes()/2,
								physics.getMap(), tank.getColor(),
								tank.getScript_path(), imgLoader, physics);
		physics.addTank(dTank);
	}
	
	public void addDTank(int x, int y){
		Color color = null;
		DTank dTank = new DTank(x, y, physics.getMap(), color, null, imgLoader, physics);
		physics.addTank(dTank);
	}
	
	public void addObject(DTank dTank){
		physics.addTank(dTank);
	}
	public void removeObject(DTank dTank){
		physics.removeTank(dTank);
	}
	
	public Tank getTankAt(int x, int y) {
		for(Tank tank : physics.getTanks())
			if(tank.getCoordX() == x && tank.getCoordY() == y ) return tank;
		return null;
	}
	
	public boolean tankIsIn(Tank tank) {
		return ( tank.getCoordX() >= 0 && tank.getCoordX() < physics.getLignes() ) &&
			   ( tank.getCoordY() >= 0 && tank.getCoordY() < physics.getColonnes() );
	}
	
	public void paintHighlight(Graphics g,int x,int y){
		g.setColor(Color.black);
		g.drawArc(x, y, pixel_size, pixel_size, 0, 360);
		//g.drawImage(imgLoader.getSprite(ImageLoader.SpriteName.HIGHLIGHT.ordinal()), x, y, null);
	}
	
	public void centrage(Graphics g){
		Graphics2D g2;
		g2 = (Graphics2D) g;
		int largeurAffichage = physics.getLignes() * pixel_size, hauteurAffichage = physics.getColonnes() * pixel_size;
		double diffX = this.getWidth()/(double)largeurAffichage, diffY = this.getHeight()/(double)hauteurAffichage;
		if(diffY > diffX){
			g2.translate(0, Math.max(hauteurAffichage*diffX - this.getHeight(), this.getHeight() - hauteurAffichage*diffX) / 2);
			g2.scale(diffX, diffX);
			//transform = (AffineTransform) g2.getTransform();
		}
		else{
			g2.translate(Math.max(largeurAffichage*diffY-this.getWidth(), this.getWidth()-largeurAffichage*diffY)/2, 0);
			g2.scale(diffY, diffY);
			//transform = (AffineTransform) g2.getTransform();
		}
	}
	
	/*public Point2D translatePointToMainPanelInput(Point2D src) {
		Point dest = new Point();
		AffineTransform main_panel_transform = new AffineTransform();
		double x_scale_ratio = (double) panel.getWidth() / getWidth();
		double y_scale_ratio = (double) panel.getHeight() / getHeight();
		main_panel_transform.scale(1/x_scale_ratio, 1/y_scale_ratio);
		/*int ratio_x = this.getX();
		int ratio_y = this.getY();
		main_panel_transform.translate(ratio_x, ratio_y);
		main_panel_transform.transform(src, dest);
		return dest;
	}*/
	
	@Override
	public void paintComponent(Graphics g){   
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		centrage(g);
		ObjetTT contenu;
		
		for(int i = 0; i < physics.getLignes(); i++)
			for(int j = 0; j< physics.getColonnes(); j++){
				int x = i*tailleCase;
				int y = j*tailleCase;
				contenu = physics.detail(i, j);
				contenu.paint(g, x, y); 
				if(highlightTank == contenu){
					paintHighlight(g,x,y);
				}
			}
	}

}
