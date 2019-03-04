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
	private Dimension offSetDimension = new Dimension(0,0);
	private String nickName;
	private Boolean isActive = false;
	private Boolean isHighlighted = false;
	private ConnectionPoint connection1;
	private ConnectionPoint connection2;
	private Long uniqueId;
	private static List<BoardComponent> createdBoardComponents = new ArrayList<>();
	
	
	private BoardComponent(Integer componentType) {
		Long uniqueIdRandomized;
		
		uniqueIdRandomized = new Random().nextLong();
		
		this.uniqueId = uniqueIdRandomized;
		this.component = ElectronicComponentFactory.getElectronicComponent(componentType);
		setConnectionPoints(component.getComponentType());
		this.parameters = new LayoutParameters(component.getDimension(), null);
	}
	
	private void setConnectionPoints(Integer componentType) {
		
		switch(componentType) {
		case 1: Rectangle r1 = new Rectangle();
				Rectangle r2 = new Rectangle();
				r1.setBounds(0, 0, 10, 10);
				r2.setBounds( 0, 0, 10, 10);
				connection1.setBounds(r1);
				connection2.setBounds(r2);
				break;
		case 2: ;
				break;
		case 3: ;
				break;
		}
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
	
	public static Integer isPointWithinComponents(Point pt) {
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

	public Point getOffSetLocation() {
		return new Point(getLocation().x - (int)getOffSetDimension().getWidth(), getLocation().y - (int)this.getOffSetDimension().getHeight());
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
}
