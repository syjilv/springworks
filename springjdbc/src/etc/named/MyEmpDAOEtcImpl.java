package etc.named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myemp.MyEmpDAO;
import myemp.MyEmpDTO;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class MyEmpDAOEtcImpl implements MyEmpDAO {
	private NamedParameterJdbcTemplate template;
	
	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	// 1차
//	// 사용자로부터 입력받을 값을 이름으로 매핑하겠다는 의미
//	// 파라미터를 map으로 관리
//	// 파라미터 name과 value를 map에 등록
//	// => index 기반보다 불편
//
//	@Override
//	public void insert(MyEmpDTO user) {
//		 String sql = "insert into myemp values(:id, :pass, :addr, '100000', :grade, '002', :name)";
//		 // sql에 파라미터를 셋팅
//		 Map<String, String> paramMap = new HashMap<String, String>();
//		 paramMap.put("id", user.getId());
//		 paramMap.put("pass", user.getPass());
//		 paramMap.put("addr", user.getAddr());
//		 paramMap.put("grade", user.getGrade());
//		 paramMap.put("name", user.getName());
//		 int result= template.update(sql, paramMap);
//		 System.out.println(result);
//
//	}

	// 2차
	// BeanPropertySqlParameterSource기반
	// DTO 클래스의 프로퍼티 명과 sql의 파라미터명이 

	@Override
	public void insert(MyEmpDTO user) {
		 String sql = "insert into myemp values(:id, :pass, :addr, '100000', :grade, '002', :name)";
		 // sql에 파라미터를 셋팅
		 int result= template.update(sql, new BeanPropertySqlParameterSource(user));
		 System.out.println(result);

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
