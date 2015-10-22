/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author Benjamin
 */
import java.util.Scanner;
public class Human extends Player {
	Scanner scan;
	public Human(String name) {
		super(name);
		scan = new Scanner(System.in);
	}

	/**
	 * Frågar spelaren efter vad hen vill göra och åberopar metoden hit / stand 
	 * beroende på svar
	 * @param deck Deck med kort
	 * @param bl För rules
	 */
	public void whatDo (Deck deck, BlackJack bj) {
		while(true) {
			System.out.println("Choose what to do. 'Hit or Stand? (H/S)" + "\n Type 'rules' for rules");
			String line = scan.nextLine().toLowerCase();
			if(line.equals("h")) {
				hit(deck);
				break;
			}
			else if(line.equals("s")) {
				stand();
				break;
			} else if (line.equals("rules")) {
				// TODO bl.printRules();
			} else if (line.equals("sdoublepalsikt sokd")) {
				// TODO IF DOUBLE/SPLIT == TRUE => OPTION FOR DOUBLE/SPLIT
			} else{
				System.out.println("Not a correct input");
			}
		}
	}
}