import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class KarelProgram  extends JFrame{
	
	/*
	 * Private state
	 */
	private KarelWorld world;
	private KarelControlPanel controlPanel;
	private JLabel statusLabel;
	
	/*
	 * Create a new Karel program
	 */
	
	public KarelProgram(){
		world = createWorld();
		world.init(10, 10);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(BorderLayout.CENTER, world);
		controlPanel = new KarelControlPanel(this);
		panel.add(BorderLayout.WEST, controlPanel);
		add(panel);
		
		statusLabel = new JLabel("Welcome to Karel!");
		add(statusLabel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		validate();
	}
	
	/*
	 * Creates the KarelWorld where Karel lives
	 */
	protected KarelWorld createWorld() {
		return new KarelWorld();
	}
	
	public KarelWorld getWorld(){
		return world;
	}
	
	public void main(){
		
	}

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		KarelProgram k = new KarelProgram();
	}
}
