package demaciatanks.swinginterface;

import javax.swing.JTabbedPane;

import thinktank.javabot.physics.SmartCursor;
import demaciatanks.scripteditor.ScriptEditor;

public class ContentTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 6180643756314548263L;

	GraphicArenaPanel arena_panel;
	ScriptEditorPanel editor_panel;
	
	public ContentTabbedPane(MainPanel panel, SmartCursor cursor, ScriptEditor editor) {
		arena_panel = new GraphicArenaPanel(panel, cursor);
		editor_panel = new ScriptEditorPanel(editor, this);
		
		this.addTab("Arène", arena_panel);
		this.addTab("Éditeur", editor_panel);
	}

}
