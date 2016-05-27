package di.anno2;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MysqlArticleDAO implements IArticleDAO {
	public void insert(ArticleDTO article) {
		System.out.println("Mysql Article");
	}
}