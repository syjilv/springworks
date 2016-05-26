package mydept;

import java.util.List;

import myemp.MyEmpDTO;

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
	//�μ���ȣ�� �˻�
	MyDeptDTO findByDeptno(String deptno);
	//�μ������� ��� �˻�
	List<MyEmpDTO> findEmpByDeptname(String deptname);
}