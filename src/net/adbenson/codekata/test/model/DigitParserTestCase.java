package net.adbenson.codekata.test.model;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.parser.DigitParser;
import net.adbenson.codekata.test.fixture.MockDigit;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Before;
import org.junit.Test;

public class DigitParserTestCase {
	
	private static final String test1 = "TEST1";
	private static final String test2 = "!@(*&#";
	private static final String test3 = "";
	
	private DigitParser parser;
	private HashMap<String, Integer> patterns;
	private MockDigit digit;

	@Before
	public void setUp() {
		parser = new DigitParser();
		patterns = new HashMap<String, Integer>();
		parser.setDigitPatterns(patterns);
	}
	
	@Test
	public void test() {
		patterns.put(AccountFileProvider.FLAT_EIGHT, 8);
		
		Digit digit = parser.parse(AccountFileProvider.digitEight());
		
		assertEquals(8, digit.getValue());
	}
	
	@Test
	public void testMulti() {
		patterns.put(test1, 5);
		patterns.put(AccountFileProvider.FLAT_EIGHT, 7);
		patterns.put(test3, 3);
		
		digit.setFlat(test2);
		
		Digit digit = parser.parse(AccountFileProvider.digitEight());
		
		assertEquals(7, digit.getValue());
	}

}
