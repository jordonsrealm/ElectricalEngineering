package com.jordon.tijerina.views;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class BoardComponentPropertyPopup extends JPopupMenu implements ActionListener{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private Point popupLocation;
	private static final String ROTATE = "Rotate";
	
	
	public BoardComponentPropertyPopup(Point pt, MainPanel parent) {
		setMainPanel(parent);
		setPopupLocation(pt);

		JMenuItem menuItem = new JMenuItem(ROTATE);
		menuItem.addActionListener(this);
		this.add(menuItem);
	}

	public void actionPerformed(ActionEvent e) {
		//Create instance of the menuitem
		JMenuItem mitem = (JMenuItem)e.getSource();

		//String variable from the menuitem that was pressed
		String str = mitem.getText();
		
		if(ROTATE.equals(str)) {
			//mainPanel
		}
	}

	public Point getPopupLocation() {
		return popupLocation;
	}

	public void setPopupLocation(Point popupLocation) {
		this.popupLocation = popupLocation;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

}
