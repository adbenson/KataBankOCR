package net.adbenson.codekata.test.fixture;

import java.util.List;

import net.adbenson.codekata.model.AccountNumber;
import net.adbenson.codekata.test.provider.AccountFileProvider;

public class MockAccountNumber extends AccountNumber {
	
	public MockAccountNumber() {
		super(AccountFileProvider.blankDigits());
	}

	public List<String> getLines() {
		return AccountFileProvider.ascendingDigits();
	}
	
}
