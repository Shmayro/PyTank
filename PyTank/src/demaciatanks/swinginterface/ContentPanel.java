package demaciatanks.swinginterface;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import thinktank.javabot.physics.SmartCursor;
import demaciatanks.scripteditor.ScriptEditor;


public class ContentPanel extends JPanel {
	
	private static final long serialVersionUID = -3145738724425444248L;

	ContentTabbedPane tabbed_pane;
	
	public ContentPanel(MainPanel panel, SmartCursor cursor, ScriptEditor editor) {
		tabbed_pane = new ContentTabbedPane(panel, cursor, editor);
		this.setLayout(new BorderLayout());
		this.add(tabbed_pane, BorderLayout.CENTER);
	}
	
	public ContentTabbedPane getTabbedPane() {
		return tabbed_pane;
	}

}
