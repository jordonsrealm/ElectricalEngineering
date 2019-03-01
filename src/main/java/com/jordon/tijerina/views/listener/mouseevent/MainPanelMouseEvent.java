package com.jordon.tijerina.views.listener.mouseevent;

import java.awt.Point;
import java.awt.event.MouseEvent;


public class MainPanelMouseEvent {
	
	private MouseEvent mainMouseEvent;
	
	
	public MainPanelMouseEvent(MouseEvent mouseEvent) {
		this.mainMouseEvent = mouseEvent;
	}
	
	public Integer getClickCount() {
		return mainMouseEvent.getClickCount();
	}
	
	public Boolean isDoubleClick() {
		return mainMouseEvent.getClickCount() == 2;
	}
	
	public Boolean isSingleClick() {
		return mainMouseEvent.getClickCount() == 1;
	}
	
	public Boolean isLeftClick() {
		return mainMouseEvent.getButton() == MouseEvent.BUTTON1;
	}
	
	public Boolean isRightClick() {
		return mainMouseEvent.getButton() == MouseEvent.BUTTON3;
	}
	
	public Boolean isMiddleClick() {
		return mainMouseEvent.getButton() == MouseEvent.BUTTON2;
	}
	
	public Point getLocationOnScreen() {
		return mainMouseEvent.getLocationOnScreen();
	}
	
	public Point getPoint() {
		return mainMouseEvent.getPoint();
	}

}
