package demaciatanks.swinginterface;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSelectionPanel extends JPanel {
	
	public static final int COLOR_MIN = 0;
	public static final int COLOR_MAX = 255;
	public static final int COLOR_INIT = 0;
	public static final int MAX_SLIDERS_SIZE = 200;

	private static final long serialVersionUID = -4161101388121038004L;

	RedSelectionPanel 	red_panel;
	GreenSelectionPanel green_panel;
	BlueSelectionPanel 	blue_panel;
	
	SubColorChangeListener change_listener;
	
	public interface ColorChangeListener {
		void onColorChange(Color color);
	}
	
	List<ColorChangeListener> listeners;
	
	public ColorSelectionPanel() {
		red_panel = new RedSelectionPanel();
		green_panel = new GreenSelectionPanel();
		blue_panel = new BlueSelectionPanel();
		
		change_listener = new SubColorChangeListener();
		
		red_panel.getSlider().addChangeListener(change_listener);
		green_panel.getSlider().addChangeListener(change_listener);
		blue_panel.getSlider().addChangeListener(change_listener);
		
		listeners = new LinkedList<ColorChangeListener>();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(red_panel);
		this.add(green_panel);
		this.add(blue_panel);
	}
	
	public void addColorChangeListener(ColorChangeListener listener) {
		listeners.add(listener);
	}

	public void removeColorChangeListener(ColorChangeListener listener) {
		listeners.remove(listener);
	}
	
	public void notifyColorChange() {
		Color new_color = new Color(
					red_panel.getSlider().getValue(),
					green_panel.getSlider().getValue(),
					blue_panel.getSlider().getValue()
					);
		
		for(ColorChangeListener listener : listeners)
			listener.onColorChange(new_color);
	}
	
	public class SubColorChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			notifyColorChange();
		}
	}
	
}
