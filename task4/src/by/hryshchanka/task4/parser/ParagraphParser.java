package by.hryshchanka.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.hryshchanka.task4.entity.ElementType;
import by.hryshchanka.task4.entity.TextComponent;
import by.hryshchanka.task4.entity.TextComposite;

public class ParagraphParser extends ChainParser {
	private static final String SENTENCE_REGEX = "([^\\.\\?]+|[^\\.]{1,3}+)([\\.]{3}|[\\.\\?!])";
	private SentenceParser parser = new SentenceParser();

	@Override
	public TextComponent parse(String paragraph) {
		TextComposite sentences = new TextComposite(ElementType.PARAGRAPH);
		Pattern senPattern = Pattern.compile(SENTENCE_REGEX);
		Matcher senMatcher = senPattern.matcher(paragraph);

		while (senMatcher.find()) {
			TextComposite sentence = new TextComposite(ElementType.SENTENCE);
			TextComposite sentencePart = (TextComposite) parser.parse(senMatcher.group().trim());
			sentencePart.getParts().forEach(sentence::add);
			sentences.add(sentence);
		}
		return sentences;
	}
}
