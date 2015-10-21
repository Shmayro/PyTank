package thinktank.javabot.physics;

import java.awt.Graphics;

public interface ObjetTT {
	public Physique.type getType();
	
	public void paint(Graphics g, int x, int y);
}