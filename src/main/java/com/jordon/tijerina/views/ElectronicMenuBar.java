package com.jordon.tijerina.views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ElectronicMenuBar extends JMenuBar{

	/***/
	private static final long serialVersionUID = 1L;
	

	public ElectronicMenuBar() {
		constructMenuBar();
	}


	private void constructMenuBar() {
		JMenuItem comp1 = new JMenuItem("Item");
		
		JMenu menu = new JMenu("File");
		menu.add(comp1);
		
		this.add(menu);
	}
}
