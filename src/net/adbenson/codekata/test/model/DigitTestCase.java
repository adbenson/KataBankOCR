package net.adbenson.codekata.test.model;

import static org.junit.Assert.*;

import net.adbenson.codekata.model.Digit;
import net.adbenson.codekata.test.provider.AccountFileProvider;

import org.junit.Test;

public class DigitTestCase {
	
	@Test
	public void testOne() {
		Digit digit = new Digit(AccountFileProvider.ascendingDigits(), 0);
		
		assertEquals(AccountFileProvider.digitOne(), digit.getRows());
	}
	
	@Test
	public void testNine() {
		Digit digit = new Digit(AccountFileProvider.ascendingDigits(), 8);
		
		assertEquals(AccountFileProvider.digitNine(), digit.getRows());
	}
	
	@Test
	public void testFlatten() {
		Digit digit = new Digit(AccountFileProvider.ascendingDigits(), 7);
		
		assertEquals(AccountFileProvider.FLAT_EIGHT, digit.flatten());
	}

}
