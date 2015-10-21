package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import thinktank.javabot.graphics.GraphicArena;

public class GraphicArenaToolsPanel extends JPanel {
	
	private static final long serialVersionUID = -7552492479405461674L;
	
	StartButton button;
	//ColorPanel color_selector;
	TankInformation information;
	
	public GraphicArenaToolsPanel(GraphicArena arena) {
		button = new StartButton();
		//color_selector = new ColorPanel();
		information = new TankInformation(arena);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		//this.add(color_selector);
		this.add(information);
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		this.add(Box.createHorizontalGlue());
		this.add(button);
		this.add(Box.createRigidArea(new Dimension(5, 0)));
	}

}
