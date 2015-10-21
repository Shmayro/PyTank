package demaciatanks.swinginterface;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import demaciatanks.scripteditor.ScriptEditor;
import thinktank.javabot.graphics.ImageLoader;
import thinktank.javabot.physics.SmartCursor;

public class FileBoxesScrollListPanel extends JPanel {
	
	private static final long serialVersionUID = 219557202734968426L;

	private FileBoxesScrollPane scroll_pane;
	
	public FileBoxesScrollListPanel(ImageLoader img, SmartCursor cursor, ScriptEditor editor, NewFileButton button) {
		this.setLayout(new BorderLayout());
		scroll_pane = new FileBoxesScrollPane(img, cursor, editor, button);
		this.add(scroll_pane);
	}
	
	FileBoxesScrollPane getScrollPane() {
		return scroll_pane;
	}

}
