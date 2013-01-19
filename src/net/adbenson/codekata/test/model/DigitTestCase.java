package net.adbenson.codekata.test.model;

import static org.junit.Assert.*;

import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Test;

public class DigitTestCase {
	
	@Test
	public void testOne() {
		Digit digit = new Digit(AccountFileProvider.ascendingDigits(), 1);
		
		assertEquals(AccountFileProvider.ascendingDigits(), digit.getRows());
		assertEquals(1, digit.getValue());
	}
	
	@Test
	public void testNine() {
		Digit digit = new Digit(AccountFileProvider.digitNine(), 9);
		
		assertEquals(AccountFileProvider.digitNine(), digit.getRows());
		assertEquals(9, digit.getValue());
	}
	
	@Test
	public void testFlattenEight() {
		Digit digit = new Digit(AccountFileProvider.digitEight(), 0);
		
		assertEquals(AccountFileProvider.FLAT_EIGHT, digit.flatten());
	}

}
