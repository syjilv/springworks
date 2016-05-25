package di.constructor02;

import java.util.Random;

public class Dice extends Random implements AbstractDice {
	public int getDiceValue(){
		return nextInt(6)+1;
	}
}
