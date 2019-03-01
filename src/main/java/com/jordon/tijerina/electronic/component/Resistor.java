package com.jordon.tijerina.electronic.component;

import java.awt.Dimension;
import java.awt.image.BufferedImage;


public class Resistor extends BaseElectronicComponent {

	private static final String IMAGE_PATH = "C:\\Users\\Jordon_Kayla\\workspace\\electrical-engineering\\src\\main\\resources\\Resistor_Symbol_cellSize.png";
	private static final Dimension DEFAULT_DIMENSION = new Dimension(40,9);

	
	public Resistor() {
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
