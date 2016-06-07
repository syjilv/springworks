package member.dao;

import member.dto.MemberDTO;

public interface MemberDAO {
	//·Î±×ÀÎ
	MemberDTO login(String memId, String pwd);
}