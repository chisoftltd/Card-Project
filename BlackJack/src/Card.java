public class Card {

	// Klassvariabler
	// Instansvariabler
	private String suit;    // Diamonds / Hearts / Clubs / Spades
	private int value;      // 1 - Ace, 2 - 10, 11 - Jack, 12 - Queen, 13 - King



	// Konstruktorer
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	// Konstruktor som körs när man kör PlayingCard card = new PlayingCard('Q', "Hearts");
	public Card(char value, String suit) {
		this(suit, value);
	}

	// Konstruktor som körs när man kör PlayingCard card = new PlayingCard("Hearts", 'Q');
	public Card(String suit, char value) {
		this.suit = suit;

		if(value == 'A') {
			this.value = 1;
		} else if (value == 'J') {
			this.value = 11;
		} else if (value == 'Q') {
			this.value = 12;
		} else if (value == 'K') {
			this.value = 13;
		}

	}

	// Statiska metoder (klassmetoder)


	// Objektets metoder (objektets metoder)
	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}


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