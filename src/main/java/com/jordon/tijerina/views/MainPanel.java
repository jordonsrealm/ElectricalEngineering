package com.jordon.tijerina.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.jordon.tijerina.board.component.BoardComponent;
import com.jordon.tijerina.board.layout.LayoutParameters;
import com.jordon.tijerina.views.listener.MainFrameListener;


public class MainPanel extends JPanel{

	/**/
	private static final long serialVersionUID = 1L;
	private MainFrameListener mainFrameListener;
	private Dimension preferredDimension = new Dimension(500,500);

	
	public MainPanel() {
		mainFrameListener = new MainFrameListener(this);
		this.addMouseMotionListener(mainFrameListener);
		this.addMouseListener(mainFrameListener);
		this.addKeyListener(mainFrameListener);
		this.setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(BoardComponent boardComponent : BoardComponent.getCreatedBoardComponents()) {
			LayoutParameters params = boardComponent.getLayoutParameters();
			Point paramsPoint = params.getPoint();
			g.drawImage(boardComponent.getComponent().getBufferedImage(), paramsPoint.x, paramsPoint.y, null);

			g.setColor(Color.red);
			
			// Highlighted part
			if(boardComponent.isHighlighted() != null && boardComponent.isHighlighted().booleanValue() ) {
				g.drawRect(paramsPoint.x, paramsPoint.y, params.getWidth(), params.getHeight());
			}
			
			// Activated part
			if(boardComponent.isActive() != null && boardComponent.isActive().booleanValue()) {
				g.drawRect(paramsPoint.x, paramsPoint.y, params.getWidth(), params.getHeight());
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return preferredDimension;
	}

	public MainFrameListener getMainFrameListener() {
		return mainFrameListener;
	}

	public void setMainFrameListener(MainFrameListener mainFrameListener) {
		this.mainFrameListener = mainFrameListener;
	}
	
}
