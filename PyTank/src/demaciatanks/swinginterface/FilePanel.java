package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import demaciatanks.scripteditor.ScriptEditor;
import thinktank.javabot.graphics.ImageLoader;
import thinktank.javabot.physics.SmartCursor;

public class FilePanel extends JPanel {
	
	private static final long serialVersionUID = 7745904866479643142L;

	NewButtonPanel button_panel;
	FileBoxesScrollListPanel list_panel;
	
	public FilePanel(ImageLoader img, SmartCursor cursor, ScriptEditor editor) {
		button_panel = new NewButtonPanel();
		list_panel = new FileBoxesScrollListPanel(img, cursor, editor, button_panel.getButton());
		
		this.setMaximumSize(this.getMaximumSize());
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(button_panel);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(list_panel);
	}

}
