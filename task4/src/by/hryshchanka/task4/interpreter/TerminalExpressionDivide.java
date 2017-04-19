package by.hryshchanka.task4.interpreter;

public class TerminalExpressionDivide extends AbstractMathExpression {

	@Override
	public void interpret(Context context) {
		int denominator = context.popValue();
		context.pushValue(context.popValue() / denominator);
	}

}
