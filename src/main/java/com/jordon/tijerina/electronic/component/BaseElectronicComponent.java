package com.jordon.tijerina.electronic.component;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;


public abstract class BaseElectronicComponent {

	private Dimension dimension;
	protected BufferedImage img;
	public static final Integer RESISTOR_TYPE  = 1;
	public static final Integer CAPACITOR_TYPE = 2;
	public static final Integer INDUCTOR_TYPE  = 3;
	
	
	public BaseElectronicComponent(String imagePath, Dimension dimension) {
		this.dimension = dimension;

		try {
			img = ImageIO.read(new FileInputStream(imagePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String getImagePath();

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public abstract BufferedImage getBufferedImage();
	
	public abstract Integer getComponentType();
}
