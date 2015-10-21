package demaciatanks.swinginterface;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GreenStatus extends JLabel {
	
	private static final long serialVersionUID = -8149401918234724016L;

	int green_value;
	
	public GreenStatus(GreenSlider slider) {
		green_value = ColorSelectionPanel.COLOR_INIT;
		slider.addChangeListener(new GreenSliderListener());
		
		actualiseText();
	}
	
	public void setValue(int value) {
		green_value = value;
	}
	
	public void actualiseText() {
		String filler = "";
		if( green_value < 10 ) filler = "      ";
		else if ( green_value < 100 ) filler = "   ";
		this.setText("G : " + filler + green_value);
	}
	
	protected class GreenSliderListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			GreenSlider slider = (GreenSlider) e.getSource();
			setValue(slider.getValue());
			actualiseText();
		}
	}

}
