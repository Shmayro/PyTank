package demaciatanks.swinginterface;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RedStatus extends JLabel {
	
	private static final long serialVersionUID = -8149401918234724016L;

	int red_value;
	
	public RedStatus(RedSlider slider) {
		red_value = ColorSelectionPanel.COLOR_INIT;
		slider.addChangeListener(new RedSliderListener());
		
		actualiseText();
	}
	
	public void setValue(int value) {
		red_value = value;
	}
	
	public void actualiseText() {
		String filler = "";
		if( red_value < 10 ) filler = "      ";
		else if ( red_value < 100 ) filler = "   ";
		this.setText("R : " + filler + red_value);
	}
	
	protected class RedSliderListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			RedSlider slider = (RedSlider) e.getSource();
			setValue(slider.getValue());
			actualiseText();
		}
	}

}
