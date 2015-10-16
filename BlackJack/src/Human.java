import java.util.Scanner;
public class Human extends Player {
	Scanner scan;
	public Human(String name) {
		super(name);
		scan = new Scanner(System.in);
	}	

	/*
	 * Fr�gar spelaren efter vad hen vill g�ra och �beropar metoden hit / stand 
	 * beroende p� svar
	 */
	public void whatDo (Deck deck) {

		while(true) {
			System.out.println("Choose what to do. 'Hit or Stand? (H/S)");
			String line = scan.nextLine().toLowerCase();
			if(line.equals("h")) {
				hit(deck);
				break;
			}
			else if(line.equals("s")) {
				stand();
				break;
			}
			else{
				System.out.println("Not a correct input");
			}
		}
	}
}
