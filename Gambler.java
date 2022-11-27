package com.bl.gambling_simulator;

public class Gambler {
	private short initialStake = 100;
	private short bet = 1;

	public short getInitialStake() {
		return initialStake;
	}

	public short getBet() {
		return bet;
	}
	
	public void gamble(short stake, short bet) {
		System.out.println("Initial Stake " + stake + " Bet " + bet);
		if(bet == 1) {
			System.out.println("Bet one dollar from Initial Stake");
		}
	}

}
