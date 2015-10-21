package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BlueSelectionPanel extends JPanel {

	private static final long serialVersionUID = 2830860790973993276L;

	BlueSlider slider;
	BlueStatus status;
	
	public BlueSelectionPanel() {
		slider = new BlueSlider();
		status = new BlueStatus(slider);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(slider);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(status);
	}
	
	public BlueSlider getSlider() {
		return slider;
	}

}
