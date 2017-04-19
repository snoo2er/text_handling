package by.hryshchanka.task4.entity;

public class Word implements TextComponent {
	private String text;

	public Word(String text) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Word other = (Word) obj;
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}

	@Override
	public String assembleText() {
		return text;
	}

}
