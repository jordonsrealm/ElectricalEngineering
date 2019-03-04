package com.jordon.tijerina.board.component;

import java.awt.Rectangle;
import java.util.List;


public class ConnectionPoint {

	private boolean isHighlighted;
	private boolean isActive;
	private List<BoardComponent> connectedComponents;
	private Rectangle dimension = new Rectangle();
	
	
	public boolean isHighlighted() {
		return isHighlighted;
	}
	public void setHighlighted(boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<BoardComponent> getConnectedComponents() {
		return connectedComponents;
	}
	public void setConnectedComponents(List<BoardComponent> connectedComponents) {
		this.connectedComponents = connectedComponents;
	}
	
	public Rectangle getBounds() {
		return dimension;
	}
	public void setBounds(Rectangle dimension) {
		this.dimension = dimension;
	}
}
