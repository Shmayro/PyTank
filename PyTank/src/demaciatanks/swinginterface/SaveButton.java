package demaciatanks.swinginterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import thinktank.javabot.fileManagement.FileExplorer;
import demaciatanks.scripteditor.ScriptEditor;

public class SaveButton extends JButton {

	private static final long serialVersionUID = -6935669375135143783L;

	ScriptEditor editor;
	
	public class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			FileExplorer.saveFile(editor.getFile().getPath(), editor.getText());
		}
	}
	
	public SaveButton(ScriptEditor editor) {
		this.editor = editor;
		this.setText("Sauvegarder");
		this.addActionListener(new SaveButtonListener());
	}

}
