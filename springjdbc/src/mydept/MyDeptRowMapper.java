package mydept;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MyDeptRowMapper implements RowMapper<MyDeptDTO> {
	
	@Override
	public MyDeptDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("rowNum : " + rowNum);
		MyDeptDTO dept = new MyDeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		System.out.println(dept);
		return dept;
	}

}
