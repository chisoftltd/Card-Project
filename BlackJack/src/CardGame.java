/*
 Att g�ra:
 - R�kna po�ng f�r varje spel/omg�ng
 - R�kna po�ng f�r varje spelare
 - Spelare (klass, objekt ur klassen)
        - Namn
 - Kunna dela ut kort
        - Dela ut slumpade kort
        - Blandad kort (ta ut f�rsta kortet, slumpat)
 - Kolla en spelares kort (-_-)
 - Kolla vilka som �r ute vilka som �r kvar
 - Regler
 - Rangordna korten  ( s� man kan s�ga vilket kort som �r b�ttre �n ett annat)
 - Datorspelare
  - Logik
  - Sv�righetsgrad
 - Veta vems tur det �r att spela
 - Kontrollera om n�gon vunnit / f�rlorat / oavgjort
 - Kontrollera om kortleken �r slut
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