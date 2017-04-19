package by.hryshchanka.task4.entity;

public class Punctuation implements TextComponent {
	private String punct;

	public Punctuation(String punct) {
		super();
		this.punct = punct;
	}

	@Override
	public void add(TextComponent component) {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((punct == null) ? 0 : punct.hashCode());
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
		Punctuation other = (Punctuation) obj;
		if (punct == null) {
			if (other.punct != null) {
				return false;
			}
		} else if (!punct.equals(other.punct)) {
			return false;
		}
		return true;
	}

	@Override
	public String assembleText() {
		return punct;
	}
}
