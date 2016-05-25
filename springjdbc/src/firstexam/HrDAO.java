package firstexam;

import org.springframework.jdbc.core.JdbcTemplate;

public class HrDAO {
	private JdbcTemplate template;

	public HrDAO(JdbcTemplate template) {
		super();
		this.template = template;
	}
	public int count() {
		
		return template.queryForObject("select count(*) from employees", Integer.class);
	}
}
