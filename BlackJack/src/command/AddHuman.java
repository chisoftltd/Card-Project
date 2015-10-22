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
import cardgame.Human;
public class AddHuman implements Command{
	private BlackJack bj;
	private int numHP = 0;
	
	public AddHuman(BlackJack bj) {
		this.bj = bj;
	}
	
	public void execute() {
		if ((bj.numQuestion("Enter your age: ")) >= 18) {
			bj.addPlayer(new Human(bj.strQuestion("Enter your name")));
			numHP++;
		}
		else {
			System.out.println("You are too young");
		}
	}
	
	@Override
	public String toString() {
		return " - Add Human Player (" + numHP + ")";	
	}
}
