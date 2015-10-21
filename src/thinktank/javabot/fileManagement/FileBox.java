package thinktank.javabot.fileManagement;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;

import demaciatanks.scripteditor.ScriptEditor;
import thinktank.javabot.graphics.ImageLoader;
import thinktank.javabot.physics.DTank;
import thinktank.javabot.physics.SmartCursor;


public class FileBox extends JButton {

	private static final long serialVersionUID = -971009625896928830L;
	private File file;
	ImageLoader img;
	SmartCursor cursor;
	ScriptEditor editor;
	
	public FileBox(File file, ImageLoader img, SmartCursor cursor, ScriptEditor editor)
	{
		this.setFile(file);
		this.setText(file.getName());
		this.img = img;
		this.cursor = cursor;
		this.editor = editor;
		this.addMouseListener(new FileBoxMouseListener());
	}
	
	public class FileBoxMouseListener implements MouseListener {
		
		boolean in_frame;

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			in_frame = true;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			in_frame = false;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			DTank DTank = new DTank(null, file.getPath(), Color.gray, file.getPath(), img);
			cursor.setTank(DTank);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(in_frame)
			{
				editor.getSuper().setSelectedIndex(1);
				editor.openFile(file);
			}
		}

		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
