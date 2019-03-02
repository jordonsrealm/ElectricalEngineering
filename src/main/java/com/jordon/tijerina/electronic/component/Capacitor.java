package com.jordon.tijerina.electronic.component;

import java.awt.Dimension;
import java.awt.image.BufferedImage;


public class Capacitor extends BaseElectronicComponent {

	private static final String IMAGE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\Capacitor_Symbol_2x.png";
	private static final Dimension DEFAULT_DIMENSION = new Dimension(60,30);
	
	public Capacitor() {
		super(IMAGE_PATH, DEFAULT_DIMENSION);
	}

	@Override
	public BufferedImage getBufferedImage() {
		return img;
	}

	@Override
	public String getImagePath(){
		return IMAGE_PATH;
	}
	
}
