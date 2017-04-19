package test.by.hryshchanka.task4.parser;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import by.hryshchanka.task4.entity.Punctuation;
import by.hryshchanka.task4.entity.TextComponent;
import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.entity.Word;
import by.hryshchanka.task4.parser.LexemeParser;

public class LexemeParserTest {

	@Test
	public void parseTest() {
		TextComponent expWordOne = new Word("asd");
		TextComponent expPunctOne = new Punctuation("-");
		TextComponent expPunctTwo = new Punctuation("+");

		LexemeParser parser = new LexemeParser();
		TextComposite actual = (TextComposite) parser.parse("-asd+");

		assertThat(actual.getParts(), allOf(hasItem(expPunctOne), hasItem(expWordOne), hasItem(expPunctTwo)));
	}
}
