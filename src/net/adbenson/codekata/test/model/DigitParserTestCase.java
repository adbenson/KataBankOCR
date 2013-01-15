package net.adbenson.codekata.test.model;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import net.adbenson.codekata.parser.DigitParser;
import net.adbenson.codekata.test.fixture.MockDigit;

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
		digit = new MockDigit();
	}
	
	@Test
	public void test() {
		patterns.put(test1, 5);
		digit.setFlat(test1);
		
		int value = parser.parse(digit);
		
		assertEquals(5, value);
	}
	
	@Test
	public void testMulti() {
		patterns.put(test1, 5);
		patterns.put(test2, 7);
		patterns.put(test3, 3);
		
		digit.setFlat(test2);
		
		int value = parser.parse(digit);
		
		assertEquals(7, value);
	}

}
