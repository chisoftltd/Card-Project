/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Benjamin
 */
import cardgame.BlackJack;

public class Rules implements Command {
	private BlackJack bj;
	private boolean betting = true;
	private boolean doublesplit = false;
	private boolean overunder = false;
	// TODO INTE KLART

	public Rules(BlackJack bj) {
		this.bj = bj;
	}

	public void execute() {
		while (true) {
			System.out.println("(1) - Allow Betting: " + String.valueOf(betting));
			System.out.println("(2) - Enable Double/Split: " + String.valueOf(doublesplit));
			System.out.println("(3) - Dealer hit on soft: " + String.valueOf(bj.getDealer().getHitOnSoft()));
			System.out.println("(4) - Enable Over/Under: " + String.valueOf(overunder));
			System.out.println("(5) - Exit");
			
			int input = 0;
			while((input = bj.numQuestion("")) > 5 || input < 1) {}

			switch (input) {
			case 1: 
				betting = !betting;
				break;
			case 2: 
				doublesplit = !doublesplit;
				break; 
			case 3:
				bj.getDealer().invertHitOnSoft();
				break;
			case 4: 
				overunder = !overunder;
				break;
			case 5: 
				return;
			}
		}
	}

	@Override
	public String toString() {
		return " - Change rules";	
	}

	public boolean getBetting() {
		return betting;
	}
	public boolean getDoubleSplit() {
		return doublesplit;
	}
	public boolean getOverUnder() {
		return overunder;
	}
}
