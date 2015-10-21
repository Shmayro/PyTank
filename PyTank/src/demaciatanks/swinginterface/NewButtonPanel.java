package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class NewButtonPanel extends JPanel {

	private static final long serialVersionUID = -2862434094133768587L;

	NewFileButton button;
	
	public NewButtonPanel() {
		button = new NewFileButton();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS ));
		this.add(Box.createHorizontalGlue());
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(button);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
	}
	
	public NewFileButton getButton() {
		return button;
	}

}
