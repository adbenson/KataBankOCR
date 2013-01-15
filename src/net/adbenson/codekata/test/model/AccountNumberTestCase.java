package net.adbenson.codekata.test.model;

import static org.junit.Assert.*;

import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Test;

public class AccountNumberTestCase {

	@Test
	public void testConstructorOneLine() {
		AccountNumber account = new AccountNumber(AccountFileProvider.blankDigits());
		
		assertTrue(AccountFileProvider.blankDigits().equals(account.getLines()));
	}
	
	@Test
	public void testConstructorMultiLine() {
		AccountNumber account = new AccountNumber(AccountFileProvider.accountNumbers(3));
		
		assertTrue(AccountFileProvider.ascendingDigits().equals(account.getLines()));
	}

}
