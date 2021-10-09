package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;
import org.se.lab.data.Value;

import java.util.Collections;
import java.util.List;

public class StreightValidator extends PokerHandValidator {

	private static final int STREIGHT_CARD_COUNT = 5;
	private static final int STREIGHT_RANGE = 4;

	@Override
	protected Hand validate(List<Card> cards) {
		if (calcValueHistogram(cards).size() != STREIGHT_CARD_COUNT)
			return null;
		
		Collections.sort(cards);
		Card highCard = cards.get(0);
		Card lowCard = cards.get(cards.size()-1);
		Card semiHighCard = cards.get(1);
		
		if (highCard.getValue().ordinal() - lowCard.getValue().ordinal() == STREIGHT_RANGE || (highCard.getValue() == Value.ACE && semiHighCard.getValue() == Value.FIVE))
		{
			highCard = cards.get(1).getValue() == Value.FIVE ? cards.get(1) : cards.get(0);
		return new Hand(HandCategory.STREIGHT, highCard, cards);
		}
		return null;
	}

}
