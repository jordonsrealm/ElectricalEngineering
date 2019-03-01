package com.jordon.tijerina.main;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.jordon.tijerina.views.MainPanel;


public class Starter {
	private static final String TITLE = "Electronics!!!";
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(TITLE);
		
		MainPanel mainPanel = new MainPanel();
		frame.add(mainPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(new Dimension(500,500));
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
