package mydept;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDeptSystem {
	public static void main(String[] args) {
		ApplicationContext factory = 
			 new ClassPathXmlApplicationContext("config/mydept.xml");
		AbstractUI ui = (AbstractUI)factory.getBean("service");
		while(true){
			ui.show();
		}

	}

}
