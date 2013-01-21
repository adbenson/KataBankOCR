package net.adbenson.codekata.test.fixture;

import net.adbenson.codekata.model.AccountNumber;

public class MockAccountNumber extends AccountNumber {
	
	public long value;
	
	public MockAccountNumber(long value) {
		super(null, 0);
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
	
}
