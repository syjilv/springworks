package myemp;

import java.util.List;

public interface MyEmpDAO {
	//ȸ���ο��� ��ȸ
	int count();
	//ȸ������
	void insert(MyEmpDTO user);
	//ȸ����������
	void update(MyEmpDTO userInfo);
	//ȸ��Ż��
	void delete(String id);
	//�α���
	MyEmpDTO login(String id,String pass);
	//ȸ����Ϻ���
	List<MyEmpDTO> getMemberList();
	//�ּҷ� �˻�
	List<MyEmpDTO> findByAddr(String addr);
}