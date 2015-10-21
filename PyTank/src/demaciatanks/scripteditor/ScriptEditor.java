package demaciatanks.scripteditor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import demaciatanks.swinginterface.ContentTabbedPane;
import thinktank.javabot.fileManagement.FileExplorer;
import thinktank.javabot.physics.SmartCursor;

public class ScriptEditor extends RSyntaxTextArea {

	private static final long serialVersionUID = -3906130901413802324L;
	
	File editing_file;
	ContentTabbedPane super_pane;
	SmartCursor cursor;

	public ScriptEditor(SmartCursor cursor) {
	      setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
	      setCodeFoldingEnabled(true);
	      this.cursor = cursor;
	      editing_file = null;
	      this.addMouseListener(new ScriptEditorMouseListener());
	      this.addMouseMotionListener(new ScriptEditorMouseListener());
	}
	
	public class ScriptEditorMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			if( ! cursor.isActive() ) return;
			
			openFile( cursor.getTank().getScript_path() );
			cursor.desactivate();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}

		@Override
		public void mouseDragged(MouseEvent arg0) {}

		@Override
		public void mouseMoved(MouseEvent arg0) {}
		
	}
	
	public void openFile(String path) {
		openFile( new File(path) );
	}
	
	public void openFile(File file) {
		editing_file = file;
		String content = FileExplorer.readFile(editing_file.getPath());
		setText(content);
		
		validate();
		repaint();
	}
	
	public File getFile() {
		return editing_file;
	}
	
	public void setSuper(ContentTabbedPane pane) {
		super_pane = pane;
	}

	public ContentTabbedPane getSuper() {
		return super_pane;
	}
}
