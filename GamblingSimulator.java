package com.bl.gambling_simulator;

import java.util.Arrays;

import java.util.Random;

import java.util.Scanner;

public class GamblingSimulator {

	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Gambler gambler = new Gambler();
		GamblingSimulator sim = new GamblingSimulator();
		System.out.println("Gambling Simulator");
		int stake = gambler.getInitialStake();
		int bet = gambler.getBet();
		int[] numOfdays = new int[20];

		for (int i = 0; i < 20; i++) {
			int stakePerDay = sim.gamble(stake, bet);
			numOfdays[i] = stakePerDay;
		}
//		System.out.print(Arrays.toString(numOfdays) + " ");

		int totalAmount = sim.calcTotalAmount(numOfdays);
		
		if(totalAmount > 0) {
			System.out.println("Total Amount Won in " + numOfdays.length + " days is " + totalAmount + " dollars");
		} else {
			System.out.println("Total Amount Lost in " + numOfdays.length + " days is " + (-totalAmount) + " dollars");
		}
	}

	public int gamble(int stake, int bet) {
		int win = 0;
		int lose = 0;
		System.out.println("Initial Stake " + stake);

		do {
			if (bet == 1) { // bet is being made
				boolean gambler = this.isWinOrLose();

				if (gambler == true) {
					stake = stake + bet;
					win++;

				} else {
					stake = stake - bet;
					lose++;
				}
			}
		} while (stake > 50 && stake < 150);// continue until player lost or won 50 % from initial stake

		System.out.println("matches won per day = " + win);
		System.out.println("matches lost per day = " + lose);

		if (stake == 150) {
			return 50;// as 50% of initial stake earned is 50 dollar
		} else {
			return 0;// lets assume 50% of initial stake lost is 0 dollar instead of -50 dollars
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

	public int calcTotalAmount(int[] numOfDays) {
		int loss = 0;
		int won;
		int totalWon = 0;
		int totalLost = 0;

		for (int i = 0; i < 20; i++) {
			if (numOfDays[i] == 0) {
				loss++;
			}
		}

		won = numOfDays.length - loss;
		totalWon = won * 50; // won 50 dollars per day
		totalLost = loss * 50; // lost 50 dollars per day
		System.out.println("\nDays won or lost out of " + numOfDays.length + " days are");
		System.out.println("days won " + won + "\namount won " + totalWon + " dollars");
		System.out.println("days lost " + loss + "\namount lost " + totalLost + " dollars");
		
		int totalAmount = totalWon - totalLost;
		return totalAmount;
	}
}
