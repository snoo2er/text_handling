package test.by.hryshchanka.task4.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.parser.SentenceParser;

public class SentenceParserTest {
	@Test
	public void parseSizeTest() {
		SentenceParser parser = new SentenceParser();
		TextComposite actual = (TextComposite) parser.parse("Hello big world.");

		assertThat(actual.getParts().size(), equalTo(3));
	}
}
