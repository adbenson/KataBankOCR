package net.adbenson.codekata.test.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.test.fixture.MockDigit;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Before;
import org.junit.Test;

public class AccountNumberTestCase {
	
	List<Digit> digitList;
	Digit d1;
	Digit d2;
	
	@Before
	public void setUp() {
		digitList = new ArrayList<Digit>();
		
		d1 = new MockDigit();
		digitList.add(d1);
		
		d2 = new MockDigit();
		digitList.add(d2);
	}
	
	@Test
	public void testOne() {
		AccountNumber account = new AccountNumber(digitList, 9876543210l);
		
		assertEquals(9876543210l, account.getValue());
		assertEquals(digitList, account.getDigits());
	}
	
	@Test
	public void testTwo() {
		AccountNumber account = new AccountNumber(digitList, 1234567890l);
		
		assertEquals(1234567890l, account.getValue());
		assertEquals(digitList, account.getDigits());
	}
}
