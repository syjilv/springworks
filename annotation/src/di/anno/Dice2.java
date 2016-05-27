package di.anno;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service("mydice2")
public class Dice2 extends Random implements AbstractDice {
	public int getDiceValue(){
		System.out.println("2222222222222222222222222222222");
		return nextInt(6)+1;
	}
}
