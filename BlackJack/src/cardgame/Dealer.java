package cardgame;
public class Dealer extends Player {

	// TODO l�gga till mer alternativ f�r olika house rules (r�rande dealer)
	// Stand on 17 with ace as 11
	boolean hitOnSoft = false;

	public Dealer() {
		super("Dealer");
	}

	@Override
	public void whatDo(Deck deck, BlackJack bj) {
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
	
	public boolean getHitOnSoft() {
		return hitOnSoft;
	}
	
	public void invertHitOnSoft() {
		hitOnSoft = !hitOnSoft;
	}
	
	
}