package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;
import org.se.lab.data.Value;

import java.util.Collections;
import java.util.List;

public class StreightFlushValidator extends PokerHandValidator {

	@Override
	protected Hand validate(List<Card> cards) {
if (new FlushValidator().validate(cards) == null)
	return null;
if (new StreightValidator().validate(cards) == null)
	return null;

Collections.sort(cards);
Card highCard = cards.get(1).getValue() == Value.FIVE ? cards.get(1) : cards.get(0);
		return new Hand(HandCategory.STREIGHT_FLUSH, highCard, cards);
	}

}
