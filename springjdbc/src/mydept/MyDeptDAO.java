package mydept;

import java.util.List;

public interface MyDeptDAO {
	//부서 수 조회
	int count();
	//부서 신설
	void insert(MyDeptDTO dept);
	//부서정보수정
	void update(MyDeptDTO deptInfo);
	//부서삭제
	void delete(String deptno);
	//부서목록보기
	List<MyDeptDTO> getDeptList();
	//부서명으로 검색
	List<MyDeptDTO> findByDeptname(String deptname);
}