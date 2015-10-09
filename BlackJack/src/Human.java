import java.util.Scanner;
public class Human extends Player {


	Scanner scan; //lätt att laga\\
	public Human(String name) {
		super(name);
		scan = new Scanner(System.in);
	}	

	public void whatDo (Deck deck) /*And what not to do */{
		//TODO
		//OR NOT TODO
		while(true) {
			System.out.println("What do mr, hit or stand? Enter h for hit s for stand ok fakr");
			String line = scan.nextLine().toLowerCase(); //OMG
			if(line.equals("h")) {
				hit(deck);
				break;
			}
			else if(line.equals("s")) {
				stand();
				break;
			}
			else{
				System.out.println("fakr Wr0nK inpul");
			}
		}



	}

}
