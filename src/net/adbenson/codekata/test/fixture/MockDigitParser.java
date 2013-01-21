package net.adbenson.codekata.test.fixture;

import java.util.List;

import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.parser.DigitParser;

public class MockDigitParser extends DigitParser {
	
	public int[] digits;
	int index = 0;
	
	public Digit parse(List<String> rows) {
		Digit digit = new MockDigit(digits[index++]);
		
		return digit;
	}

}
