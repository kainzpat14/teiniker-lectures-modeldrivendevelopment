package org.se.lab.validators;

import java.util.Collections;
import java.util.List;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;

public class FlushValidator extends PokerHandValidator {

	private static final int FLUSH_COLOR_COUNT = 1;

	@Override
	protected Hand validate(List<Card> cards) {
if (calcColorHistogram(cards).size() > FLUSH_COLOR_COUNT)
		return null;
Collections.sort(cards);;
return new Hand(HandCategory.FLUSH, cards.get(0), cards);
	}

}
