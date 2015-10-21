package thinktank.javabot.fileManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import demaciatanks.scripteditor.ScriptEditor;
import demaciatanks.swinginterface.FileBoxesScrollPane;
import demaciatanks.swinginterface.NewFileButton;
import thinktank.javabot.graphics.ImageLoader;
import thinktank.javabot.physics.SmartCursor;


public class FileBoxManager extends JPanel {

	private static final long serialVersionUID = -4841135013487590132L;
	static String directoryPath = "scripts";
	ImageLoader img;
	SmartCursor cursor;
	ScriptEditor editor;
	FileBoxesScrollPane scrollpane;
	
	public FileBoxManager(ImageLoader img, SmartCursor cursor, ScriptEditor editor, NewFileButton button, FileBoxesScrollPane scrollpane) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.img = img;
		this.cursor = cursor;
		this.editor = editor;
		this.scrollpane = scrollpane;
		
		loadFiles();
		
		button.addActionListener(new NewFileButtonListener());
	}
	
	
	public void loadFiles() {
		FileExplorer.checkFor(directoryPath);
		
		List<File> filesInFolder = FileExplorer.getListFile(directoryPath);
		
		this.removeAll();
		
		for(File file : filesInFolder)
			this.add(new FileBox(file, img, cursor, editor));
	}
	
	public class NewFileButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			addNewBox();
		}
		
	}
	
	public String generateFileName() {
		String base_path = "scripts/new_script_";
		String path_end = ".py";
		
		int counter = 0;
		
		while( new File(base_path + counter + path_end).exists() )
			counter++;
		
		return base_path + counter + path_end;
	}
	
	public void addNewBox() {
		String new_name = generateFileName();
		
		FileExplorer.createFile(new_name, "");
		
		loadFiles();
		
		scrollpane.validate();
		scrollpane.repaint();
	}
	
	public void addFileBox(File file) {
		System.out.println("adding");
		this.add(new FileBox(file, img, cursor, editor));
	}

}