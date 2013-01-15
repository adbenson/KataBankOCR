package net.adbenson.codekata.test.fixture;

import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.parser.AccountNumberParser;

public class MockAccountNumberParser extends AccountNumberParser {
	
	long[] results;
	int pointer = 0;

	public void setOutput(long[] ls) {
		results = ls;
	}
	
	public long parse(AccountNumber n) {
		return results[pointer++];
	}

}
