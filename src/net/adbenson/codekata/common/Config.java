package net.adbenson.codekata.common;

import java.util.HashMap;

public class Config {
	
	public static final int LINES_PER_NUMBER = 3;
	
	public static final int CHARACTERS_PER_LINE = 27;
	
	public static final int CHARACTERS_PER_DIGIT = 3;
	
	public static final int DIGITS_PER_NUMBER = CHARACTERS_PER_LINE / CHARACTERS_PER_DIGIT;
	
	public static final HashMap<String, Integer> DIGIT_PATTERNS;
	
	static {
		DIGIT_PATTERNS = new HashMap<String, Integer>();
		DIGIT_PATTERNS.put(" _ | ||_|", 0);
		DIGIT_PATTERNS.put("     |  |", 1);
		DIGIT_PATTERNS.put(" _  _||_ ", 2);
		DIGIT_PATTERNS.put(" _  _| _|", 3);
		DIGIT_PATTERNS.put("   |_|  |", 4);
		DIGIT_PATTERNS.put(" _ |_  _|", 5);
		DIGIT_PATTERNS.put(" _ |_ |_|", 6);
		DIGIT_PATTERNS.put(" _   |  |", 7);
		DIGIT_PATTERNS.put(" _ |_||_|", 8);
		DIGIT_PATTERNS.put(" _ |_| _|", 9);
	}

}
