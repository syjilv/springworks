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
		String sql = "insert into myemp values(?, ?, ?, 1000, ?, '001', ?)";
		int result = template.update(sql, user.getId(), user.getPass(), user.getAddr(), user.getGrade(), user.getName());
		System.out.println(result + " Record(s) 삽입 성공");
	}

	@Override
	public void update(MyEmpDTO userInfo) {
		String sql = "update myemp set id = ?, pass = ?, addr = ?, grade = ? where id = ?";
		int result = template.update(sql, userInfo.getId(), userInfo.getPass(), userInfo.getAddr(), userInfo.getGrade(), userInfo.getId());
		System.out.println(result + " Record 수정 성공");
	}

	@Override
	public void delete(String id) {
		String sql = "delete from myemp where id = ?";
		int result = template.update(sql, id);
		System.out.println(result + ". " + id + " 삭제 성공");
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
