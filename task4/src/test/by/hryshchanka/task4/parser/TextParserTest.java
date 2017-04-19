package test.by.hryshchanka.task4.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.parser.TextParser;

public class TextParserTest {
	@Test
	public void parseSizeTest() {
		TextParser parser = new TextParser();
		TextComposite actual = (TextComposite) parser.parse("\tHello big world. \tHi mate. \tHow are you?");

		assertThat(actual.getParts().size(), equalTo(3));
	}
}
