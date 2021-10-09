package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;
import org.se.lab.data.HistPair;

import java.util.List;

public class TwoPairValidator extends PokerHandValidator {

	@Override
	protected Hand validate(List<Card> cards) {
		List<HistPair> hist = calcValueHistogram(cards);
		if (hist.size() != 3 || hist.get(0).getCount() != 2 || hist.get(1).getCount() != 2)
			return null;
				
		Card highCard1 = null;
		Card highCard2 = null;
		for (Card c : cards)
		{
			if (c.getValue() == hist.get(0).getKey()) 
				highCard1 = c;
			
			if (c.getValue() == hist.get(1).getKey()) 
				highCard2 = c;
		}

		return new Hand(HandCategory.TWO_PAIRS, highCard1.compareTo(highCard2) < 0 ? highCard1 : highCard2, cards);
	}

}
