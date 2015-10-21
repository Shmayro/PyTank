package demaciatanks.swinginterface;

import javax.swing.JScrollPane;

import demaciatanks.scripteditor.ScriptEditor;
import thinktank.javabot.fileManagement.FileBoxManager;
import thinktank.javabot.graphics.ImageLoader;
import thinktank.javabot.physics.SmartCursor;

public class FileBoxesScrollPane extends JScrollPane {

	private static final long serialVersionUID = -5032055368274982092L;

	FileBoxManager content;
	
	public FileBoxesScrollPane(ImageLoader img, SmartCursor cursor, ScriptEditor editor, NewFileButton button) {
		content = new FileBoxManager(img, cursor, editor, button, this);
		getViewport().add(content);
	}

	FileBoxManager getContent() {
		return content;
	}
}
