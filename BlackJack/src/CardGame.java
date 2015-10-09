/*
 Att göra:
 - Räkna poäng för varje spel/omgång
 - Räkna poäng för varje spelare
 - Spelare (klass, objekt ur klassen)
        - Namn
 - Kunna dela ut kort
        - Dela ut slumpade kort
        - Blandad kort (ta ut första kortet, slumpat)
 - Kolla en spelares kort (-_-)
 - Kolla vilka som är ute vilka som är kvar
 - Regler
 - Rangordna korten  ( så man kan säga vilket kort som är bättre än ett annat)
 - Datorspelare
  - Logik
  - Svårighetsgrad
 - Veta vems tur det är att spela
 - Kontrollera om någon vunnit / förlorat / oavgjort
 - Kontrollera om kortleken är slut
 - Slack (2015-10-08)
 */

public class CardGame {
	public static void main(String[] args) {
		System.out.println("Welcome to Card Game FUCK OFF");
		
		/*
		while(win condition not met)
			foreach player (player 1 to dealer) {
				if(player.ispalying
					player decide action
			//System.exit(1337);
			}
		}
		*/
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println(deck);
		deck = null;
		
	}
}