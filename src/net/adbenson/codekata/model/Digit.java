package net.adbenson.codekata.model;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;

public class Digit {
	
	private List<String> rows;
	
	private int value;
	
	public Digit(List<String> lines, int offset) {
		offset *= Config.CHARACTERS_PER_DIGIT;
		
		rows = new ArrayList<String>();
		for(String line : lines) {
			String row = line.substring(offset, offset + Config.CHARACTERS_PER_DIGIT);
			rows.add(row);
		}
				
	}
	
	public String flatten() {
		StringBuilder flat = new StringBuilder();
		for (String row : rows) {
			flat.append(row);
		}
		return flat.toString();
	}

	public Object getRows() {
		return rows;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
