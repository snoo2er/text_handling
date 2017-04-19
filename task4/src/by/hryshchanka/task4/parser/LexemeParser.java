package by.hryshchanka.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.hryshchanka.task4.entity.Punctuation;
import by.hryshchanka.task4.entity.TextComponent;
import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.entity.Word;

public class LexemeParser extends ChainParser {
	private static final String WORD_REGEX = "\\w+";
	private static final String PUNCTUATION_REGEX = "\\p{Punct}+";
	private static final String LEXEME_BEGINS_WITH_LETTER = "\\w.*";

	@Override
	public TextComponent parse(String lexeme) {
		TextComposite wordAndPunctuation = new TextComposite();
		Pattern wordPattern = Pattern.compile(WORD_REGEX);
		Pattern punctPattern = Pattern.compile(PUNCTUATION_REGEX);
		Matcher wordMatcher = wordPattern.matcher(lexeme);
		Matcher punctMatcher = punctPattern.matcher(lexeme);
		if (lexeme.matches(LEXEME_BEGINS_WITH_LETTER)) {
			while (wordMatcher.find()) {
				wordAndPunctuation.add(new Word(wordMatcher.group()));
				if (punctMatcher.find()) {
					wordAndPunctuation.add(new Punctuation(punctMatcher.group()));
				}
			}
		} else {
			while (punctMatcher.find()) {
				wordAndPunctuation.add(new Punctuation(punctMatcher.group()));
				if (wordMatcher.find()) {
					wordAndPunctuation.add(new Word(wordMatcher.group()));
				}
			}
		}
		return wordAndPunctuation;
	}
}
