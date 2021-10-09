package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;
import org.se.lab.data.HistPair;

import java.util.List;

public class FullHouseValidator extends PokerHandValidator {
	private static final int FULLHOUSE_THREE = 3;
	private static final int FULLHOUSE_TWO = 2;

	@Override
	protected Hand validate(List<Card> cards) {
		List<HistPair> hist = calcValueHistogram(cards);

		if (hist.size() != FULLHOUSE_TWO)
			return null;
		if (hist.get(0).getCount() != FULLHOUSE_THREE || hist.get(1).getCount() != FULLHOUSE_TWO)
			return null;

		Card highCard = null;
		for (Card c : cards)
			if (c.getValue() == hist.get(0).getKey()) {
				highCard = c;
				break;
			}

		return new Hand(HandCategory.FULL_HOUSE, highCard, cards);
	}

}
