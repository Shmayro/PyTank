package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class RedSelectionPanel extends JPanel {

	private static final long serialVersionUID = 2830860790973993277L;

	RedSlider slider;
	RedStatus status;
	
	public RedSelectionPanel() {
		slider = new RedSlider();
		status = new RedStatus(slider);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(slider);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(status);
	}
	
	public RedSlider getSlider() {
		return slider;
	}

}
