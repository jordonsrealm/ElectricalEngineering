package com.jordon.tijerina.main;

import javax.swing.JFrame;

import com.jordon.tijerina.views.ElectronicMenuBar;
import com.jordon.tijerina.views.MainPanel;


public class Starter {
	private static final String TITLE = "Electronics!!!";
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(TITLE);
		
		// Main drawing area
		MainPanel mainPanel = new MainPanel();
		frame.add(mainPanel);
		
		// Custom JMenubar
		ElectronicMenuBar menubar= new ElectronicMenuBar();
		frame.setJMenuBar(menubar);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100,100);
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
	}
}
