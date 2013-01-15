package net.adbenson.codekata.test.fixture;

import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.parser.DigitParser;
import net.adbenson.codekata.test.provider.AccountFileProvider;

public class MockDigitParser extends DigitParser {
	
	int i = 1;
	
	public int parse(Digit digit) {
		return i++;
	}

}
