package thinktank.javabot.physics;

public class Mur implements ObjetTT{
	final static Mur m = new Mur();

	private Mur(){}

	public static Mur getMur()
	/**
 	* renvoie le Mur de la classe
 	*/
	{
		return m;
	}

	public Physique.type getType()
	/**
 	* renvoie un type mur
 	*/
	{
		return Physique.type.mur;
	}
}