package cardgame;
import java.util.ArrayList;

public abstract class Player {
    private ArrayList<Card> hand;
    private String name;
    private boolean playing = true;
    private int numAces = 0;

    public abstract void whatDo(Deck deck, BlackJack bj);

    public Player(String name) {
        hand = new ArrayList<Card>();
        this.name = name;
    }
    
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Player ");
		sb.append(name);
		sb.append(" has the following cards: ");
		for(Card card : hand) {
			sb.append(card);
			sb.append(", ");
		}	
		
		sb.setLength(sb.length() - 2);
		sb.append("\nTotal value is ");
		sb.append(getValue());
		return sb.toString();
	}
    
    public String getName() {
    	return name;
    }

	protected void hit(Deck deck) {
		Card tmpCard = deck.popCard();
		hand.add(tmpCard);
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

	/**
	 * Räknar ut värdet på en spelares hand och tar hänsyn till 
	 * att ess kan både vara 11 och 1
	 * @return värdet på spelares hand
	 */
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
	
	protected int getAces() {
		return numAces;
	}

	public void reset() {
		hand.clear();
		playing = true;
	}

}
