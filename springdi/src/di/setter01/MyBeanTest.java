package di.setter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/setter.xml");
		MyBean bean = (MyBean) container.getBean("mybean3");
		
		bean.sayHello();
	}

}
