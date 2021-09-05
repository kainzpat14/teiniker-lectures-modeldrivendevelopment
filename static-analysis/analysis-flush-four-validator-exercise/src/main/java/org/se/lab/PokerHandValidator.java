package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.se.lab.data.Card;
import org.se.lab.data.Hand;
import org.se.lab.data.HistPair;
import org.se.lab.validators.*;

public abstract class PokerHandValidator {
	private static final int MINIMUM_CARD_COUNT = 5;
	private static final int POKER_HAND_SIZE = 5;
	private static List<PokerHandValidator> validators = null;

	public static Hand validateCards(List<Card> cards) {
		if (validators == null)
			initValidators();

		if (cards == null || cards.size() < MINIMUM_CARD_COUNT)
			throw new IllegalArgumentException("To less cards to validate a hand.");

		if (cards.size() > POKER_HAND_SIZE)
		{
			List<Hand> calculatedHands = new LinkedList<Hand>();
			
			for (Card c : cards) {
				List<Card> tmpCards = new ArrayList<Card>(cards);
				tmpCards.remove(c);
				calculatedHands.add(validateCards(tmpCards));
			}
			Collections.sort(calculatedHands);
			return calculatedHands.get(0);
		}

		Hand hand;
		for (PokerHandValidator validator : validators)
			if ((hand = validator.validate(cards)) != null)
				return hand;

		throw new IllegalStateException("No validator found!");
	}

	private static void initValidators() {
		validators = new ArrayList<PokerHandValidator>();

		validators.add(new RoyalFlushValidator());
		validators.add(new StreightFlushValidator());
		validators.add(new FourOfAKindValidator());
		validators.add(new FullHouseValidator());
		validators.add(new FlushValidator());
		validators.add(new StreightValidator());
		validators.add(new ThreeOfAKindValidator());
		validators.add(new TwoPairValidator());
		validators.add(new TwoOfAKindValidator());
		validators.add(new HighCardValidator());
	}

	protected abstract Hand validate(List<Card> cards);

	protected static List<HistPair> calcValueHistogram(List<Card> cards)
	{
		final List<HistPair> histogram = new ArrayList<HistPair>();
		
		histogram.clear();
		Collections.sort(cards);
		
		HistPair reference;
		for (Card c : cards)
		{
			reference = new HistPair(c.getValue());
			if (histogram.contains(reference))
			{
				reference.setCount(histogram.get(histogram.indexOf(reference)).getCount()+1);
				histogram.remove(reference);
				histogram.add(reference);
			}
			else
				histogram.add(reference);
		}
		Collections.sort(histogram);;
		return histogram;
	}
	
	protected static List<HistPair> calcColorHistogram(List<Card> cards)
	{
		final List<HistPair> histogram = new ArrayList<HistPair>();
		
		histogram.clear();
		Collections.sort(cards);
		
		HistPair reference;
		for (Card c : cards)
		{
			reference = new HistPair(c.getColor());
			if (histogram.contains(reference))
			{
				reference.setCount(histogram.get(histogram.indexOf(reference)).getCount()+1);
				histogram.remove(reference);
				histogram.add(reference);
			}
			else
				histogram.add(reference);
		}
		Collections.sort(histogram);;
		return histogram;
	}
	
}