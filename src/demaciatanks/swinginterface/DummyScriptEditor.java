package demaciatanks.swinginterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class DummyScriptEditor extends JComponent {

	private static final long serialVersionUID = -5588200712593789045L;

	public DummyScriptEditor() {
		this.setMinimumSize(new Dimension(500, 500));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
