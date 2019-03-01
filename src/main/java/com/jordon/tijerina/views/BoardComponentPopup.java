package com.jordon.tijerina.views;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.jordon.tijerina.board.component.BoardComponent;


public class BoardComponentPopup extends JPopupMenu implements ActionListener{
	private static final String INDUCTOR = "Inductor";
	private static final String RESISTOR = "Resistor";
	private static final String CAPACITOR = "Capacitor";
	
	/***/
	private static final long serialVersionUID = 1L;
	private MainPanel mainParent;
	private Point popUpLocation;
	
	
	public BoardComponentPopup(Point pt, MainPanel parent) {
		this.setMainParent(parent);
		this.setPopUpLocation(pt);

		// "Resistor" menuitem
		JMenuItem menuItem = new JMenuItem(RESISTOR);
		menuItem.addActionListener(this);
		this.add(menuItem);

		// "Capacitor" menuitem
		menuItem = new JMenuItem(CAPACITOR);
		menuItem.addActionListener(this);
		this.add(menuItem);

		// "Inductor" menuitem
		menuItem = new JMenuItem(INDUCTOR);
		menuItem.addActionListener(this);
		this.add(menuItem);
	}

	public void actionPerformed(ActionEvent e) {
		//Create instance of the menuitem
		JMenuItem mitem = (JMenuItem)e.getSource();

		//String variable from the menuitem that was pressed
		String str = mitem.getText();
		
		if(RESISTOR.equals(str)) {
			BoardComponent.createBoardComponent(BoardComponent.RESISTOR_TYPE, popUpLocation);
		} else if(CAPACITOR.equals(str)) {
			BoardComponent.createBoardComponent(BoardComponent.CAPACITOR_TYPE, popUpLocation);
		} else {
			BoardComponent.createBoardComponent(BoardComponent.INDUCTOR_TYPE, popUpLocation);
		}
	}

	public Point getPopUpLocation() {
		return popUpLocation;
	}

	public void setPopUpLocation(Point popUpLocation) {
		this.popUpLocation = popUpLocation;
	}

	public MainPanel getMainParent() {
		return mainParent;
	}

	public void setMainParent(MainPanel mainParent) {
		this.mainParent = mainParent;
	}
}
