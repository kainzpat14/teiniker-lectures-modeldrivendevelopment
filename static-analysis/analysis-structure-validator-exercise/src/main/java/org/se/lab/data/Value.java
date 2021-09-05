package org.se.lab.data;

public enum Value {
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING,
	ACE;
	
	@Override
	public String toString()
	{
		final String[] translations = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		return translations[this.ordinal()];
	}

}
