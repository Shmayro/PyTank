package pyTank;

import thinktank.javabot.graphics.MainWindow;


public class Main {

	// =============================================================================
	// Main

	public static void main(String argv[]) {
		MainWindow win = new MainWindow();
		Main.createWalls(win);
		win.mainLoop();
	}

	// =============================================================================

	// =============================================================================
	// Méthodes privées

	/**
	 * Créer les murs de la map. Ce code est à modifié si l'on veut changer la
	 * map.
	 * 
	 * @param win
	 *            : la fenêtre sur laquelle il faut appliquer les modifications
	 *            des murs
	 */
	private static void createWalls(MainWindow win) {
		// MAP HARD CODE
		for (int i = 5; i < 10; i++) {
			win.addWall(i, 5);
		}

		for (int i = 18; i < 25; i++) {
			win.addWall(i, 15);
		}

		for (int i = 5; i < 10; i++) {
			win.addWall(30, i);
		}

		for (int i = 28; i < 33; i++) {
			// m_win.addWall(i,20);
		}

		for (int i = 10; i < 15; i++) {
			win.addWall(8, i);
		}

	}

	// =============================================================================

}
