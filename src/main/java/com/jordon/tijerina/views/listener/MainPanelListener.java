package com.jordon.tijerina.views.listener;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.event.MouseInputListener;

import com.jordon.tijerina.board.component.BoardComponent;
import com.jordon.tijerina.views.BoardComponentPopup;
import com.jordon.tijerina.views.BoardComponentPropertyPopup;
import com.jordon.tijerina.views.MainPanel;
import com.jordon.tijerina.views.listener.mouseevent.MainPanelMouseEvent;


public class MainPanelListener implements MouseMotionListener, MouseInputListener, KeyListener {
	
	private MainPanel mainPanel;
	
	
	public MainPanelListener(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void mouseDragged(MouseEvent draggedPoint) {
		Point pt = draggedPoint.getPoint();
		List<BoardComponent> comps = BoardComponent.getCreatedBoardComponents().stream().filter(n->n.getRectangle().contains(pt)).collect(Collectors.toList());
		
		// Check to see if the component can be dragged
		if(!comps.isEmpty()) {
			
			BoardComponent component = comps.get(0);
			
			// Create point to test against other components
			Point testPoint = new Point(pt.x - (int)component.getOffSetDimension().getWidth(), 
										pt.y - (int)component.getOffSetDimension().getHeight());
			
			// Check for other components in the way
			Rectangle newPlacement = new Rectangle( testPoint, 
													component.getLayoutParameters().getParamsAsDimension());
			
			boolean intersectionExists = BoardComponent.getCreatedBoardComponents().stream().anyMatch(n->n.getRectangle().intersects(newPlacement) && n.getUniqueId() != component.getUniqueId());
			if(!intersectionExists) {
				Rectangle rect = component.getRectangle();
				component.setLocation(testPoint);
				rect.add(component.getRectangle());
				rect.grow(1, 1);
				mainPanel.repaint(rect);
			}
		}
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
		Integer compIndex = BoardComponent.isPointWithinComponents(point);
		
		if(me.isDoubleClick()) {
			// double click...
		} else {
			// Right click
			if(me.isRightClick()) {
				handleBoardComponentCreation(point, compIndex);
			} else {
				handleActivation(point, compIndex);
			}
		}
	}
	
	private void handleBoardComponentCreation(Point point, Integer compIndex) {
		// Create Menu to select component to draw

		if(compIndex != null) {
			BoardComponentPropertyPopup popup = new BoardComponentPropertyPopup(point, mainPanel);
			popup.show(mainPanel, point.x, point.y);
		} else {
			BoardComponentPopup popup = new BoardComponentPopup(point, mainPanel);
			popup.show(mainPanel, point.x, point.y);
		}
	}

	private void handleActivation(Point point, Integer compIndex) {
		BoardComponent.resetComponents();
		
		if( compIndex != null) {
			BoardComponent selectedComponent = BoardComponent.getCreatedBoardComponents().get(compIndex);
			if(selectedComponent.isActive() != null && selectedComponent.isActive().booleanValue()) {
				selectedComponent.setActive(Boolean.FALSE);
			} else {
				selectedComponent.setActive(Boolean.TRUE);
			}

			BoardComponent.updateComponent(selectedComponent);
		}
	}


	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent pressedPoint) {
		for(BoardComponent boardComponent: BoardComponent.getCreatedBoardComponents()) {
			boardComponent.setHighlighted(false);
			if(boardComponent.getRectangle().contains(pressedPoint.getPoint())) {
				boardComponent.setOffSetDimension(new Dimension(Math.abs((int)boardComponent.getLocation().x - pressedPoint.getX()) , 
																Math.abs((int)boardComponent.getLocation().y - pressedPoint.getY())
																)
												  );
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		mainPanel.repaint();
	}

	/**
	 * KEYLISTENER METHODS
	 * */
	public void keyPressed(KeyEvent e) {
	}


	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
		int keyCode = (int) e.getKeyChar();
		if(keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_DELETE) {
			List<BoardComponent> filtered = BoardComponent.getCreatedBoardComponents().stream().filter(n->n.isActive()!= null && !n.isActive().booleanValue()).collect(Collectors.toList());
			BoardComponent.setCreatedBoardComponents(filtered);
			
			mainPanel.repaint();
		}
	}
	
	protected void displayInfo(KeyEvent e, String s){
	        //You should only rely on the key char if the event
	        //is a key typed event.
	        int id = e.getID();
	        String keyString = "";
	        String modString = "";
	        String tmpString = "";
	        String actionString = "";
	        String locationString = "";
	        if (id == KeyEvent.KEY_TYPED) {
	            int c = (int) e.getKeyChar();
	            keyString = "key character = '" + c + "'";
	        } else {
	            int keyCode = e.getKeyCode();
	            keyString = "key code = " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")";
	        }

	        int modifiers = e.getModifiersEx();
	        modString = "modifiers = " + modifiers;
	        tmpString = KeyEvent.getModifiersExText(modifiers);
	        if (tmpString.length() > 0) {
	            modString += " (" + tmpString + ")";
	        } else {
	            modString += " (no modifiers)";
	        }

	        actionString = "action key? ";
	        if (e.isActionKey()) {
	            actionString += "YES";
	        } else {
	            actionString += "NO";
	        }

	        locationString = "key location: ";
	        int location = e.getKeyLocation();
	        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	            locationString += "standard";
	        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	            locationString += "left";
	        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	            locationString += "right";
	        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	            locationString += "numpad";
	        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	            locationString += "unknown";
	        }
	        
	        System.out.println(s + keyString + modString + tmpString + actionString + locationString);
	        //Display information about the KeyEvent...
	    }

}
