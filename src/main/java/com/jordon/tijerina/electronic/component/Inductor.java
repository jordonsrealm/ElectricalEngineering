package com.jordon.tijerina.electronic.component;

import java.awt.Dimension;
import java.awt.image.BufferedImage;


public class Inductor extends BaseElectronicComponent {

	private static final String IMAGE_PATH = "C:\\Users\\Jordon_Kayla\\workspace\\electrical-engineering\\src\\main\\resources\\Inductor_Symbol_cellSize.png";
	private static final Dimension DEFAULT_DIMENSION = new Dimension(40,8);
	
	public Inductor() {
		super(IMAGE_PATH, DEFAULT_DIMENSION);
	}

	@Override
	public BufferedImage getBufferedImage()  {
		return img;
	}

	@Override
	public String getImagePath() {
		return IMAGE_PATH;
	}
}
