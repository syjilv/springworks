package mydept;

import java.util.List;

import myemp.MyEmpDTO;
import myemp.MyEmpRowMapper;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyDeptDAOImpl implements MyDeptDAO {
	private JdbcTemplate template;
	
	public MyDeptDAOImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public int count() {
		return template.queryForObject("select count(*) from mydept", Integer.class);
	}

	@Override
	public void insert(MyDeptDTO dept) {
		String sql = "insert into mydept values(?, ?, ?, ?)";
		int result = template.update(sql, dept.getDeptno(), dept.getDeptname(), dept.getLoc(), dept.getTelnum());
		System.out.println(result + " Record(s) 삽입 성공");
	}

	@Override
	public void update(MyDeptDTO deptInfo) {
		String sql = "update mydept set deptname = ?, loc = ?, telnum = ? where deptno = ?";
		int result = template.update(sql, deptInfo.getDeptname(), deptInfo.getLoc(), deptInfo.getTelnum(), deptInfo.getDeptno());
		System.out.println(result + " Record 수정 성공");
	}

	@Override
	public void delete(String deptno) {
		String sql = "delete from mydept where deptno = ?";
		int result = template.update(sql, deptno);
		System.out.println(result + ". " + deptno + " 삭제 성공");
	}

	@Override
	public List<MyDeptDTO> getDeptList() {
		String sql = "select * from mydept";
		return template.query(sql, new MyDeptRowMapper());
	}

	@Override
	public MyDeptDTO findByDeptno(String deptno) {
		String sql = "select * from mydept where deptno = ?";
		Object[] ps = {deptno}; 
		MyDeptDTO dept = null;
		try {
			dept = template.queryForObject(sql, ps, new MyDeptRowMapper());
		} catch(EmptyResultDataAccessException e) {
			
		}
		return dept;
	}

	@Override
	public List<MyEmpDTO> findEmpByDeptname(String deptname) {
		String sql = "select e.* from myemp e, mydept d where e.deptno = d.deptno and d.deptname like ?";
		Object[] ps = {"%" + deptname + "%"};
		
		return template.query(sql, ps, new MyEmpRowMapper());
	}

}
