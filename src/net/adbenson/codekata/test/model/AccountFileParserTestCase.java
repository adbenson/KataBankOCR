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
	}

	@Test
	public void testParse() {
		
		numberParser.setOutput(new AccountNumber[]{
				new MockAccountNumber(AccountFileProvider.ASC_NUMBER), 
				new MockAccountNumber(AccountFileProvider.DESC_NUMBER), 
				new MockAccountNumber(AccountFileProvider.BINARY)
		});
		
		List<AccountNumber> result = parser.parse(AccountFileProvider.accountNumbers(3));
		
		assertEquals(3, result.size());
		
		assertEquals(AccountFileProvider.ASC_NUMBER, result.get(0).getValue());
		
		assertEquals(AccountFileProvider.DESC_NUMBER, result.get(1).getValue());
		
		assertEquals(AccountFileProvider.BINARY, result.get(2).getValue());
	}
	
	@Test
	public void testSeparateAccounts() {

		List<String> lines = new ArrayList<String>();
		lines.addAll(AccountFileProvider.ascendingDigits());
		lines.add(AccountFileProvider.blankLine());
		lines.addAll(AccountFileProvider.binaryDigits());
		lines.add(AccountFileProvider.blankLine());
		lines.addAll(AccountFileProvider.ascendingDigits());
		lines.add(AccountFileProvider.blankLine());
		lines.addAll(AccountFileProvider.binaryDigits());
		lines.add(AccountFileProvider.blankLine());
		
		List<List<String>> accts = parser.separateAccounts(lines);
		
		assertEquals(4, accts.size());
		
		assertEquals(AccountFileProvider.ascendingDigits(), accts.get(0));
		assertEquals(AccountFileProvider.binaryDigits(), accts.get(1));
		assertEquals(AccountFileProvider.ascendingDigits(), accts.get(2));
		assertEquals(AccountFileProvider.binaryDigits(), accts.get(3));

	}

}
