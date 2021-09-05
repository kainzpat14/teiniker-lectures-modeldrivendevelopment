package org.se.lab.data;

public enum Color {
	CLUBS, 
	SPATES, 
	DIAMONDS, 
	HEARTS;

	@Override
	public String toString() {
		final String[] translations = {"Clubs", "Spades", "Diamonds", "Hearts"};
		return translations[this.ordinal()];
	}
	
	
	
			
	
	

}
