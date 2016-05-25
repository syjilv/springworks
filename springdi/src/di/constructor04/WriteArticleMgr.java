package di.constructor04;

public class WriteArticleMgr implements IWriteArticleMgr {
	private IArticleDAO articleDAO;

	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}
	
	public WriteArticleMgr(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
	}
	
}
