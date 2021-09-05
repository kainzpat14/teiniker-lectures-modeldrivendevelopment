package org.se.lab.validators;

import org.se.lab.PokerHandValidator;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HandCategory;
import org.se.lab.data.Value;

import java.util.Collections;
import java.util.List;

public class RoyalFlushValidator extends PokerHandValidator {

	 

	@Override
	protected Hand validate(List<Card> cards) {
if (new StreightFlushValidator().validate(cards) == null)
	return null;

if (cards.get(cards.size()-1).getValue() != Value.TEN)
	return null;

Collections.sort(cards);
return new Hand(HandCategory.ROYAL_FLUSH, cards.get(0), cards);
	}
	}