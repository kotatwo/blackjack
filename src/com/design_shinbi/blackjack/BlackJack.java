package com.design_shinbi.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		start(reader);
		reader.close();
	}

	public static void start(BufferedReader reader) throws IOException {
		Scanner scr = new Scanner(System.in);
		int mymoney = 1000;
		int bet = 0;

		while (true) {
			System.out.println(
					String.format("いくら賭けます？ 現在の所持金%d円", mymoney));
			bet = scr.nextInt();
			if (bet > mymoney) {
				bet = mymoney;
			}

			Player player = new Player(reader);
			Dealer dealer = new Dealer();
			Stock stock = new Stock();

			player.start(stock);
			dealer.start(stock);
			dealer.display();
			player.play(stock);
			dealer.play(stock);
			mymoney += showResult(player, dealer, bet);
			if (mymoney <= 0) {
				System.out.println("まだやるｋ...おめえ金ねえやん！！けえれぇ！！");
				break;
			}
			System.out.println(
					String.format("まだやるかい？ [Y:やる　N：やめる] 現在の所持金%d円", mymoney));
			String conti = scr.next();
			if (!conti.equalsIgnoreCase("Y")) {
				if (mymoney > 10000) {
					System.out.println("あなたはテンション爆上がりで、傍から見たらドン引かれるような挙動をしながら帰りました。");
				} else if (mymoney > 1000) {
					System.out.println("あなたは気持ちよくなりながら帰りました。");
				} else if (mymoney == 1000) {
					System.out.println("あなたは真顔で帰りました。何しに来たのでしょうか。");
				} else {
					System.out.println("あなたは悲哀に満ちた顔をしながら帰りました。");
				}
				break;
			}
		}
		scr.close();
	}

	public static int showResult(Attender player, Attender dealer, int bet) {
		dealer.display();
		player.display();
		if (player.calculateStrength() == dealer.calculateStrength()) {
			System.out.println("引き分けやで");
			return 0;
		} else if (player.calculateStrength() > dealer.calculateStrength()) {
			if (player.calculateStrength() == 21) {
				System.out.println("BLACK　JACK!!!　大勝利！");
				return bet * 2;
			} else {
				System.out.println("あなたの勝ちです...。");
				return bet;
			}
		} else {
			System.out.println("あなたの負けですぜ。へへっ");
			return -bet;
		}
	}
}
