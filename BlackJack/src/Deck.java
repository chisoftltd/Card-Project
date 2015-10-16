import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private Random rand;
	private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	private ArrayList<Card> cardPack;

	public Deck() {
		cardPack = new ArrayList<Card>();
		rand = new Random();
		makeDeck(0);
	}

	/*
	 * G�r decket (clearar det f�rst)
	 */
	public void makeDeck(int num) {
		cardPack.clear();

		//Make 1 deck for every four players
		num = num / 5 + 1; 
		for(int k=0; k<num; k++) {
			for(int i=0; i<13; i++){
				for(int j=0; j<4; j++){
					cardPack.add(new Card(suits[j], i+1));

				}
			}
		}
	}

	/**
	 * @return Sista elementet i kortleken // Motsvarar det �versta kortet
	 */
	public Card popCard() {
		if(!cardPack.isEmpty()){
			return cardPack.remove(cardPack.size() - 1);}
		else {
			return null;
		}
	}

	/*
	 * Shufflar kortleken 
	 * G�r igenom varje element och byter ut med slumpvalt element
	 */
	public void shuffle() {
		Card tempCard;
		int j;
		for(int i = cardPack.size() - 1; i > 0; i--) {
			j = rand.nextInt(i+1);
			tempCard = cardPack.get(i);
			cardPack.set(i, cardPack.get(j));
			cardPack.set(j, tempCard);
		}
	}

	@Override
	public String toString() {
		String str = "";
		for(Card card : cardPack) {
			str += card + "\n";
		}
		return str;
	}
}