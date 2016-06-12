package member.dao;

import member.dto.MemberDTO;
import member.dto.MemberRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberdao")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private JdbcTemplate template;

	// ·Î±×ÀÎ
	@Override
	public MemberDTO login(String memId, String pwd) {
		MemberDTO mem = null;
		try {
		mem = template.queryForObject("select * from TB_MEM where MEM_ID = ? and PWD = ?", new Object[]{memId, pwd}, new MemberRowMapper()); 
		} catch(EmptyResultDataAccessException e) {
			
		}
		return mem;
	}
}
