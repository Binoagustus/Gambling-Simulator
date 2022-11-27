package com.bl.gambling_simulator;

public class GamblingSimulator {

	public static void main(String[] args) {
		System.out.println("Gambling Simulator");
		Gambler gambler = new Gambler();
		short stake = gambler.getInitialStake();
		short bet = gambler.getBet();
		gambler.gamble(stake, bet);
	}
}
