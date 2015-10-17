import java.util.ArrayList;

public abstract class Player {

    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int age;
    private boolean playing = true;
    private int numAces = 0;

    public abstract void whatDo(Deck deck);

    public Player(String name, int age) {
        // hand = new ArrayList<Card>();
        this.name = name;
        //this.age = age;
        if (age < 18) {
            System.out.println("You are too young. Bye!");
            System.exit(0);
        }
    }
	
    public Player(String name) {
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

	/**
	 * R�knar ut v�rdet p� en spelares hand och tar h�nsyn till 
	 * att ess kan b�de vara 11 och 1
	 * @return v�rdet p� spelares hand
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
