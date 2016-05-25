package di.constructor04;

public class MysqlArticleDAO implements IArticleDAO {
	public void insert(ArticleDTO article) {
		System.out.println("Mysql Article");
	}
}