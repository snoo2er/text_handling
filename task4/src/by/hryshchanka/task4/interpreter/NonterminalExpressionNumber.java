package by.hryshchanka.task4.interpreter;

public class NonterminalExpressionNumber extends AbstractMathExpression {
	private int number;

	public NonterminalExpressionNumber(int number) {
		super();
		this.number = number;
	}

	@Override
	public void interpret(Context context) {
		context.pushValue(number);
	}

}
