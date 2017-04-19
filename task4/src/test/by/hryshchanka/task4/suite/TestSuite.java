package test.by.hryshchanka.task4.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.by.hryshchanka.task4.entity.MathExpressionTest;
import test.by.hryshchanka.task4.interpreter.CalculatorTest;
import test.by.hryshchanka.task4.interpreter.ReversePolishConverterTest;
import test.by.hryshchanka.task4.parser.LexemeParserTest;
import test.by.hryshchanka.task4.parser.ParagraphParserTest;
import test.by.hryshchanka.task4.parser.SentenceParserTest;
import test.by.hryshchanka.task4.parser.TextParserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TextParserTest.class, ParagraphParserTest.class, SentenceParserTest.class, LexemeParserTest.class,
		ReversePolishConverterTest.class, CalculatorTest.class, MathExpressionTest.class })
public class TestSuite {

}
