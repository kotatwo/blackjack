package com.design_shinbi.blackjack;

import java.util.Collections;
import java.util.List;

public class Stock {
	private List<Card> cards;

	public Stock() {
		initialize();
	}

	public void initialize() {
		List<Card> list = Card.getAllCards();
		Collections.shuffle(list);
		this.cards = list;	
	}

	public int getNumberOfCards() {
		return this.cards.size();
	}

	public Card pickCard() {
		Card card = this.cards.get(0);
		this.cards.remove(0);

		return card;
	}
}
