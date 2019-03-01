package com.jordon.tijerina.board.layout;

import java.awt.Dimension;
import java.awt.Point;


public class LayoutParameters {

	private int width;
	private int height;
	private Point locationOnBoard;
	
	public LayoutParameters() {
		//
	}
	
	public LayoutParameters(int width, int height, Point locationOnBoard) {
		this.width = width;
		this.height = height;
		this.locationOnBoard = locationOnBoard;
	}
	
	public LayoutParameters(Dimension dim, Point pt) {
		width = (int) dim.getWidth();
		height = (int) dim.getHeight();
		locationOnBoard = pt;
	}
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getPoint() {
		return locationOnBoard;
	}
	public void setPoint(Point locationOnBoard) {
		this.locationOnBoard = locationOnBoard;
	}
	public int getX() {
		return locationOnBoard.y;
	}
	public int getY() {
		return locationOnBoard.x;
	}
}
