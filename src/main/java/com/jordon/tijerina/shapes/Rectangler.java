package com.jordon.tijerina.shapes;

import java.awt.Rectangle;


public class Rectangler {

	Rectangle rect1;
	Rectangle rect2;
	
	public Rectangler(Rectangle rect1, Rectangle rect2) {
		this.rect1 = rect1;
		this.rect2 = rect2;
	}
	
	public Rectangle getRectangle() {
		int upperX = rect1.x > rect2.x ? rect1.x: rect2.x;
		int upperY = rect1.y > rect2.y ? rect1.y: rect2.y;
		int lowerX = rect1.x > rect2.x ? rect1.x: rect2.x;
		int lowerY = rect1.x > rect2.x ? rect1.x: rect2.x;
		
		return new Rectangle();
	}
}
