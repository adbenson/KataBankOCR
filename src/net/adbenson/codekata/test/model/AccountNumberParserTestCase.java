package net.adbenson.codekata.test.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.adbenson.codekata.common.Config;
import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.parser.AccountNumberParser;
import net.adbenson.codekata.test.fixture.MockAccountNumber;
import net.adbenson.codekata.test.fixture.MockDigitParser;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Before;
import org.junit.Test;

public class AccountNumberParserTestCase {
	
	private AccountNumberParser parser;
	private MockDigitParser digitParser;
		
	@Before
	public void setUp() {
		parser = new AccountNumberParser();
		digitParser = new MockDigitParser();
		
		parser.setDigitParser(digitParser);
	}

	@Test
	public void testAsc() {
		digitParser.digits = AccountFileProvider.ASC_DIGITS;
		
		AccountNumber account = parser.parse(AccountFileProvider.ascendingDigits());
				
		assertEquals(AccountFileProvider.ASC_NUMBER, account.getValue());
		assertEquals(Config.DIGITS_PER_NUMBER, account.getDigits().size());
	}
	
	@Test
	public void testBinary() {
		digitParser.digits = AccountFileProvider.BINARY_DIGITS;
				
		AccountNumber account = parser.parse(AccountFileProvider.binaryDigits());
				
		assertEquals(AccountFileProvider.BINARY, account.getValue());
		assertEquals(Config.DIGITS_PER_NUMBER, account.getDigits().size());
	}
	
	@Test
	public void testSeparateOne() {
	
		List<String> rows = parser.separateDigits(AccountFileProvider.ascendingDigits(), 0);
			
		assertEquals(AccountFileProvider.digitOne(), rows);
	}
	
	@Test
	public void testSeparateEight() {
	
		List<String> rows = parser.separateDigits(AccountFileProvider.ascendingDigits(), 7);
			
		assertEquals(AccountFileProvider.digitEight(), rows);
	}
	
	@Test
	public void testSeparateZero() {
	
		List<String> rows = parser.separateDigits(AccountFileProvider.binaryDigits(), 0);
			
		assertEquals(AccountFileProvider.digitOne(), rows);
		
		rows = parser.separateDigits(AccountFileProvider.binaryDigits(), 1);
		
		assertEquals(AccountFileProvider.digitZero(), rows);
	}

}
