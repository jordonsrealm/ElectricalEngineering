package com.jordon.tijerina.board.component;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jordon.tijerina.board.layout.LayoutParameters;
import com.jordon.tijerina.electronic.component.BaseElectronicComponent;
import com.jordon.tijerina.electronic.component.ElectronicComponentFactory;


public class BoardComponent {
	
	private BaseElectronicComponent component;
	private LayoutParameters parameters;
	private Dimension offSetDimension;
	private String nickName;
	private Boolean isActive;
	private Boolean isHighlighted;
	private SidePart side1;
	private SidePart side2;
	private Long uniqueId;
	private static List<BoardComponent> createdBoardComponents = new ArrayList<BoardComponent>();
	public static final Integer RESISTOR_TYPE  = 1;
	public static final Integer CAPACITOR_TYPE = 2;
	public static final Integer INDUCTOR_TYPE  = 3;
	
	
	private BoardComponent(Integer componentType) {
		Long uniqueIdRandomized;
		
		uniqueIdRandomized = new Random().nextLong();
		
		this.uniqueId = uniqueIdRandomized;
		this.component = ElectronicComponentFactory.getElectronicComponent(componentType);
		this.parameters = new LayoutParameters(component.getDimension(), null);
	}
	
	private BoardComponent(Integer componentType, LayoutParameters params) {
		this(componentType);
		this.parameters= params;
	}
	
	public static void createBoardComponent(Integer componentType) {
		createdBoardComponents.add(new BoardComponent(componentType));
	}
	
	public static void createBoardComponent(Integer componentType, Point location) {
		BoardComponent boardComponent = new BoardComponent(componentType);
		boardComponent.setParameters(new LayoutParameters(boardComponent.getComponent().getDimension(), location));
		createdBoardComponents.add(boardComponent);
	}
	
	public static Integer isPointWithComponents(Point pt) {
		Integer returnVal = null;
		BoardComponent val = null;
		for(int x = 0; x < createdBoardComponents.size(); x++) {
			val = createdBoardComponents.get(x);
			if(val.getRectangle().contains(pt)) {
				returnVal = x;
			}
		}
		
		return returnVal;
	}
	
	public static void updateComponent(int index, BoardComponent c) {
		createdBoardComponents.set(index, c);
	}
	
	public static void resetComponents() {
		for(BoardComponent comp: createdBoardComponents) {
			comp.setHighlighted(false);
		}
	}
	
	public static List<BoardComponent> getCreatedBoardComponents() {
		return createdBoardComponents;
	}

	public static void setCreatedBoardComponents(List<BoardComponent> createdBoardComponents) {
		BoardComponent.createdBoardComponents = createdBoardComponents;
	}

	public BaseElectronicComponent getComponent() {
		return component;
	}
	public void setComponent(BaseElectronicComponent component) {
		this.component = component;
	}
	public LayoutParameters getLayoutParameters() {
		return parameters;
	}
	public void setParameters(LayoutParameters parameters) {
		this.parameters = parameters;
	}
	public Dimension getOffSetDimension() {
		return offSetDimension;
	}

	public void setOffSetDimension(Dimension offSetDimension) {
		this.offSetDimension = offSetDimension;
	}

	public void setLocation(Point location) {
		this.parameters.setPoint(location);
	}
	public Point getLocation() {
		return this.parameters.getPoint();
	}
	public Rectangle getRectangle() {
		return new Rectangle(parameters.getPoint(), component.getDimension());
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
		System.out.println("toggling..." + isActive.booleanValue());
	}
	public void toggleActive() {
		if(this.isActive.booleanValue()) {
			this.isActive = Boolean.FALSE;
		} else {
			this.isActive = Boolean.TRUE;
		}
		

	}
	public Boolean isHighlighted() {
		return isHighlighted;
	}

	public void setHighlighted(Boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}

	public SidePart getSide1() {
		return side1;
	}
	public void setSide1(SidePart side1) {
		this.side1 = side1;
	}
	public SidePart getSide2() {
		return side2;
	}
	public void setSide2(SidePart side2) {
		this.side2 = side2;
	}
	public Long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	
	
}
