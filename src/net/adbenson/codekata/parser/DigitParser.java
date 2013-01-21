package net.adbenson.codekata.parser;

import java.util.HashMap;
import java.util.List;

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
	 * @return the Digit corresponding to the given symbol
	 */
	public Digit parse(List<String> digitLines) {
		
		Digit digit = new Digit(digitLines);
		return digitPatterns.get(digit.flatten());
	}

	public void setDigitPatterns(HashMap<String, Integer> digitPatterns) {
		this.digitPatterns = digitPatterns;
	}
	
	/**
	 * Flattens the 2D representation of this character to a simple string for pattern matching
	 * @return a simple string representation of this digit for pattern matching
	 */
	private String flatten(List<String> rows) {
		StringBuilder flat = new StringBuilder();
		for (String row : rows) {
			flat.append(row);
		}
		return flat.toString();
	}

}
