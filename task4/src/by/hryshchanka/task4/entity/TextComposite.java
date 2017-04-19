package by.hryshchanka.task4.entity;

import java.util.ArrayList;

public class TextComposite implements TextComponent {
	private ElementType type;
	private ArrayList<TextComponent> parts = new ArrayList<>();

	public TextComposite() {
		super();
	}

	public TextComposite(ElementType type) {
		super();
		this.type = type;
	}

	public ArrayList<TextComponent> getParts() {
		return parts;
	}

	public ElementType getType() {
		return type;
	}

	@Override
	public String assembleText() {
		StringBuilder builder = new StringBuilder();
		boolean redLine = true;
		for (TextComponent component : parts) {
			builder.append(component.assembleText());
			if (component.getClass() == TextComposite.class) {
				TextComposite current = (TextComposite) component;
				if (current.type != null && current.type.toString().equals("PARAGRAPH")) {
					if (redLine) {
						builder.insert(0, "\t");
						redLine = false;
					}
					builder.append("\n\t");
				}
				if (current.type != null && current.type.toString().equals("LEXEME")) {
					builder.append(" ");
				}
			} else if (component.getClass() == MathExpression.class) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	@Override
	public void add(TextComponent component) {
		parts.add(component);

	}
}
