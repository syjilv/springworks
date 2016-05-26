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
	
//	// 1��
//	// ����ڷκ��� �Է¹��� ���� �̸����� �����ϰڴٴ� �ǹ�
//	// �Ķ���͸� map���� ����
//	// �Ķ���� name�� value�� map�� ���
//	// => index ��ݺ��� ����
//
//	@Override
//	public void insert(MyEmpDTO user) {
//		 String sql = "insert into myemp values(:id, :pass, :addr, '100000', :grade, '002', :name)";
//		 // sql�� �Ķ���͸� ����
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

	// 2��
	// BeanPropertySqlParameterSource���
	// DTO Ŭ������ ������Ƽ ��� sql�� �Ķ���͸��� 

	@Override
	public void insert(MyEmpDTO user) {
		 String sql = "insert into myemp values(:id, :pass, :addr, '100000', :grade, '002', :name)";
		 // sql�� �Ķ���͸� ����
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
