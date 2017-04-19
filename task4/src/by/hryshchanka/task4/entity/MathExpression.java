package by.hryshchanka.task4.entity;

import by.hryshchanka.task4.interpreter.Calculator;
import by.hryshchanka.task4.interpreter.ReversePolishConverter;

public class MathExpression implements TextComponent {
	private String text;

	public MathExpression(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public void add(TextComponent component) {
	}

	@Override
	public String assembleText() {
		String polishString = ReversePolishConverter.convert(text, 10, 5);
		Calculator interpreter = new Calculator(polishString);
		return interpreter.calculate().toString();
	}
}
