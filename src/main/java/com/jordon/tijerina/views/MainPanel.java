package com.jordon.tijerina.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.jordon.tijerina.board.component.BoardComponent;
import com.jordon.tijerina.board.layout.LayoutParameters;
import com.jordon.tijerina.views.listener.MainPanelListener;


public class MainPanel extends JPanel{

	/**/
	private static final long serialVersionUID = 1L;
	private MainPanelListener mainFrameListener;
	private Dimension preferredDimension = new Dimension(800,800);

	
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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		for(BoardComponent boardComponent : BoardComponent.getCreatedBoardComponents()) {
			LayoutParameters params = boardComponent.getLayoutParameters();
			Point paramsPoint = params.getPoint();
			g.drawImage(boardComponent.getComponent().getBufferedImage(), paramsPoint.x, paramsPoint.y, null);

			g.setColor(Color.red);
			
			// Highlighted part, Activated part
			if((boardComponent.isHighlighted() != null && boardComponent.isHighlighted().booleanValue()) || (boardComponent.isActive() != null && boardComponent.isActive().booleanValue())) {
				g.drawRect(paramsPoint.x, paramsPoint.y, params.getWidth(), params.getHeight());
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
