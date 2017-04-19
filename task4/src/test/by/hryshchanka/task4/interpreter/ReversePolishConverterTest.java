package test.by.hryshchanka.task4.interpreter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import by.hryshchanka.task4.interpreter.ReversePolishConverter;

@RunWith(Parameterized.class)
public class ReversePolishConverterTest {
	private String testExpression;
	private String expected;
	
	public ReversePolishConverterTest(String testExpression, String expected) {
		super();
		this.testExpression = testExpression;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static List<Object[]> expressionData() {
		return Arrays.asList(new Object[][] {
				{"1+3", "1 3 +"},
				{"1+3/2", "1 3 2 / +"},
				{"(1+3)/2", "1 3 + 2 /"},
				{"6+4*(1+3)/2", "6 4 1 3 + * 2 / +"}
		});
		
	}
	
	@Test
	public void convertTest() {
		String actual = ReversePolishConverter.convert(testExpression, 0, 0);
		assertEquals(expected, actual);
	}
}
