package org.se.lab.data;

public enum HandCategory {
HIGH_CARD,
TWO_OF_A_KIND,
TWO_PAIRS,
THREE_OF_A_KIND,
STREIGHT,
FLUSH,
FULL_HOUSE,
FOUR_OF_A_KIND,
STREIGHT_FLUSH,
ROYAL_FLUSH;
	
	@Override
	public String toString()
	{
		final String[] translations = {"High Card", "Two of a kind", "Two Pairs", "Three of a kind", "Streight", "Flush", "Full House", "Four of a kind", "Streight Flush", "Royal Flush"};
		
		return translations[this.ordinal()];
	}
}
