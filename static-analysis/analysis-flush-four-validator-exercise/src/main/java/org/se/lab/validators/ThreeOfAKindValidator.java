package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;
import org.se.lab.data.HistPair;

import java.util.List;

public class ThreeOfAKindValidator extends PokerHandValidator {

	@Override
	protected Hand validate(List<Card> cards) {

		List<HistPair> hist = calcValueHistogram(cards);
		if (hist.size() != 3 || hist.get(0).getCount() != 3)
			return null;
				
		Card highCard = null; 
		for (Card c : cards) 
			if (c.getValue() == hist.get(0).getKey()) {
				highCard = c;
				break;
			}

		return new Hand(HandCategory.THREE_OF_A_KIND, highCard,cards);
	}

}
