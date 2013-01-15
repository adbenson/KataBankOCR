package net.adbenson.codekata.test.fixture;

import java.util.ArrayList;

import net.adbenson.codekata.model.Digit;

public class MockDigit extends Digit {
	
	private String flat;
	
	public MockDigit() {
		super(new ArrayList<String>(), 0);
	}
	
	public String flatten() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}
}
