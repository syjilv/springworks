package member.service;

import member.dto.MemberDTO;

public interface MemberService {

	//�α���
	MemberDTO login(String memId, String pwd);
}