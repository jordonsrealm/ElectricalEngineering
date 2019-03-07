package com.jordon.tijerina.board.helper;

import java.awt.Point;
import java.awt.Rectangle;


public class RectangleHelper {
	
	public static Rectangle getEnclosingRectangle(Rectangle r1, Rectangle r2) {
		int smallestX = (r1.x > r2.x) ? r2.x : r1.x;
		int smallestY = (r1.y > r2.y) ? r2.y : r1.y;
		
		Point pt1 = new Point(r1.x + r1.width, r1.y + r1.height);
		Point pt2 = new Point(r2.x + r2.width, r2.y + r2.height);
		
		int largerX = (pt1.x > pt2.x) ? pt1.x : pt2.x;
		int largerY = (pt1.y > pt2.y) ? pt1.y : pt2.y;
		
		/*
		 * int largerWidth = (r1.width > r2.width ) ? r1.width : r2.width;
		 * largerHeight = (r1.height > r2.height) ? r1.height : r2.height;
		 */
		System.out.println("Rectangle: " + largerX  + " - " + largerY);
		return new Rectangle( smallestX, smallestY, largerX - smallestX, largerY - smallestY);
	}
}