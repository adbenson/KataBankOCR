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
		
		List<AccountNumber> parsedAccounts = new ArrayList<AccountNumber>();
		
		List<List<String>> accounts = separateAccounts(accountFileLines);
		
		for (List<String> account : accounts) {
			parsedAccounts.add(accountNumberParser.parse(account));
		}
		
		return parsedAccounts;
	}

	public List<List<String>> separateAccounts(List<String> list) {
		
		List<List<String>> accounts = new ArrayList<List<String>>();

		if (list.size() >= Config.LINES_PER_NUMBER + 1) {
			List<String> subList = new ArrayList<String>(list.subList(0, Config.LINES_PER_NUMBER));
			accounts.add(new ArrayList<String>(subList));
			
			List<String> remaining = list.subList(Config.LINES_PER_NUMBER + 1, list.size());
			accounts.addAll(separateAccounts(remaining));
		}
		
		return accounts;
	}

	public void setAccountNumberParser(AccountNumberParser numberParser) {
		this.accountNumberParser = numberParser;
	}

}
