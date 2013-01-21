package net.adbenson.codekata.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import net.adbenson.codekata.common.Config;

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
	
	public boolean isValid() {
		long sum = 0;
		
		for(int i=0; i<digits.size(); i++) {
			int position = Config.DIGITS_PER_NUMBER - i;
			sum += digits.get(i).getValue() * position;
		}
		
		long mod = sum % 11;
		return mod == 0;
	}
}
