package demaciatanks.swinginterface;

import javax.swing.JLabel;

import thinktank.javabot.graphics.GraphicArena;
import thinktank.javabot.physics.DTank;

public class TankInformation extends JLabel {
	
	private static final long serialVersionUID = -7002817635769721666L;

	public TankInformation(GraphicArena arena) {
		stopSimulationText();
		arena.addTankSelectionListener(new TankInformationFeeder());
		arena.addSimulationListener(new SimulationLaunchListener());
	}
	
	public class TankInformationFeeder implements GraphicArena.TankSelectionListener {

		@Override
		public void onSelection(DTank tank) {
			printInformation(tank);
		}
		
	}
	
	public class SimulationLaunchListener implements GraphicArena.SimulationListener {

		@Override
		public void onStart() {
			setSimulationText();
		}

		@Override
		public void onStop() {
			stopSimulationText();
		}
		
	}
	
	public void printInformation(DTank tank) {
		this.setText("Script du tank : " + tank.getScript_path());
	}
	
	public void setSimulationText() {
		this.setText("Simulation en cours...");
	}
	
	public void stopSimulationText() {
		this.setText("Double-cliquez sur un tank...");
	}


}
