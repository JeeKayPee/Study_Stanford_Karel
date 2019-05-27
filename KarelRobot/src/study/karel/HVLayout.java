package study.karel;

import java.awt.*;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.HashMap;

import javax.print.attribute.standard.OrientationRequested;


class HVLayout implements LayoutManager {
	/* Constants */
	public static final int DEFAULT_SPACE = 5;
	public static final int HORIZONTAL = GridBagConstraints.HORIZONTAL;
	public static final int VERTICAL = GridBagConstraints.VERTICAL;
	
	/* Private constants */
	private static final int MINIMUM = 0;

	
	/* Private variables*/
	private int orientation;
	private HashMap<Component, OptionTable> constraintTable;
	
	public  HVLayout(int orientation) {
	        this.orientation = orientation;
	        constraintTable = new HashMap<Component, OptionTable>();
	}
	
	
	
	@Override
	public void addLayoutComponent(String constraints, Component comp) {
		synchronized (comp.getTreeLock()) {
                constraintTable.put(comp, new OptionTable(constraints.toLowerCase()));
        }
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		
	}
	
}