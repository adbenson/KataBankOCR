package net.adbenson.codekata.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import net.adbenson.codekata.common.Config;
import net.adbenson.codekata.parser.AccountFileParser;
import net.adbenson.codekata.parser.AccountNumberParser;
import net.adbenson.codekata.parser.DigitParser;

public class KataBankOCR {
	
	public static void main(String[] args) {
		AccountFileParser fileParser = new AccountFileParser();
		AccountNumberParser numberParser = new AccountNumberParser();
		DigitParser digitParser = new DigitParser();
		
		fileParser.setAccountNumberParser(numberParser);
		numberParser.setDigitParser(digitParser);
		digitParser.setDigitPatterns(Config.DIGIT_PATTERNS);
		
		
		Path path = FileSystems.getDefault().getPath(args[0]);
		try {
			List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
			
			List<Long> accounts = fileParser.parse(lines);
			
			System.out.println(accounts);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
