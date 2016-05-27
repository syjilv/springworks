package di.anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("config/bean.xml");
		IWriteArticleMgr mgr = (IWriteArticleMgr) container.getBean("mgr");

		ArticleDTO article = new ArticleDTO("이름", "제목", "내용", "날짜");
		mgr.write(article);

	}
}
