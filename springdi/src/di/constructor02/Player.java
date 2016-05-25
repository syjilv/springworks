package di.constructor02;

public class Player implements AbstractPlayer {
	AbstractDice d;
	int totalValue;
	
	public Player() {}
	public Player(AbstractDice d) {
		super();
		this.d = d;
	}
		
	public void play() {
		totalValue=0;
		for (int i = 0; i < 3; i++) {
			totalValue += d.getDiceValue();
		}
	}
	public int getTotalValue(){
		return totalValue;
	}
}
