package org.se.lab.data;

import java.util.List;

public class Hand implements Comparable<Hand> {
	private final HandCategory category;
	private final Card highCard;
	private final List<Card> cards;

	public Hand(HandCategory category, Card highCard, List<Card> cards) {
		this.category = category;
		this.highCard = highCard;
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public HandCategory getCategory() {
		return category;
	}

	public Card getHighCard() {
		return highCard;
	}

	@Override
	public int compareTo(Hand hand) {
		if (this.getCategory().ordinal() < hand.getCategory().ordinal())
			return 1;
		if (this.getCategory().ordinal() > hand.getCategory().ordinal())
			return -1;

		return this.getHighCard().compareTo(hand.getHighCard());
	}

	@Override
	public String toString() {
		return this.getCategory().toString() + "(" + this.getHighCard().toString() + ")";
	}

}
