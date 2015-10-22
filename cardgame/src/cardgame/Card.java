/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author Benjamin
 */
public class Card {
	private String suit;    
	private int value;    

	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value > 10 ? 10 : value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(suit);
		sb.append(" ");
		
		switch(value) {
		case 1: 
			sb.append("Ace");
			break;
		case 11: 
			sb.append("Jack");
			break;
		case 12: 
			sb.append("Queen");
			break;
		case 13: 
			sb.append("King");
			break;
		default: 
			sb.append(value);
			break;
		}
		return sb.toString();
	}
}