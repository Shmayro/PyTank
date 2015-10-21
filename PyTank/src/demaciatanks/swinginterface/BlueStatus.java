package demaciatanks.swinginterface;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BlueStatus extends JLabel {
	
	private static final long serialVersionUID = -8149401918234724016L;

	int blue_value;
	
	public BlueStatus(BlueSlider slider) {
		blue_value = ColorSelectionPanel.COLOR_INIT;
		slider.addChangeListener(new BlueSliderListener());
		
		actualiseText();
	}
	
	public void setValue(int value) {
		blue_value = value;
	}
	
	public void actualiseText() {
		String filler = "";
		if( blue_value < 10 ) filler = "      ";
		else if ( blue_value < 100 ) filler = "   ";
		this.setText("B : " + filler + blue_value);
	}
	
	protected class BlueSliderListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			BlueSlider slider = (BlueSlider) e.getSource();
			setValue(slider.getValue());
			actualiseText();
		}
	}

}
