package net.adbenson.codekata.model;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;

/**
 * Digit class models a "graphical" digit as a set of String rows
 * @author Andrew D Benson
 *
 */
public class Digit {
	
	private List<String> rows;
	
	private int value;
		
	/**
	 * This constructor takes a set of lines (representing an account number) 
	 * and an offset indicating which digit in the row to parse and stores the resulting digit
	 * @param lines the Strings to pull the digit from
	 * @param offset the 0-indexed digit number from the left
	 */
	public Digit(List<String> rows, int value) {
		this.rows = rows;
		this.value = value;
	}
	
	/**
	 * Flattens the 2D representation of this character to a simple string for pattern matching
	 * @return a simple string representation of this digit for pattern matching
	 */
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
	
}
