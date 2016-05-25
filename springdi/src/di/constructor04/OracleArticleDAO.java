package di.constructor04;

public class OracleArticleDAO implements IArticleDAO {
	public void insert(ArticleDTO article) {
		System.out.println("Oracle Article");
		System.out.println(article.toString());
	}
}