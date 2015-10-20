package command;
import cardgame.BlackJack;

public class Play implements Command {
	private BlackJack bj;
	public Play(BlackJack bj) {
		this.bj = bj;
	}
	
	public void execute() {
		bj.playRound(); 
		
	}
	
	@Override
	public String toString() {
		return " - Start game";	
	}
	
}
