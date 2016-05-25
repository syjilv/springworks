package di.constructor02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/bean.xml");
		AbstractPlayer p = (AbstractPlayer) container.getBean("p"); 
		p.play();
		System.out.println("세번 굴린 주사위의 합:"+p.getTotalValue());
	}
}
