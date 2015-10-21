package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private static final long serialVersionUID = -3711670142141457320L;
	
	ColorSelectionPanel selection_panel;
	ColorPreview preview;
	
	public ColorPanel() {
		selection_panel = new ColorSelectionPanel();
		preview = new ColorPreview(selection_panel);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(preview);
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		this.add(selection_panel);
	}

}
