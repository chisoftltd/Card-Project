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
public class Dealer extends Player {

	// TODO lägga till mer alternativ för olika house rules (rörande dealer)
    // Stand on 17 with ace as 11
    boolean hitOnSoft = false;

    public Dealer() {
        super("Dealer");
    }

    @Override
    public void whatDo(Deck deck, BlackJack bj) {
        int val = getValue();
        if (val >= 17) {
            if (hitOnSoft && val == 17 && getAces() > 0) {
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
