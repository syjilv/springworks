package member.dao;

import member.dto.MemberDTO;

public interface MemberDAO {
	//�α���
	MemberDTO login(String memId, String pwd);
}