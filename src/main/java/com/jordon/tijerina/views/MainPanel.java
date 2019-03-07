package com.jordon.tijerina.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import com.jordon.tijerina.board.component.BoardComponent;
import com.jordon.tijerina.views.listener.MainPanelListener;


public class MainPanel extends JPanel{

	/**/
	private static final long serialVersionUID = 1L;
	private MainPanelListener mainFrameListener;
	private Dimension preferredDimension = new Dimension(800,800);

	private static final int SQUARE_SIDE = 10;
	private static final Color SCHEMATIC_COLOR = new Color(235,235,235);
	
	
	public MainPanel() {
		mainFrameListener = new MainPanelListener(this);
		
		this.addMouseMotionListener(mainFrameListener);
		this.addMouseListener(mainFrameListener);
		this.addKeyListener(mainFrameListener);
		this.setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawInitialSchematicView(g);
		
		for(BoardComponent boardComponent : BoardComponent.getCreatedBoardComponents()) {
			Rectangle boardComponentLocation = boardComponent.getBoardComponentLocation();
			Point boardComponentPoint = boardComponentLocation.getLocation();
			g.drawImage(boardComponent.getComponent().getBufferedImage(), boardComponentPoint.x, boardComponentPoint.y, null);

			g.setColor(Color.red);
			
			// Highlighted part, Activated part
			if((boardComponent.isHighlighted() != null && boardComponent.isHighlighted().booleanValue()) || 
					(boardComponent.isActive() != null && boardComponent.isActive().booleanValue())) {
				g.drawRect(boardComponentPoint.x, boardComponentPoint.y, boardComponentLocation.width, boardComponentLocation.height);
			}
		}
	}
	
	private void drawInitialSchematicView(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(SCHEMATIC_COLOR);
		for(int x = 0 ; x < getWidth()/SQUARE_SIDE; x++) {
			for(int y = 0; y < getHeight()/SQUARE_SIDE; y++) {
				if((x+y)%2 == 0) {
					g.fillRect(x*SQUARE_SIDE, y*SQUARE_SIDE, SQUARE_SIDE, SQUARE_SIDE);
				}
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return preferredDimension;
	}

	public MainPanelListener getMainFrameListener() {
		return mainFrameListener;
	}

	public void setMainFrameListener(MainPanelListener mainFrameListener) {
		this.mainFrameListener = mainFrameListener;
	}
	
}
