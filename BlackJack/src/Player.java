import java.util.ArrayList;

//RULES - NO RULES


//TODO 
/* Alla actions (HIT && STAND metod)
 * En player har en hand (hand hand arraylist??!)
 * extendar massa grejer inegn fattar uhrur!
 * panga hs?
 * 
 */
//END TODO
public class Player {
	private ArrayList<Card> hand;
	private String name;
	public boolean playing = true;
	//en konstruktör
	//en konduktör
	//en konduktur
	//en kontur
	//en kon
	//en rundtur
	
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
	}
	
	protected void stand() {
		playing = false;
	}
	
}
