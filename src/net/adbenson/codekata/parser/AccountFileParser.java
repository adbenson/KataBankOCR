package net.adbenson.codekata.parser;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;
import net.adbenson.codekata.model.AccountNumber;

public class AccountFileParser {
	
	private AccountNumberParser accountNumberParser;
	
	public List<Long> parse(List<String> list) {
		
		List<Long> parsedNumbers = new ArrayList<Long>();
		
		List<AccountNumber> accounts = separateAccounts(list);
		
		for (AccountNumber account : accounts) {
			parsedNumbers.add(accountNumberParser.parse(account));
		}
		
		return parsedNumbers;
	}

	private List<AccountNumber> separateAccounts(List<String> list) {
		
		List<AccountNumber> accounts = new ArrayList<AccountNumber>();
		accounts.add(new AccountNumber(list));
		
		list.subList(0, Config.LINES_PER_NUMBER + 1).clear();
			
		if (list.size() >= Config.LINES_PER_NUMBER) {
			accounts.addAll(separateAccounts(list));
		}
		
		return accounts;
	}

	public void setAccountNumberParser(AccountNumberParser numberParser) {
		this.accountNumberParser = numberParser;
	}

}
