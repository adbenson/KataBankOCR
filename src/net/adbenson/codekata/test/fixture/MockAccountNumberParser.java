package net.adbenson.codekata.test.fixture;

import java.util.List;

import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.parser.AccountNumberParser;

public class MockAccountNumberParser extends AccountNumberParser {
	
	AccountNumber[] results;
	int pointer = 0;

	public void setOutput(AccountNumber[] ls) {
		results = ls;
	}
	
	@Override
	public AccountNumber parse(List<String> list) {
		return results[pointer++];
	}

}
