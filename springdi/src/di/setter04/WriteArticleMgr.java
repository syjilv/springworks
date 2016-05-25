package di.setter04;

public class WriteArticleMgr {
	private IArticleDAO articleDAO;

	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}

	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

}
