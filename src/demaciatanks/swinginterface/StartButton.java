package demaciatanks.swinginterface;

import javax.swing.JButton;

public class StartButton extends JButton {
	
	private static final long serialVersionUID = -2934554054003374998L;

	private boolean under_simulation;
	
	public StartButton() {
		setStartText();
	}
	
	public void setStartText() {
		this.setText("Lancer");
		under_simulation = false;
	}

	public void setStopText() {
		this.setText("Arrêter");
		under_simulation = true;
	}
	
	public boolean isSimulationRunning() {
		return under_simulation;
	}
}
