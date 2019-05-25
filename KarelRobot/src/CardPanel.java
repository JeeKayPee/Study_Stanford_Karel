import java.awt.CardLayout;

import javax.swing.*;


public class CardPanel extends JPanel {
	private CardLayout layout;
	private String currentView;
	
	public CardPanel() {
			layout = new CardLayout();
			setLayout(layout);
			
	}
	
	public void setView(String name) {
			currentView = name;
			layout.show(this, name);
			repaint();
	}
	
	public String getView() {
		return currentView;
	}
}