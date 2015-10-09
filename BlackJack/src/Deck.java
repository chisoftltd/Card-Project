import java.util.ArrayList;
import java.util.Collections;

//TODO  , saker som ska in i TODO:n !!!! <---- 
// reserverat för framtida snilleblixtar 

public class Deck {
	private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	ArrayList<Card> cardPack;

	public Deck() {
		cardPack = new ArrayList<Card>();
		makeDeck();
	}

	public void makeDeck() {
		cardPack.clear();
		for(int i=0; i<13; i++){
			for(int j=0; j<4; j++){
				cardPack.add(new Card(suits[j], i+1));

			}
		}
	}

	public Card popCard() {
		if(!cardPack.isEmpty()){
			return cardPack.remove(cardPack.size() - 1);}
		else {
			return null;
		}
	}

	public void shuffle() {
		Collections.shuffle(cardPack);
	}

	public String toString() {
		String str = "";
		for(Card card : cardPack) {
			str += card + "\n";
		}
		return str;
	}
}