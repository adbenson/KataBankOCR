package net.adbenson.codekata.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * AccountNumber class models a "graphical" account number made up of multiple string lines
 * @author Andrew D Benson
 * 
 */
public class AccountNumber {

	private List<Digit> digits;
	
	private long value;
	
	/**
	 * Contructor takes a list argument, pulls the top set of rows and stores them in this object
	 * @param list
	 */
	public AccountNumber(List<Digit> digits, long value) {
		this.digits = digits;
		this.value = value;
	}

	public List<Digit> getDigits() {
		return digits;
	}

	public long getValue() {
		return value;
	}
	
	public String toString() {
		DecimalFormat format = new DecimalFormat( "000000000" );
		return "Account Number: "+format.format(value);
	}
}
