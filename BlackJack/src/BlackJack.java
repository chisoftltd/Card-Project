import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
	ArrayList<Player> players;
	Deck deck;
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
		
		// Gameloop
		String line = "y";
		while(line.equals("y")) {
			game.playRound();
			do {
				System.out.println("Would you like to play again? Y/N");
				line = scan.nextLine();
				line = line.toLowerCase();
			} while (!line.equals("y") && !line.equals("n"));
		}

		scan.close();
	}

	// Setup 
	public void setup() {
		Scanner reply = new Scanner(System.in);
		// final int numHPlayers = numQuestion("How many HUMAN players would you like?");
		// final int numCPlayers = numQuestion("How many COMPUTER players would you like?");
                
        int numHPlayers = numQuestion("How many HUMAN players would you like?");
		int numCPlayers = numQuestion("How many COMPUTER players would you like?");


		if ((numHPlayers+numCPlayers) == 0) {
			//throw new IllegalArgumentException("No players"); // Give user(s)/player(s) option to try again
			System.out.println("You need player(s) to play this game! Want to try again?(Y/N) ");
			String answer = reply.nextLine().toUpperCase();
			if(answer.equals("Y")){
				numHPlayers = numQuestion("How many HUMAN players would you like?");
				numCPlayers = numQuestion("How many COMPUTER players would you like?");
			} else{
				System.out.println("Bye!");
				System.exit(0);
			}
		}
	
		for (int i = 0; i<numHPlayers; i++){
			//players.add(new Human(strQuestion("Player " + (i+1) + ": Enter your name")));
			players.add(new Human(strQuestion("Player " + (i + 1) + ": Enter your name"), addAge()));
		}
		for (int i = 0; i<numCPlayers; i++){
			players.add(new Computer(randomName()));
		}
		players.add(new Dealer());

	}

	/**
	 * Tar in en String som "fråga" och ber användaren om en fråga som kan endast besvaras med en integer
	 * @param input
	 * @return  q  användarens svar
	 */
	private int numQuestion (String input) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(input);
			if(scanner.hasNextInt()) {
				num = scanner.nextInt();
				return num;
			} else {
				System.out.println("Invalid Selection.");
				// Rensar buffern för system.in
				scanner.next();
			}
		}
	}

	private String strQuestion (String input) {
		System.out.println(input);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

    private int addAge() {
        System.out.println("Enter your age: ");
        Scanner acceptAge = new Scanner(System.in);
        return acceptAge.nextInt();
    }
	
	public void playRound() {
		
		deck.makeDeck(players.size());
		deck.shuffle();

		// Each player gets 2 cards
		// We need to keep count of cards dealt out to know when the deck is exhausted
		// Vi måste hålla räkningen på kort som delas ut för att veta när däcket är uttömd
		for (Player player : players) {
			player.reset();
			player.hit(deck);
			player.hit(deck);
		}

		// Frågar varje spelare vad dom vill göra tills dom "standar" eller förlorar
		// Dealern är den sista spelaren
		for (Player player : players) {
			while(player.isPlaying()) {
				player.whatDo(deck);
			}
		}

		
		Player dealer = players.get(players.size() - 1);
		// Om dealern bustar så vinner alla spelare som inte gått över 21
		if (dealer.getValue() > 21) {
			for (int i = 0; i<players.size()-1; i++) {
				if (players.get(i).getValue() <= 21) {
					// TODO player win
				} else {
					// TODO player lose
				}
			}
		} else {
			for (int i = 0; i<players.size()-1; i++) {
				if (players.get(i).getValue() <= 21 && players.get(i).getValue() > dealer.getValue()) {
					// TODO player win
				} else {
					// TODO player lose
				}
			}
		}
	}

    /**
     * Slumpar fram ett namn efter logik: Varannan konsonant, varannan vokal (börjar på en slumpmässig) 
     * och slumpmässig längd mellan minLength och maxLength
     * @return ett random "name"
     */
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