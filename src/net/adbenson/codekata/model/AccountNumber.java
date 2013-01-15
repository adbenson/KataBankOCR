package net.adbenson.codekata.model;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;

public class AccountNumber {

	private List<String> lines;
	
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
