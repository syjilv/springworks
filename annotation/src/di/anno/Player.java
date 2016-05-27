package di.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("player")
public class Player implements AbstractPlayer {
	@Autowired
	@Qualifier("mydice2")
	AbstractDice d;
	int totalValue;
	
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
