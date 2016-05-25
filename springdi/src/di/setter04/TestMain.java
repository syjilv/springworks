package di.setter04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/setter.xml");
		IWriteArticleMgr write = (IWriteArticleMgr) container.getBean("write");

		ArticleDTO article = null;
		article.setName("�̸�");
		article.setTitle("����");
		article.setContent("����");
		article.setDate("��¥");
		
		write.write(article);

	}
}
