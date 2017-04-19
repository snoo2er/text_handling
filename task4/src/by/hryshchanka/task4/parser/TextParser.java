package by.hryshchanka.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task4.entity.ElementType;
import by.hryshchanka.task4.entity.TextComponent;
import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.reader.TextReader;

public class TextParser extends ChainParser {
	private static final Logger LOGGER = LogManager.getLogger(TextReader.class);
	private static final String PARAGRAPH_REGEX = "(\\t|^)([.[^\\t]]+)";
	private ParagraphParser parser = new ParagraphParser();

	@Override
	public TextComponent parse(String text) {
		LOGGER.log(Level.INFO, "text for handle:\n" + text + "\n");
		TextComposite paragraphs = new TextComposite(ElementType.TEXT);
		Pattern parPattern = Pattern.compile(PARAGRAPH_REGEX);
		Matcher parMatcher = parPattern.matcher(text);

		while (parMatcher.find()) {
			TextComposite paragraph = new TextComposite(ElementType.PARAGRAPH);
			TextComposite paragraphPart = (TextComposite) parser.parse(parMatcher.group().trim());
			paragraphPart.getParts().forEach(paragraph::add);
			paragraphs.add(paragraph);
		}
		return paragraphs;
	}
}
