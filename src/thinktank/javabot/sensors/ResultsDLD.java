package thinktank.javabot.sensors;

import thinktank.javabot.physics.Physique;

public class ResultsDLD {
	private int distance;
	private Physique.type type;
	
	public ResultsDLD(int distance, Physique.type type) {
		this.distance = distance;
		this.type = type;
	}
	
	public int getDistance() {
		return distance;
	}

	public Physique.type getType() {
		return type;
	}
}
