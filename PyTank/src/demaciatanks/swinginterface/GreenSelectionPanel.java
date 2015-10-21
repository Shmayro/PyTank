package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GreenSelectionPanel extends JPanel {

	private static final long serialVersionUID = 2830860790973993275L;

	GreenSlider slider;
	GreenStatus status;
	
	public GreenSelectionPanel() {
		slider = new GreenSlider();
		status = new GreenStatus(slider);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(slider);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(status);
	}
	
	public GreenSlider getSlider() {
		return slider;
	}

}
