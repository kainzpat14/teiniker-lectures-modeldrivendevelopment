package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;

import java.util.Collections;
import java.util.List;


public class HighCardValidator extends PokerHandValidator {

	private static final int HIGH_CARD_COUNT = 5;

	@Override
	protected Hand validate(List<Card> cards) {
		if (calcValueHistogram(cards).size() < HIGH_CARD_COUNT)
			return null;
		
if (new FlushValidator().validate(cards) != null)
	return null;

if (new StreightValidator().validate(cards) != null)
	return null;
		
Collections.sort(cards);
		return new Hand(HandCategory.HIGH_CARD, cards.get(0), cards);
	}

}
