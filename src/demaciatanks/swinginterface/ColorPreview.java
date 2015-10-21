package demaciatanks.swinginterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ColorPreview extends JComponent {

	public static final int preview_size = 60;
	
	private static final long serialVersionUID = -1761282356639888597L;

	Color color;
	
	public ColorPreview(ColorSelectionPanel panel) {
		panel.addColorChangeListener(new ColorPreviewListener());

		this.setPreferredSize(new Dimension(preview_size, preview_size));
		this.setMaximumSize(new Dimension(preview_size, preview_size));
	}
	
	public void setColor(Color color) {
		this.color = color;
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public class ColorPreviewListener implements ColorSelectionPanel.ColorChangeListener {

		@Override
		public void onColorChange(Color color) {
			setColor(color);
		}
		
	}

}
