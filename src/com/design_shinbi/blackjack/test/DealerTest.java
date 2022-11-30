package com.design_shinbi.blackjack.test;

import org.junit.jupiter.api.Test;

import com.design_shinbi.blackjack.Dealer;
import com.design_shinbi.blackjack.Stock;

class DealerTest {

	@Test
	void testDealer() {
		Stock stock = new Stock();
		Dealer dealer = new Dealer();

		dealer.start(stock);
		System.out.println(dealer);

		dealer.play(stock);
		System.out.println(dealer);
	}
}
