package di.setter04;

public class OracleArticleDAO implements IArticleDAO {
	public void insert(ArticleDTO article) {
		System.out.println("Oracle Article");
		System.out.println(article.getName());
		System.out.println(article.getTitle());
		System.out.println(article.getContent());
		System.out.println(article.getDate());
	}
}