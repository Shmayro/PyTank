import demaciatanks.swinginterface.MainPanel;
import demaciatanks.swinginterface.Window;

class Main {
	public static void main(String args[]) {
		Window window = new Window();
		MainPanel panel = new MainPanel();
		window.setContent(panel);
	}
}