package myemp;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MyEmpDAOImpl implements MyEmpDAO {
	private JdbcTemplate template;
	
	public MyEmpDAOImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public int count() {
		return template.queryForObject("select count(*) from myemp", Integer.class);
	}

	@Override
	public void insert(MyEmpDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MyEmpDTO userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MyEmpDTO login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyEmpDTO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyEmpDTO> findByAddr(String addr) {
		// TODO Auto-generated method stub
		return null;
	}

}
