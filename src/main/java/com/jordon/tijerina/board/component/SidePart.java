package com.jordon.tijerina.board.component;

import java.awt.Dimension;
import java.util.List;


public class SidePart {

	private boolean isHighlighted;
	private boolean isActive;
	private List<BoardComponent> connectedComponents;
	private Dimension dimension;
	
	
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
	
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
