import java.util.ArrayList;

public abstract class Player {
	private ArrayList<Card> hand;
	private String name;
	private boolean playing = true;
	private int numAces = 0;

	public abstract void whatDo (Deck deck);

	public Player(String name) {
		hand = new ArrayList<Card>();
		this.name = name;

	}

	public String toString() {
		String str = name + "\n";
		for(Card card : hand) {
			str += card + "\n";
		}

		return str;
	}

	protected void hit(Deck deck) {
		hand.add(deck.popCard());
		if(getValue() >= 21) {
			stand();
		}
	}

	protected void stand() {
		playing = false;
	}
	
	public boolean isPlaying() {
		return playing;
	}

	public int getValue() {
		int value = 0;
		numAces = 0;
		for (Card card : hand) {
			if (card.getValue() > 1) {
				value += card.getValue();
			} else {
				value += 11;
				numAces++;
			}

		}

		for (int i = 0; i < numAces; i++){
			if (value > 21) {
				value -= 10;
			}
		}

		return value;

	}
	
	public int getAces() {
		return numAces;
	}


}
