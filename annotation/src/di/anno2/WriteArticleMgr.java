package di.anno2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("mgr")
public class WriteArticleMgr implements IWriteArticleMgr {
	@Autowired
	@Qualifier("oracle")
	private IArticleDAO articleDAO;

	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}
	
}
