package net.adbenson.codekata.test.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;
import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.parser.AccountFileParser;
import net.adbenson.codekata.test.fixture.MockAccountNumber;
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
		
		numberParser.setOutput(new AccountNumber[]{
				new MockAccountNumber(AccountFileProvider.ASC_NUMBER), 
				new MockAccountNumber(AccountFileProvider.DESC_NUMBER), 
				new MockAccountNumber(AccountFileProvider.BINARY)
		});
	}

	@Test
	public void testParse() {
		List<AccountNumber> result = parser.parse(AccountFileProvider.accountNumbers(3));
		
		assertEquals(3, result.size());
		
		assertEquals(AccountFileProvider.ASC_NUMBER, result.get(0));
		
		assertEquals(AccountFileProvider.DESC_NUMBER, result.get(1));
		
		assertEquals(AccountFileProvider.BINARY, result.get(2));
	}
	
	@Test
	public void testSeparateAccounts() {
		
		List<String> lines = new ArrayList<String>();
		lines.addAll(AccountFileProvider.ascendingDigits());
		lines.addAll(AccountFileProvider.binaryDigits());
		lines.addAll(AccountFileProvider.ascendingDigits());
		
		List<List<String>> accts = parser.separateAccounts(lines);
		
		assertEquals(3, accts);
		
		assertEquals(AccountFileProvider.ascendingDigits(), accts.get(0));
		assertEquals(AccountFileProvider.binaryDigits(), accts.get(1));
		assertEquals(AccountFileProvider.ascendingDigits(), accts.get(2));

	}

}
