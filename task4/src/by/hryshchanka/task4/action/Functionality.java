package by.hryshchanka.task4.action;

import java.util.ArrayList;
import java.util.Collections;

import by.hryshchanka.task4.entity.TextComponent;
import by.hryshchanka.task4.entity.TextComposite;
import by.hryshchanka.task4.parser.ParagraphParser;
import by.hryshchanka.task4.parser.SentenceParser;

public class Functionality {
	public static String changeFirstLastLexemes(String text) {
		ParagraphParser parParser = new ParagraphParser();
		ArrayList<TextComponent> sentences = ((TextComposite) parParser.parse(text)).getParts();
		for (TextComponent sentence : sentences) {
			if (((TextComposite) sentence).getParts().size() > 1) {
				TextComponent lastLexeme = ((TextComposite) sentence).getParts().get(((TextComposite) sentence).getParts().size() - 1);
				((TextComposite) sentence).getParts().remove(lastLexeme);
				((TextComposite) sentence).getParts().add(((TextComposite) sentence).getParts().get(0));
				((TextComposite) sentence).getParts().remove(0);
				((TextComposite) sentence).getParts().add(0, lastLexeme);
			}
		}
		StringBuilder output = new StringBuilder("Sentences in which first and last lexemes are interchanged:\n");
		for (TextComponent sentence : sentences) {
			output.append(sentence.assembleText() + "\n");
		}
		return output.toString();
	}

	public static String sortSentencesByLexemes(String text) {
		ParagraphParser parParser = new ParagraphParser();
		ArrayList<TextComponent> sentences = ((TextComposite) parParser.parse(text)).getParts();
		Collections.sort(sentences,(c1, c2) -> ((TextComposite) c1).getParts().size() - ((TextComposite) c2).getParts().size());
		StringBuilder output = new StringBuilder("Sentences sorted by number of lexemes:\n");
		for (TextComponent sentence : sentences) {
			output.append(sentence.assembleText() + "\n");
		}
		return output.toString();
	}

	private static ArrayList<TextComponent> sortLexemes(ArrayList<TextComponent> lexemes) {
		Collections.sort(lexemes, (c1, c2) -> (c1.assembleText().compareToIgnoreCase(c2.assembleText())));
		return lexemes;
	}

	public static String printLexemesAlphabeticalOrder(String text) {
		SentenceParser senParser = new SentenceParser();
		ArrayList<TextComponent> lexemes = ((TextComposite) senParser.parse(text)).getParts();
		sortLexemes(lexemes);
		StringBuilder output = new StringBuilder("Lexemes in alpabetical order:\n\t" + lexemes.get(0).assembleText());
		for (int i = 1; i < lexemes.size(); i++) {
			if (lexemes.get(i).assembleText().substring(0, 1).equalsIgnoreCase(lexemes.get(i - 1).assembleText().substring(0, 1))) {
				output.append(" " + lexemes.get(i).assembleText());
			} else {
				output.append("\n\t" + lexemes.get(i).assembleText());
			}
		}
		return output.append("\n").toString();
	}
}
