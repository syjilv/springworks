package etc.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myemp.MyEmpDTO;

public class EtcTest {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/etc.xml");
	
		MyEmpDAOEtcImpl dao = (MyEmpDAOEtcImpl) container.getBean("simpledao");
		
		dao.insert(new MyEmpDTO ("mang", "1234", "È­»ê", "4", "¸Á¸Á¸Á"));

	}

}
