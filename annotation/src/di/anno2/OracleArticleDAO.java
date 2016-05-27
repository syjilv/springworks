package di.anno2;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleArticleDAO implements IArticleDAO {
	public void insert(ArticleDTO article) {
		System.out.println("Oracle Article");
		System.out.println(article.toString());
	}
}