package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import demaciatanks.scripteditor.ScriptEditor;

public class ScriptEditorPanel extends JPanel {

	private static final long serialVersionUID = 1357837127265488294L;

	ScriptEditor editor;
	ScriptEditorToolsPanel tools_panel;
	
	public ScriptEditorPanel(ScriptEditor editor, ContentTabbedPane super_pane) {
		this.editor = editor;
		editor.setSuper(super_pane);
		tools_panel = new ScriptEditorToolsPanel(editor);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(editor);
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(tools_panel);
		this.add(Box.createRigidArea(new Dimension(0, 5)));
	}

}
