package di.constructor01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/bean.xml");
		MyBean bean = (MyBean) container.getBean("mybean2");
		bean.sayHello();
	}

}
