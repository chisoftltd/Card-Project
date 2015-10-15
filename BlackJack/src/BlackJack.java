import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
	ArrayList<Player> players;
	Deck deck;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();

	public BlackJack() {
		deck = new Deck();
		players = new ArrayList<Player>();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Blackjack");

		BlackJack game = new BlackJack();
		game.setup();
		Scanner scan = new Scanner(System.in); 

		String line = "y";
		while(line.equals("y")) {
			game.playRound();
			do {
				System.out.println("Would you like to play again? Y/N");
				line = scan.nextLine();
				line.toLowerCase();
			} while (!line.equals("y") || !line.equals("n"));
		}

		scan.close();
	}

	public void setup() {
		final int numHPlayers = numQuestion("How many HUMAN players would you like?");
		final int numCPlayers = numQuestion("How many COMPUTER players would you like?");

		if ((numHPlayers+numCPlayers) == 0) {
			throw new IllegalArgumentException("No players");
		}
		for (int i = 0; i<numHPlayers; i++){
			players.add(new Human(strQuestion("Player: " + (i+1) + ". Enter your name")));
		}
		for (int i = 0; i<numCPlayers; i++){
			players.add(new Computer(randomName()));
		}
		players.add(new Dealer());
		// Reserved newlines for future code
		// maybe money/bet code
	}

	private int numQuestion (String input) {
		int num = 0;
		while(true) {
			System.out.println(input);
			if(scan.hasNextInt()) {
				num = scan.nextInt();
				scan.next();
				return num;
			} else {
				System.out.println("Invalid Selection.");
				// Rensar buffern f�r system.in
				scan.next();
			}
		}
	}

	private String strQuestion (String input) {
		System.out.println(input);
		return scan.nextLine();
	}

	public void playRound() {
		deck.makeDeck(players.size());
		deck.shuffle();

		// Each player gets 2 cards
		for (Player player : players) {
			player.hit(deck);
			player.hit(deck);
		}

		for (Player player : players) {
			while(player.isPlaying()) {
				player.whatDo(deck);
			}
		}

		Player dealer = players.get(players.size() - 1);
		// If Dealer Busts all players not busted wins
		if (dealer.getValue() > 21) {
			for (int i = 0; i<players.size()-1; i++) {
				if (players.get(i).getValue() <= 21) {
					// player win
				} else {
					// player lose
				}
			}
		} else {
			for (int i = 0; i<players.size()-1; i++) {
				if (players.get(i).getValue() <= 21 && players.get(i).getValue() > dealer.getValue()) {
					// player win
				} else {
					// player lose
				}
			}
		}
	}

	private String randomName() {
		final int maxLength = 9;
		final int minLength = 3;
		final int strLength = rand.nextInt((maxLength - minLength) + 1) + minLength;
		final char consonant[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
				'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
		final char vowel[] = {'a', 'e', 'i', 'o', 'u', 'y'};
		String name = "";
		int counter = rand.nextInt(1);
		for (int i = 1; i<strLength+1; i++) {
			if (counter == 0){
				name += vowel[rand.nextInt(strLength-1)];
				counter = 1;
			} else {
				name += consonant[rand.nextInt(strLength-1)];
				counter = 0;
			}
		}

		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}

}