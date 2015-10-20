package cardgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import command.AddComputer;
import command.AddHuman;

import command.Command;
import command.Play;
import command.Rules;

public class BlackJack {
	private ArrayList<Player> players;
	private Deck deck;
	private Dealer dealer;
	
	public BlackJack() {
		deck = new Deck();
		players = new ArrayList<Player>();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Blackjack");
		
		BlackJack game = new BlackJack();
		game.startUp();
	}

	// Setup 
	// TODO kommentarer
	public void startUp() {    
		// setup rules
		ArrayList<Command> commands = new ArrayList<Command>();
		commands.add(new Play(this));
		commands.add(new Rules(this));
		commands.add(new AddHuman(this));
		commands.add(new AddComputer(this));
		
		dealer = new Dealer();
		players.add(dealer);

		while(true) {
			int i = 0;
			for(i = 0; i < commands.size(); i++){
				System.out.println((i+1) + commands.get(i).toString());
			}
			System.out.println((i+1) + " - Exit");
			
			int reply = numQuestion("") - 1;
			if(reply < commands.size()) {
				commands.get(reply).execute();
			} else if (reply == i) {
				break;
			}
		}
	}
	
	public void playRound() {
		if(players.size() == 1) {
			System.out.println("You need 1 or more players to start the game \n");
			return;
		}
		
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
			
		// TODO betloop
		
		// Frågar varje spelare vad dom vill göra tills dom "standar" eller förlorar
		// Dealern är den sista spelaren
		// TODO dealer sluta spela om alla busts
		for (Player player : players) {
			while(player.isPlaying()) {
				System.out.println(player);
				player.whatDo(deck, this);
			}
			
			if(player.getValue() > 21) {
				System.out.println(player);
				System.out.println("Bust");
			} else if(player.getValue() == 21) {
				System.out.println(player);
				System.out.println("Blackjack");
			} else {
				System.out.println("Stand");
			}
		}

		// TODO kommentarer
		for(int i = 0; i < players.size() - 1; i++) {
			if((dealer.getValue() > 21 && players.get(i).getValue() <= 21) 
					|| (players.get(i).getValue() <= 21 && players.get(i).getValue() > dealer.getValue())) {
				// TODO win
				System.out.println("Player " + players.get(i).getName() + " wins");
			} else {
				// TODO lose
				System.out.println("Player " + players.get(i).getName() + " loses");
			}
		}
	}
	
	public void addPlayer(Player player) {
		// exception om ingen dealer skapad
		players.add(players.size() - 1, player);
	}
	
	/**
	 * Skriver ut reglerna
	 */
	public void printRules() {
		
		//TODO 
		System.out.println("¤ The goal is to reach 21.");
		System.out.println("¤ Every card 2-10 is valued as is.");
		System.out.println("¤ Kings, Queens, Jacks are valued 10.");
		System.out.println("¤ Aces are valued 1 or 11.");
		System.out.println("¤ The dealer plays last.");
		//Print houseruels
		/*
		 (" > Varje spelare ska inte ha mer än 5 kort") 
		 (" > På en del bord så finns det över- och  under spel, då det finns två ringar under varje ruta 
		 \ndå det står "O" (over) eller "U" (under)");
		 (" > Får man två ess och har satsat underrutan så vinner man en och en halv insatsen");
		 (" > I över- och under spel räknas ess som en poäng");
		 */
	}
	
	/**
	 * Tar in en String som "fråga" och ber användaren om en fråga som kan endast besvaras med en integer
	 * @param input
	 * @return  q  användarens svar
	 */
	public int numQuestion (String input) {
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

	public String strQuestion (String input) {
		System.out.println(input);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public Dealer getDealer() {
		return dealer;
	}
}