package com.jordon.tijerina.board;

import java.util.ArrayList;
import java.util.List;

import com.jordon.tijerina.board.component.description.BoardAreaAttribute;


public class AreaManager{
	
	List<BoardAreaAttribute> attributes = new ArrayList<BoardAreaAttribute>();
	
	
	public AreaManager() {
	}
	
	
	public void addBoardAreaAttribute(BoardAreaAttribute attr) {
		
	}
	
	public void addBoardAreaAttributeByIndex(BoardAreaAttribute attr, int index) {
		
	}
	
	public void removeBoardAreaAttribute(Long id) {
		// see if I can get a equals comparator for list to remove by Id instead of having to check it
	}

	public List<BoardAreaAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<BoardAreaAttribute> attributes) {
		this.attributes = attributes;
	}
}