package net.adbenson.codekata.test.model;

import static org.junit.Assert.*;
import net.adbenson.codekata.parser.AccountNumberParser;
import net.adbenson.codekata.test.fixture.MockAccountNumber;
import net.adbenson.codekata.test.fixture.MockDigitParser;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Before;
import org.junit.Test;

public class AccountNumberParserTestCase {
	
	private AccountNumberParser parser;
	private MockDigitParser digitParser;
	private MockAccountNumber mockNumber;
	
	@Before
	public void setUp() {
		parser = new AccountNumberParser();
		digitParser = new MockDigitParser();
		
		parser.setDigitParser(digitParser);
		
		mockNumber = new MockAccountNumber();
	}

	@Test
	public void test() {
		Long result = parser.parse(mockNumber);
		
		assertEquals(AccountFileProvider.ASC_NUMBER, result);
	}

}
