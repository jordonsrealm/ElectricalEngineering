package com.jordon.tijerina.board.component.description;

import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import com.jordon.tijerina.board.component.BoardComponent;

public class BoardAreaAttribute {
	private Long uniqueId;
	private Boolean isActive = false;
	private Boolean isHighlighted = false;
	private Rectangle rect;
	private List<BoardComponent> attachedComponents;
	

	public BoardAreaAttribute() {
		this(new Random().nextLong(), false, false, null);
	}
	
	
	
	public BoardAreaAttribute(Long id, Boolean isActive, Boolean isHighlighted, List<BoardComponent> components) {
		this.uniqueId = new Random().nextLong();
		this.isActive = isActive;
		this.isHighlighted = isHighlighted;
		this.attachedComponents = components;
	}


	public Boolean getIsHighlighted() {
		return isHighlighted;
	}


	public void setIsHighlighted(Boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}


	public Long getUniqueId() {
		return uniqueId;
	}


	public void setUniqueId(Long nickName) {
		this.uniqueId = nickName;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Rectangle getRect() {
		return rect;
	}


	public void setRect(Rectangle rect) {
		this.rect = rect;
	}


	public List<BoardComponent> getComponents() {
		return attachedComponents;
	}


	public void setComponents(List<BoardComponent> components) {
		this.attachedComponents = components;
	}
}
