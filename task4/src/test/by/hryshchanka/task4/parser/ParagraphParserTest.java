package test.by.hryshchanka.task4.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.parser.ParagraphParser;

public class ParagraphParserTest {
	@Test
	public void parseSizeTest() {
		ParagraphParser parser = new ParagraphParser();
		TextComposite actual = (TextComposite) parser.parse("Hello big world. Hi mate. How are you?");

		assertThat(actual.getParts().size(), equalTo(3));
	}
}
