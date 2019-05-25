import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.mindview.util.SwingConsole;

import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;

 class SineDraw extends JPanel {
	 private static final int SCALEFACTOR = 200;
	 private int cycles;
	 private int points;
	 private double[] sines;
	 private int[] pts;
	 public SineDraw() {
		 setCycles(5);
	}
	 
	 public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 int maxWidth = getWidth();
		 double hstep = (double)maxWidth / (double) points;
		 int maxHeight = getHeight();
		 pts = new int[points];
		 for(int i = 0; i < points; i ++){
			 pts[i] = (int)(sines[i] * maxHeight /2 * 0.95 + maxHeight/2);
		 }
		 g.setColor(Color.RED);
		 for(int i =1; i < points; i++){
			 int x1 = (int)((i -1)*hstep);
			 int x2 = (int)(i*hstep);
			 int y1 = pts[i-1];
			 int y2 = pts[i];
			 g.drawLine(x1, y1, x2, y2);
		 }
	 }
	 
	 public void setCycles(int newCycles) {
		 cycles = newCycles;
		 points = SCALEFACTOR * cycles * 2;
		 sines = new double[points];
		 for(int i = 0; i < points; i ++){
			 double radians = (Math.PI / SCALEFACTOR) * i;
			 sines[i] = Math.sin(radians);
		 }
		 repaint();
	 }
 }

public class HelloSwing  extends JFrame{
	private JLabel label;
	private JButton b1 = new JButton("Button 1"), 
				    b2 = new JButton("Button 2"),
				    b3 = new JButton("Button 3");
	
	private JTextField txt = new JTextField(10);
	
	private CardPanel cardpanel;
	private ActionListener bl = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	};
	
	private ActionListener bl_cardlayout = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = txt.getText();
			cardpanel.setView(name);
		}
	};
	
	private SineDraw sines = new SineDraw();
	private JSlider adjustCycles = new JSlider(1, 30, 5);
	
	public HelloSwing(){
		super("Hello Swing");
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		b3.addActionListener(bl_cardlayout);
		setLayout(new FlowLayout());
		label = new JLabel("A label");
		cardpanel  = new CardPanel();
		add(label);
		add(b1);
		add(b2);
		add(b3);
		add(txt);

		add(sines);
		adjustCycles.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				sines.setCycles(
						((JSlider)e.getSource()).getValue());
			}
		});
		add(BorderLayout.SOUTH, adjustCycles);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(300, 100);
//		setVisible(true);
	}
	static HelloSwing ssp;
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		ssp = new HelloSwing();
//		SwingUtilities.invokeLater(new Runnable(){
//			public void run(){
//				
//			}
//		});
		SwingConsole.run(ssp, 300, 100);
//		TimeUnit.SECONDS.sleep(1);
//		SwingUtilities.invokeLater(new Runnable(){
//			public void run(){
//				ssp.label.setText("Hey! This is Different!");
//			}
//		});
		
	}

}


