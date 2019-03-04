package com.jordon.tijerina.electronic.component;

import java.awt.Dimension;
import java.awt.image.BufferedImage;


public class Resistor extends BaseElectronicComponent {

	private static final String IMAGE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\Resistor_Symbol_2x.png";
	private static final Dimension DEFAULT_DIMENSION = new Dimension(80,18);
	private static final Integer COMPONENT_TYPE = BaseElectronicComponent.RESISTOR_TYPE;

	
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

	public Integer getComponentType() {
		return COMPONENT_TYPE;
	}
}
