package demaciatanks.swinginterface;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

@Deprecated
public class FileBoxesListPanel extends JPanel {

	private static final long serialVersionUID = 7329447505383837662L;

	public FileBoxesListPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addFileBox(JComponent box) {
		this.add(box);
	}

}
