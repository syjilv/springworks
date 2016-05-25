package mydept;

import java.util.List;

public interface MyDeptDAO {
	//�μ� �� ��ȸ
	int count();
	//�μ� �ż�
	void insert(MyDeptDTO dept);
	//�μ���������
	void update(MyDeptDTO deptInfo);
	//�μ�����
	void delete(String deptno);
	//�μ���Ϻ���
	List<MyDeptDTO> getDeptList();
	//�μ������� �˻�
	List<MyDeptDTO> findByDeptname(String deptname);
}