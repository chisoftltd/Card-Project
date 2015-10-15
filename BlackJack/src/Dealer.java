public class Dealer extends Player {
	
	// Stand on 17 with ace as 11
	boolean hitOnSoft = false;

	public Dealer() {
		super("Dealer");
	}
	
	@Override
	public void whatDo(Deck deck) {
		int val = getValue();
		if(val >= 17) {
			if(hitOnSoft && val == 17 && getAces() > 0) {
				hit(deck);
			}
			
			stand();
		} else {
			hit(deck);
		}
	}      
}
