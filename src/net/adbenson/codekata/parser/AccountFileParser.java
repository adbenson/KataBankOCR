package net.adbenson.codekata.parser;

import java.util.ArrayList;
import java.util.List;

import net.adbenson.codekata.common.Config;
import net.adbenson.codekata.model.AccountNumber;

/**
 * AccountFileParser parses a "file" of Strings down to Long account numbers
 * @author Andrew
 *
 */
public class AccountFileParser {
	
	/**
	 * The parser used for parsing the individual numbers
	 */
	private AccountNumberParser accountNumberParser;
	
	/**
	 * Parse takes a list of "graphical" account numbers and returns a list
	 * of Long representations of those numbers
	 * @param list
	 * @return
	 */
	public List<AccountNumber> parse(List<String> accountFileLines) {
		
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
		
		//Remove the lines already parsed into an account number
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
