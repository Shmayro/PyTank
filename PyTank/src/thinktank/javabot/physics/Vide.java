package thinktank.javabot.physics;

public class Vide implements ObjetTT{
	final static Vide v = new Vide();

	private Vide(){}

	public static Vide getVide()
	{
		return v;
	}

	public Physique.type getType(){
		return Physique.type.vide;
	}
}