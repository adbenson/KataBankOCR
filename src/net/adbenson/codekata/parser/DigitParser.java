package net.adbenson.codekata.parser;

import java.util.HashMap;

import net.adbenson.codekata.model.Digit;

/**
 * Digit parser takes a graphical digit and returns its mathematical value by comparing it 
 * to a given set of patterns
 * @author Andrew
 *
 */
public class DigitParser {
	
	/**
	 * The patterns represeting "flattened" versions of the digits, and their number value
	 */
	private HashMap<String, Integer> digitPatterns;
	
	/**
	 * Takes a "graphical" digit and returns its mathematical value
	 * @param digit
	 * @return the integer value of the given digit
	 */
	public int parse(Digit digit) {		
		return digitPatterns.get(digit.flatten());
	}

	public void setDigitPatterns(HashMap<String, Integer> digitPatterns) {
		this.digitPatterns = digitPatterns;
	}

}
