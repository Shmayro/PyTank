package thinktank.javabot.physics;

/**
 * Classe pour tester la partie physique
 *
 */
public class TestPhysics {

	public static void affiche(Physique physique){
		Terrain map = physique.getMap();
		
		for(int j=0; j < map.tailleY();j++){
			System.out.println();
			for(int i=0; i < map.tailleX();i++)
				switch (physique.detail(i, j).getType()) {
				case vide:
					System.out.print('a');
					break;
				case mur:
					System.out.print('l');
					break;

				default:
					System.out.print(((Mobile)physique.detail(i, j)).getId());
					break;
				}
			}
		System.out.println();
	}
	
	public static void testProjectile(){
		Physique physique = new Physique();
		Terrain map = physique.getMap();
		Tank t = map.addTank(1,8,"ressources/tank1.py",physique);
		t.getDirection().tournerDroite();
		t.getDirection().tournerDroite();
		physique.addTank(1,1,"ressources/tank1.py");
		physique.addTank(2,1,"ressources/tank1.py");
		physique.addTank(3,1,"ressources/tank1.py");
		affiche(physique);
		while(true){
			physique.iter();
			affiche(physique);
			if(physique.getTanks().isEmpty()) break;
		}
	}
	
	
	public static void test(){
		Physique physique = new Physique();
		Terrain map = physique.getMap();
		map.addTank("ressources/tankytourne2.py");
		map.addTank("ressources/tankytourne2.py");
		affiche(physique);
		while(true){
			physique.iter();
			affiche(physique);
			if(physique.getTanks().isEmpty()) break;
		}
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		test();
	}*/
}
