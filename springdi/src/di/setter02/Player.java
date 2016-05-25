package di.setter02;

public class Player implements AbstractPlayer {
	AbstractDice d;
	int totalValue;
	
	public AbstractDice getD() {
		return d;
	}
	public void setD(AbstractDice d) {
		this.d = d;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
		
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
