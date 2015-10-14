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
		return value;
	}

	@Override
	public String toString() {

		String output = suit + " ";
		switch(value) {
		case 1: output += "Ace";
		break;
		case 11: output += "Jack";
		break;
		case 12: output += "Queen";
		break;
		case 13: output += "King";
		break;
		default: output += value;
		break;
		}
		return output;
	}
}