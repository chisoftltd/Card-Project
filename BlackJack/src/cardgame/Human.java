package cardgame;
import java.util.Scanner;
public class Human extends Player {
	Scanner scan;
	public Human(String name) {
		super(name);
		scan = new Scanner(System.in);
	}

	/**
	 * Fr�gar spelaren efter vad hen vill g�ra och �beropar metoden hit / stand 
	 * beroende p� svar
	 * @param deck Deck med kort
	 * @param bl F�r rules
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