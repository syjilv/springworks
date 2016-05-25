package di.constructor04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/bean.xml");
		IWriteArticleMgr write = (IWriteArticleMgr) container.getBean("write");

		ArticleDTO article = new ArticleDTO("�̸�", "����", "����", "��¥");
		write.write(article);

	}
}
