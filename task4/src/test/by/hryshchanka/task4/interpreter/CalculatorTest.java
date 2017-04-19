package test.by.hryshchanka.task4.interpreter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import by.hryshchanka.task4.interpreter.Calculator;

@RunWith(Parameterized.class)
public class CalculatorTest {
	private String testExpression;
	private String expected;
	
	public CalculatorTest(String testExpression, String expected) {
		super();
		this.testExpression = testExpression;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static List<Object[]> expressionData() {
		return Arrays.asList(new Object[][] {
				{"1 3 +", "4"},
				{"1 3 2 / +", "2"},
				{"1 3 + 2 /", "2"},
				{"6 4 1 3 + * 2 / +", "14"}
		});
		
	}
	
	@Test
	public void calculateTest() {
		Calculator interpreter = new Calculator(testExpression);
		String actual = interpreter.calculate().toString();
		assertEquals(expected, actual);
	}
}
