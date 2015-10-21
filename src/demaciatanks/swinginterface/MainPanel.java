package demaciatanks.swinginterface;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import demaciatanks.scripteditor.ScriptEditor;
import thinktank.javabot.graphics.ImageLoader;
import thinktank.javabot.physics.SmartCursor;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 5131738883703122146L;

	FilePanel file_panel;
	ContentPanel content_panel;
	ImageLoader image_loader;
	SmartCursor cursor;
	ScriptEditor editor;
	
	//int cursor_x, cursor_y;
	
	public MainPanel() {
		image_loader = new ImageLoader();
		cursor = new SmartCursor();
		editor = new ScriptEditor(cursor);
		file_panel = new FilePanel(image_loader, cursor, editor);
		content_panel = new ContentPanel(this, cursor, editor);
		//cursor_x = 0;
		//cursor_y = 0;
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(file_panel);
		this.add(content_panel);
	}
	
	/*public class MainPanelMouseListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			cursor_x = arg0.getX();
			cursor_y = arg0.getY();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			cursor_x = arg0.getX();
			cursor_y = arg0.getY();
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform transform = g2.getTransform();
		super.paintComponent(g);
		
		if( ! cursor.isActive() ) return;
		
		g2.setTransform(transform);
		cursor.paint(g2, cursor_x, cursor_y);
	}*/

}
