package net.adbenson.codekata.test.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.adbenson.codekata.parser.AccountFileParser;
import net.adbenson.codekata.test.fixture.MockAccountNumberParser;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Before;
import org.junit.Test;

public class AccountFileParserTestCase {
	
	private AccountFileParser parser;
	private MockAccountNumberParser numberParser;
	
	@Before
	public void setUp() {
		parser = new AccountFileParser();
		numberParser = new MockAccountNumberParser();
		
		parser.setAccountNumberParser(numberParser);
	}

	@Test
	public void testParse() {
		numberParser.setOutput(new long[]{
				AccountFileProvider.ASC_NUMBER, AccountFileProvider.DESC_NUMBER, AccountFileProvider.BINARY});
		
		List<Long> result = parser.parse(AccountFileProvider.accountNumbers(3));
		
		assertEquals(3, result.size());
		
		assertEquals(AccountFileProvider.ASC_NUMBER, result.get(0));
		
		assertEquals(AccountFileProvider.DESC_NUMBER, result.get(1));
		
		assertEquals(AccountFileProvider.BINARY, result.get(2));
	}
	
	@Test
	public void testParseUneven() {
		numberParser.setOutput(new long[]{AccountFileProvider.ASC_NUMBER, AccountFileProvider.ASC_NUMBER});
		
		List<String> lines = AccountFileProvider.accountNumbers(2);
		lines.add(AccountFileProvider.blankLine());
		
		List<Long> result = parser.parse(lines);
		
		assertEquals(2, result.size());
		
		assertEquals(AccountFileProvider.ASC_NUMBER, result.get(0));
		
		assertEquals(AccountFileProvider.ASC_NUMBER, result.get(1));
	}

}
