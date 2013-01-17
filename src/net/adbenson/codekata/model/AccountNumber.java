package net.adbenson.codekata.model;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;

/**
 * AccountNumber class models a "graphical" account number made up of multiple string lines
 * @author Andrew D Benson
 * 
 */
public class AccountNumber {

	private List<String> lines;
	
	/**
	 * Contructor takes a list argument, pulls the top set of rows and stores them in this object
	 * @param list
	 */
	public AccountNumber(List<String> list) {
		lines = new ArrayList<String>();
		
		for (int i=0; i<Config.LINES_PER_NUMBER; i++) {
			lines.add(list.get(i));
		}
	}

	public List<String> getLines() {
		return lines;
	}

}
