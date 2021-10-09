package org.se.lab.data;

public class Card implements Comparable<Card> {
	private final Color color;
	private final Value value;

	public Card(Color color, Value value) {
		this.color = color;
		this.value = value;
	}

	public Card(int color, int value) {
		if (color < 0 || color > Color.HEARTS.ordinal() || value < 0 || value > Value.ACE.ordinal())
			throw new IllegalArgumentException(String.format(
					"Invalid numeric values (%d,%d) for color and value. Color must be between 0 and %d. Value must be between 0 and %d.",
					color, value, Color.HEARTS.ordinal(), Value.ACE.ordinal()));

		this.color = Color.values()[color];
		this.value = Value.values()[value];

	}

	public Color getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(value.toString()).append(" of ").append(color.toString()).toString();
	}

	@Override
	public int compareTo(Card card) {
		if (card.getValue().ordinal() < this.getValue().ordinal())
			return -1;
		if (card.getValue().ordinal() > this.getValue().ordinal())
			return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}
