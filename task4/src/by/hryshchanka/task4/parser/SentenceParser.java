package by.hryshchanka.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.hryshchanka.task4.entity.ElementType;
import by.hryshchanka.task4.entity.MathExpression;
import by.hryshchanka.task4.entity.TextComponent;
import by.hryshchanka.task4.entity.TextComposite;

public class SentenceParser extends ChainParser {
	private static final String LEXEME_MATH_REGEX = "(\\d|\\()([^a-zA-Z]|[ij])+|[^\\s]+(\\s|\\.)";
	private static final String LEXEME_REGEX = "\\D*";
	private LexemeParser parser = new LexemeParser();

	@Override
	public TextComponent parse(String sentence) {
		TextComposite lexemesAndExpressions = new TextComposite();
		Pattern lexPattern = Pattern.compile(LEXEME_MATH_REGEX);
		Matcher lexMatcher = lexPattern.matcher(sentence);

		while (lexMatcher.find()) {
			if (lexMatcher.group().matches(LEXEME_REGEX)) {
				TextComposite lexeme = new TextComposite(ElementType.LEXEME);
				TextComponent lexemePart = parser.parse(lexMatcher.group().trim());
				lexeme.add(lexemePart);
				lexemesAndExpressions.add(lexeme);
			} else {
				lexemesAndExpressions.add(new MathExpression(lexMatcher.group()));
			}
		}
		return lexemesAndExpressions;
	}
}
