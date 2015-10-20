/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Random;

import cardgame.BlackJack;
import cardgame.Computer;

public class AddComputer implements Command {
	private BlackJack bj;
	private Random rand = new Random();
	int numCP = 0;
	
	
	public AddComputer(BlackJack bj) {
		this.bj = bj;
	}
	
	public void execute() {
		bj.addPlayer(new Computer(randomName()));
		numCP++;
	}
	
	@Override
	public String toString() {
		return " - Add Computer Player (" + numCP + ")";	
	}
	
	/**
	 * Slumpar fram ett namn efter logik: Varannan konsonant, varannan vokal (börjar på en slumpmässig) 
	 * och slumpmässig längd mellan minLength och maxLength
	 * @return ett random "name"
	 */
	private String randomName() {
		final int maxLength = 9;
		final int minLength = 3;
		final int strLength = rand.nextInt((maxLength - minLength) + 1) + minLength;
		final char consonant[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
				'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
		final char vowel[] = {'a', 'e', 'i', 'o', 'u', 'y'};
		String name = "";
		int counter = rand.nextInt(1);
		for (int i = 1; i<strLength+1; i++) {
			if (counter == 0){
				name += vowel[rand.nextInt(strLength-1)];
				counter = 1;
			} else {
				name += consonant[rand.nextInt(strLength-1)];
				counter = 0;
			}
		}

		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}
}
