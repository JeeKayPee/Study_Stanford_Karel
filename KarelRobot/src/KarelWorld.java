import java.awt.Color;

import javax.swing.JComponent;

//import acm.util.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class KarelWorld extends JPanel {
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	private int cols;
	private int rows;
	
	public KarelWorld() {
		//setTitle("Karel World");
		setBackground(Color.BLACK);
		JLabel label = new JLabel();
		label.setText("karel world");
		setSize(50, 50);
		add(label);
	}

	public void init(int cols, int rows) {
		this.cols = cols;
		this.rows = rows;
		
	}
	
}
