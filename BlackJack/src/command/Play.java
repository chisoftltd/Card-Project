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

public class Play implements Command {
	private BlackJack bj;
	public Play(BlackJack bj) {
		this.bj = bj;
	}
	
	public void execute() {
		bj.playRound(); 
		
	}
	
	@Override
	public String toString() {
		return " - Start game";	
	}
	
}
