package com.jordon.tijerina.views.listener;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputListener;

import com.jordon.tijerina.board.component.BoardComponent;
import com.jordon.tijerina.views.BoardComponentPopup;
import com.jordon.tijerina.views.BoardComponentPropertyPopup;
import com.jordon.tijerina.views.MainPanel;
import com.jordon.tijerina.views.listener.mouseevent.MainPanelMouseEvent;


public class MainFrameListener implements MouseMotionListener, MouseInputListener, KeyListener {
	
	private MainPanel mainPanel;
	
	
	public MainFrameListener(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void mouseDragged(MouseEvent draggedPoint) {
		Point oldPoint = null;
		BoardComponent oldComp = null;
		Long id = null;
		for(BoardComponent boardComponent : BoardComponent.getCreatedBoardComponents()) {
			Point pt = draggedPoint.getPoint();
			if(boardComponent.getRectangle().contains(pt)) {
				oldComp = boardComponent;
				oldPoint = boardComponent.getLocation();
				id = boardComponent.getUniqueId();
				boardComponent.setLocation(new Point(pt.x - (int)boardComponent.getOffSetDimension().getWidth(), pt.y - (int)boardComponent.getOffSetDimension().getHeight()));
				break;
			}
		}
		
		for(BoardComponent boardComponent : BoardComponent.getCreatedBoardComponents()) {
			if(id!=null && !id.equals(boardComponent.getUniqueId()) && boardComponent.getRectangle().intersects(oldComp.getRectangle())) {
				oldComp.setLocation(oldPoint);
			}
		}
		
		mainPanel.repaint();
	}

	public void mouseMoved(MouseEvent movedPoint) {
		for(BoardComponent boardComponent: BoardComponent.getCreatedBoardComponents()) {
			boardComponent.setHighlighted(false);
			if(boardComponent.getRectangle().contains(movedPoint.getPoint())) {
				boardComponent.setHighlighted(true);
			}
		}
		
		mainPanel.repaint();
	}

	public void mouseClicked(MouseEvent clickedPoint) {
		MainPanelMouseEvent me = new MainPanelMouseEvent(clickedPoint);

		Point point = me.getPoint();
		
		if(me.isDoubleClick()) {
			// double click...
		} else {
			// Right click
			if(me.isRightClick()) {
				// Create Menu to select component to draw
				Integer compIndex = BoardComponent.isPointWithComponents(point);
				if(compIndex != null) {
					BoardComponentPropertyPopup popup = new BoardComponentPropertyPopup(point, mainPanel);
					popup.show(mainPanel, point.x, point.y);
				} else {
					BoardComponentPopup popup = new BoardComponentPopup(point, mainPanel);
					popup.show(mainPanel, point.x, point.y);
				}
			} else {

				BoardComponent.resetComponents();
				
				// Select component active if it's selected
				Integer compIndex = BoardComponent.isPointWithComponents(point);
				if( compIndex != null) {
					BoardComponent selectedComponent = BoardComponent.getCreatedBoardComponents().get(compIndex);
					if(selectedComponent.isActive() != null && selectedComponent.isActive().booleanValue()) {
						selectedComponent.setActive(Boolean.FALSE);
					} else {
						selectedComponent.setActive(Boolean.TRUE);
					}

					BoardComponent.updateComponent(compIndex, selectedComponent);
				}
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		
		for(BoardComponent boardComponent: BoardComponent.getCreatedBoardComponents()) {
			boardComponent.setHighlighted(false);
			if(boardComponent.getRectangle().contains(arg0.getPoint())) {
				boardComponent.setOffSetDimension(new Dimension(Math.abs((int)boardComponent.getLocation().getX() - arg0.getX()) , 
																Math.abs((int)boardComponent.getLocation().getY() -  arg0.getY())
																)
												 );
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		
		mainPanel.repaint();
	}


	public void keyPressed(KeyEvent e) {
	}


	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
		System.out.println("Key Typed: ");
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			System.out.println("Deleted: ");
		}
	}

}
