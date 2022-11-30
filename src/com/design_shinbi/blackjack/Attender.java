package com.design_shinbi.blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Attender {
	protected List<Card> cards;
	protected String name;

	public Attender(String name) {
		this.name = name;
		initialize();
	}

	public void initialize() {
		this.cards = new ArrayList<Card>();
	}

	public void start(Stock stock) {
		this.cards.clear();
		for (int i = 0; i < 2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}

	}

	public String getName() {
		return name;
	}

	public void hit(Stock stock) {
		Card card = stock.pickCard();
		this.cards.add(card);
	}

	public static int calculateStrengthFromList(List<Card> list) {
		int strength = 0;
		int ac = 0;

		for (Card value : list) {
			if (value.getNumber()>10) {
				strength += 10;
			} else if (value.getNumber() == 1) {
				ac = 1;
				strength += 1;
			} else {
				strength += value.getNumber();
			}
			if (strength > 21) {
				return 0;
			}

		}

		if (ac == 1) {
				if (strength + 10 <= 21) {
					strength += 10;
				} 
		}

		return strength;
	}

	public int calculateStrength() {
		int strength = calculateStrengthFromList(this.cards);
		return strength;
	}

	public String toString() {

		String string = name + ": ";
		for (int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			string = string + card.toString();
		}
		return string;
	}

	public void display() {
		System.out.println(this.toString());
	}

	public abstract void play(Stock stock) throws IOException;
}
