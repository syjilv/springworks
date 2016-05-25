package di.constructor04;

public class ArticleDTO {
	private String name;
	private String title;
	private String content;
	private String date;
	
	public ArticleDTO() {}
	public ArticleDTO(String name, String title, String content, String date) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	@Override
	public String toString() {
		return "ArticleDTO [name=" + name + ", title=" + title + ", content="
				+ content + ", date=" + date + "]";
	}
}
