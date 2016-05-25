package di.setter03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/setter.xml");
		InterMessage message = (InterMessage) container.getBean("message");
		message.sayHello();
		}
}
