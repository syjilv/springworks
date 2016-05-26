package etc.named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myemp.MyEmpDTO;

public class EtcTest {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/etc.xml");
	
		MyEmpDAOEtcImpl dao = (MyEmpDAOEtcImpl) container.getBean("namedao");
		
		dao.insert(new MyEmpDTO ("hwang", "1234", "성산", "4", "황황황"));

	}

}
