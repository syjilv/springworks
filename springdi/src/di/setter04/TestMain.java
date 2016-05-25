package di.setter04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/setter.xml");
		IWriteArticleMgr write = (IWriteArticleMgr) container.getBean("write");

		ArticleDTO article = null;
		article.setName("이름");
		article.setTitle("제목");
		article.setContent("내용");
		article.setDate("날짜");
		
		write.write(article);

	}
}
