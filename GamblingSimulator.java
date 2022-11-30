package com.bl.gambling_simulator;

import java.time.Month;

import java.time.YearMonth;

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

		int i = 1;
		do {
			int daysInMonth = sim.getnumOfDays(2022, i);
			int[] numOfDays = new int[daysInMonth];
			
			for (int j = 0; j < daysInMonth; j++) {
				int stakePerDay = sim.gamble(stake, bet);
				numOfDays[j] = stakePerDay;
				if (numOfDays[j] == 50) {
					int dayIndex = j + 1;
					System.out.println("Day " + dayIndex + " is maximum won luckiest day");

				} else if (numOfDays[j] == 0) {
					int dayIndex = j + 1;
					System.out.println("Day " + dayIndex + " is maximum lost unluckiest day");
				}
			}

			int totalAmount = sim.calcTotalAmount(numOfDays);

			if (totalAmount >= 0) {
				System.out.println("Total Amount Won is " + totalAmount + " dollars");
				i++;
			} else {
				System.out.println("Total Amount Lost is " + (-totalAmount) + " dollars");
				i = 13;
			}

			System.out.println("*******************************");
		}while(i <= 12);
	}

	public int getnumOfDays(int year, int month) {
		YearMonth obj = YearMonth.of(year, month);
		Month monthName = obj.getMonth();
		int days = obj.lengthOfMonth();
		System.out.print(monthName + " of " + days + " days ");
		System.out.println("");
		return days;
	}

	public int gamble(int stake, int bet) {
		int win = 0;
		int lose = 0;

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

		for (int i = 0; i < numOfDays.length; i++) {
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
