package net.adbenson.codekata.parser;

import java.util.HashMap;

import net.adbenson.codekata.model.Digit;

public class DigitParser {
	
	private HashMap<String, Integer> digitPatterns;
	
	public int parse(Digit digit) {		
		return digitPatterns.get(digit.flatten());
	}

	public void setDigitPatterns(HashMap<String, Integer> digitPatterns) {
		this.digitPatterns = digitPatterns;
	}

}
