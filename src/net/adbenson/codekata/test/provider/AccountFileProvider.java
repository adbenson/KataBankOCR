package net.adbenson.codekata.test.provider;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;

public class AccountFileProvider {
		
	public static final Long ASC_NUMBER = 123456789l;
	
	public static final Long DESC_NUMBER = 987654321l;
	
	public static final Long BINARY = 100000001l;
	
	public static final String FLAT_EIGHT = " _ |_||_|";	 
	
	public static List<String> digitOne() {
		List<String> lines = new ArrayList<String>();
		
		lines.add("   ");
		lines.add("  |");
		lines.add("  |");
		
		return lines;
	}
	
	public static List<String> digitEight() {
		List<String> lines = new ArrayList<String>();
		
		lines.add(" _ ");
		lines.add("|_|");
		lines.add("|_|");
		
		return lines;
	}
	
	public static List<String> digitNine() {
		List<String> lines = new ArrayList<String>();
		
		lines.add(" _ ");
		lines.add("|_|");
		lines.add(" _|");
		
		return lines;
	}
	
	public static List<String> blankDigits() {
		List<String> lines = new ArrayList<String>();
		
		for(int l=0; l<Config.LINES_PER_NUMBER; l++) {
			lines.add(blankLine());
		}
		
		return lines;
	}
	
	public static String blankLine() {
		StringBuilder line = new StringBuilder();
		for (int c=0; c<Config.CHARACTERS_PER_LINE; c++) {
			line.append(" ");
		}
		return line.toString();
	}
	
	public static List<String> ascendingDigits() {
		List<String> lines = new ArrayList<String>();
		
		lines.add("    _  _     _  _  _  _  _ ");
		lines.add("  | _| _||_||_ |_   ||_||_|");
		lines.add("  ||_  _|  | _||_|  ||_| _|");
		
		return lines;
	}
	
	public static List<String> accountNumbers(int n) {
		List<String> lines = new ArrayList<String>();
		
		for (int i=0; i<n; i++) {
			lines.addAll(ascendingDigits());
			lines.add(blankLine());
		}
		
		return lines;
	}
}
