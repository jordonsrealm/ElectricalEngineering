package com.jordon.tijerina.board.component;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jordon.tijerina.board.AreaManager;
import com.jordon.tijerina.board.component.description.BoardAreaAttribute;
import com.jordon.tijerina.electronic.component.BaseElectronicComponent;
import com.jordon.tijerina.electronic.component.ElectronicComponentFactory;


public class BoardComponent {
	private static List<BoardComponent> createdBoardComponents = new ArrayList<BoardComponent>();
	
	private BaseElectronicComponent component;
	private Long uniqueId;
	//private LayoutParameters parameters;
	private Dimension offSetDimension = new Dimension(0,0);
	private String nickName;
	private Boolean isActive = false;
	private Boolean isHighlighted = false;
	private ConnectionPoint connection1;
	private ConnectionPoint connection2;
	private AreaManager areaManager;
	private Rectangle boardLocation;

	
	private BoardComponent(Integer componentType) {
		Long uniqueIdRandomized;
		
		uniqueIdRandomized = new Random().nextLong();
		
		this.uniqueId = uniqueIdRandomized;
		this.component = ElectronicComponentFactory.getElectronicComponent(componentType);
		//this.areaManager.setBoardAttributes(getAreaManager(component.getComponentType()));
		//this.parameters = new LayoutParameters(component.getDimension(), null);
		this.boardLocation = new Rectangle(new Point(0,0), component.getDimension());
	}
	
	private List<BoardAreaAttribute> getAreaManager(Integer componentType) {
		BoardAreaAttribute leftSide = new BoardAreaAttribute();
		BoardAreaAttribute middle = new BoardAreaAttribute();
		BoardAreaAttribute rightSide = new BoardAreaAttribute();
		
		switch(componentType) {
		case 1: Point pt1      = new Point();
				Dimension dim1 = new Dimension();
				leftSide.setRect(new Rectangle(pt1, dim1));
				middle.setRect(new Rectangle());
				rightSide.setRect(new Rectangle());
				break;
		case 2: leftSide.setRect(new Rectangle());
				middle.setRect(new Rectangle());
				rightSide.setRect(new Rectangle());
				break;
		case 3: leftSide.setRect(new Rectangle());
				middle.setRect(new Rectangle());
				rightSide.setRect(new Rectangle());
				break;
		}
		
		ArrayList<BoardAreaAttribute> list = new ArrayList<BoardAreaAttribute>();
		list.add(leftSide);
		list.add(middle);
		list.add(rightSide);
		
		return list;
	}

	private BoardComponent(Integer componentType, Rectangle params) {
		this(componentType);
		this.boardLocation= params;
	}
	
	public static void createBoardComponent(Integer componentType) {
		createdBoardComponents.add(new BoardComponent(componentType));
	}
	
	public static void createBoardComponent(Integer componentType, Point location) {
		BoardComponent boardComponent = new BoardComponent(componentType);
		boardComponent.setBoardComponentLocation(new Rectangle( location, boardComponent.getComponent().getDimension()));
		createdBoardComponents.add(boardComponent);
	}
	
	public static Integer isPointWithinComponents(Point pt) {
		Integer returnVal = null;
		BoardComponent boarComponent = null;
		for(int x = 0; x < createdBoardComponents.size(); x++) {
			boarComponent = createdBoardComponents.get(x);
			if(boarComponent.getBoardComponentLocation().contains(pt)) {
				returnVal = x;
			}
		}
		
		return returnVal;
	}
	
	public static void updateComponent(BoardComponent c) {
		int index = -1;
		for(int x = 0; x< createdBoardComponents.size(); x++) {
			if(createdBoardComponents.get(x).getUniqueId() == c.getUniqueId()) {
				index = x;
				break;
			}
		}
		
		if(index > 0) {
			createdBoardComponents.set(index, c);
		}
	}
	
	public static void updateComponentWithId(Long id, BoardComponent bc) {
		int index = 0;
		for(int x = 0; x < createdBoardComponents.size(); x++) {
			if(createdBoardComponents.get(x).getUniqueId() == id) {
				index = x;
			}
		}
		
		createdBoardComponents.set(index, bc);
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
	public Rectangle getBoardComponentLocation() {
		return boardLocation;
	}
	public void setBoardComponentLocation(Rectangle parameters) {
		this.boardLocation = parameters;
	}
	
	public Dimension getBoardComponentDimension() {
		return boardLocation.getSize();
	}
	public Dimension getOffSetDimension() {
		return offSetDimension;
	}

	public void setOffSetDimension(Dimension offSetDimension) {
		this.offSetDimension = offSetDimension;
	}

	public Point getOffSetLocation() {
		return new Point(getLocation().x - (int)getOffSetDimension().getWidth(), getLocation().y - (int)this.getOffSetDimension().getHeight());
	}
	
	public void setLocation(Point location) {
		this.boardLocation.setLocation(location);
		// update call to AreaManager
		
	}
	public Point getLocation() {
		return this.boardLocation.getLocation();
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

	public ConnectionPoint getSide1() {
		return connection1;
	}
	public void setSide1(ConnectionPoint side1) {
		this.connection1 = side1;
	}
	public ConnectionPoint getSide2() {
		return connection2;
	}
	public void setSide2(ConnectionPoint side2) {
		this.connection2 = side2;
	}
	public Long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}

	public AreaManager getAreaManager() {
		return areaManager;
	}

	public void setAreaManager(AreaManager areaManager) {
		this.areaManager = areaManager;
	}
}
