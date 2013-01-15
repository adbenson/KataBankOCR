package net.adbenson.codekata.parser;

import net.adbenson.codekata.common.Config;
import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.model.Digit;

public class AccountNumberParser {
	
	private DigitParser digitParser;

	public long parse(AccountNumber account) {
		long number = 0;
		
		for(int i=0; i<Config.DIGITS_PER_NUMBER; i++) {
			Digit digit = new Digit(account.getLines(), i);
			int digitValue = digitParser.parse(digit);
			
			int power = Config.DIGITS_PER_NUMBER - i - 1;
			number += digitValue * Math.round(Math.pow(10, power));
		}
		
		return number;
	}
	
	public void setDigitParser(DigitParser digitParser) {
		this.digitParser = digitParser;		
	}
}
