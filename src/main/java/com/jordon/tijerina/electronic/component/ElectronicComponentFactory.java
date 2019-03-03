package com.jordon.tijerina.electronic.component;

public class ElectronicComponentFactory {
	
	
	public static BaseElectronicComponent getElectronicComponent(Integer uniqueId) {
		BaseElectronicComponent component;
		
		if(uniqueId == 1){
			component = new Resistor();
		} else if(uniqueId == 2){
			component = new Capacitor();
		} else {
			component = new Inductor();
		}
		
		return component;
	}

}
