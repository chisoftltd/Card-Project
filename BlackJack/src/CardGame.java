import java.util.ArrayList;

public class CardGame {
	ArrayList<Player> players;
	Deck deck;
	
	public CardGame() {
		deck = new Deck();
		players = new ArrayList<Player>();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Blackjack");
		
		CardGame game = new CardGame();
		
	}

	public void setUp() {
		deck.shuffle();
		System.out.println(deck);
	}
	
	public void startGame() {
		boolean gameOver = false;
		while(!gameOver) { 
			foreach player (player 1 to dealer) {
				if(player.ispalying
					player decide action
					player.whatDo();
			}
		}
	}
}