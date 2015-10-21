package demaciatanks.swinginterface;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private JFrame frame;
	
	public Window() throws HeadlessException {
		frame = new JFrame();
		frame.setTitle("Demacian Tanks");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setContent(JPanel panel) {
		getFrame().setContentPane(panel);
		getFrame().pack();
		getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
		getFrame().setVisible(true);
	}
	
	public static void main(String args[]) {
		Window window = new Window();
		MainPanel panel = new MainPanel();
		window.setContent(panel);
	}
}
