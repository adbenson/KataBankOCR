package net.adbenson.codekata.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.test.fixture.MockDigit;

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
	
	@Test
	public void testValid() {
		AccountNumber acct1 = mockNumber(123456789l);
		assertTrue(acct1.isValid());
		
		AccountNumber acct2 = mockNumber(457508000l);
		assertTrue(acct2.isValid());
		
		AccountNumber acct3 = mockNumber(000000000l);
		assertTrue(acct3.isValid());
		
		AccountNumber acct4 = mockNumber(345882865l);
		assertTrue(acct4.isValid());
	}
	
	@Test
	public void testInvalid() {
		AccountNumber acct1 = mockNumber(664371495l);
		assertFalse(acct1.isValid());
		
		AccountNumber acct2 = mockNumber(999999999l);
		assertFalse(acct2.isValid());
		
		AccountNumber acct3 = mockNumber(111111111l);
		assertFalse(acct3.isValid());
		
		AccountNumber acct4 = mockNumber(987654321l);
		assertFalse(acct4.isValid());
	}

	private AccountNumber mockNumber(long value) {
		List<Digit> digits = new ArrayList<Digit>();
		
		String number = new DecimalFormat("000000000").format(value);
		for (int i=0; i<9; i++) {
			int val = Integer.valueOf(number.charAt(i)+"");//String concat forces 'char' to String
			digits.add(new MockDigit(val));
		}
		return new AccountNumber(digits, value);
	}
	
	@Test
	public void mockNumberMetaTest() {
		AccountNumber asc = mockNumber(123456789l);
		
		assertEquals(1, asc.getDigits().get(0).getValue());
		assertEquals(2, asc.getDigits().get(1).getValue());
		assertEquals(5, asc.getDigits().get(4).getValue());
		assertEquals(9, asc.getDigits().get(8).getValue());
	}
}
