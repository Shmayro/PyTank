package demaciatanks.swinginterface;

import java.awt.Dimension;

import javax.swing.JSlider;

public class RedSlider extends JSlider {
	
	private static final long serialVersionUID = -4207692039869263982L;

	public RedSlider() {
		super();
		this.setOrientation(JSlider.HORIZONTAL);
		this.setMinimum(ColorSelectionPanel.COLOR_MIN);
		this.setMaximum(ColorSelectionPanel.COLOR_MAX);
		this.setValue(ColorSelectionPanel.COLOR_INIT);
		
		int maximum_height = this.getMaximumSize().height;
		
		this.setMaximumSize(new Dimension(
					ColorSelectionPanel.MAX_SLIDERS_SIZE,
					maximum_height));
	}

}
