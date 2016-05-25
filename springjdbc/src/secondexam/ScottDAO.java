package secondexam;

import org.springframework.jdbc.core.JdbcTemplate;

public class ScottDAO {
	private JdbcTemplate template;

	public ScottDAO(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	public int count(int deptno) {
		return template.queryForObject("select count(*) from emp where deptno=" + deptno, Integer.class);
		
	}
}
