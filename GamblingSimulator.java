package com.bl.gambling_simulator;

import java.util.Random;

import java.util.Scanner;

public class GamblingSimulator {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Gambling Simulator");
		GamblingSimulator sim = new GamblingSimulator();
		Gambler gambler = new Gambler();
		int stake = gambler.getInitialStake();
		int bet = gambler.getBet();
		sim.gamble(stake, bet);
	}

	public void gamble(int stake, int bet) {
		int win = 0;
		int lose = 0;
		System.out.println("Initial Stake " + stake);

		do {
			if (bet == 1) { // bet is being made
				boolean gambler = this.isWinOrLose();
				
				if (gambler == true) {
					stake = stake + bet;
					System.out.println("win  remaining stake " + stake);
					win++;
				} else {
					stake = stake - bet;
					System.out.println("lost remaining stake " + stake);
					lose++;
				}
			}
		} while (stake > 50 && stake < 150);// continue until player lost or won 50 % from initial stake
		
		System.out.println("matches won = " + win);
		System.out.println("matches lost = " + lose);
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
