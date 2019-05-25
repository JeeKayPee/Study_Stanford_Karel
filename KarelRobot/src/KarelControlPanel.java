import java.awt.*;
import javax.swing.*;

public class KarelControlPanel extends JPanel {
		private CardLayout layout;
		private String currentView;
		
		public KarelControlPanel(KarelProgram one) {
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
