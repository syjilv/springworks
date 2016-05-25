package di.setter.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("config/setter.xml");
		Insa insa = (Insa) factory.getBean("insa");
		
		MemberDTO user = new MemberDTO("jang","1234","¿Âµø∞«");
	
		insa.addUser(user);

	}

}
