package myemp;

public interface AbstractUI {
	//���α׷��� ������ ��Ÿ���� �޼ҵ�
	void show();
	//count�� ���õ� �޼ҵ�(dao�� count�� ȣ���ϴ� �޼ҵ�)
	void countMenu();
	//insert�� ���õ� �޼ҵ�(dao�� insert�� ȣ���ϴ� �޼ҵ�)
	void insertMenu();
	//update�� ���õ� �޼ҵ�(dao�� update�� ȣ���ϴ� �޼ҵ�)
	void updateMenu();
	//delete�� ���õ� �޼ҵ�(dao�� delete�� ȣ���ϴ� �޼ҵ�)
	void deleteMenu();
	//��ü��Ϻ���� ���õ� �޼ҵ�(dao�� ��ü��Ϻ��� �޼ҵ带 ȣ���ϴ� �޼ҵ�)
	void showAllMenu();
	//login�� ���õ� �޼ҵ�(dao�� login�� ȣ���ϴ� �޼ҵ�)
	void loginMenu();
	//�˻��� ���õ� �޼ҵ�(dao�� �˻���� �޼ҵ带 ȣ���ϴ� �޼ҵ�)
	void findByAddrMenu();
	
	
}
