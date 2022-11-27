package com.bl.gambling_simulator;

import java.util.Random;
import java.util.Scanner;

public class Gambler {
	Scanner sc = new Scanner(System.in);
	private short initialStake = 100;
	private short bet = 1;

	public short getInitialStake() {
		return initialStake;
	}

	public short getBet() {
		return bet;
	}

	public void gamble(short stake, short bet) {
		System.out.println("Initial Stake " + stake);
		System.out.println("Enter b to bet 1 dollar from Stake");
		char pressKey = sc.next().charAt(0); 
		if (bet == 1 && pressKey == 'b') {
			boolean result = this.isWinOrLose();
			if (result == true) {
				System.out.println("win");
			} else {
				System.out.println("lose");
			}
		}
	}

	public boolean isWinOrLose() {
		Random random = new Random();
		int result = random.nextInt(2);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
}
