package jdbc;

import java.util.List;
import java.util.Scanner;

public class MenuUI implements AbstractUI {
	Scanner key = new Scanner(System.in);
	MyEmpDAO dao = new MyEmpDAO();
	//������ �˸��� �޼ҵ�
	public void show(){
		System.out.println("**********ȸ������ �ý���************");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("3. ȸ����������");
		System.out.println("4. ȸ��Ż��");
		System.out.println("5. ȸ����Ϻ���");
		System.out.println("6. �ּҷ� ȸ���˻��ϱ�");
		System.out.println("7. ����");
		System.out.print("���ϴ� �۾��� �����ϼ���:");
		int menu=key.nextInt();
		menuSelect(menu);
	}
	//show���� ������ ���� �Ѱܹ޾Ƽ� ������ �޼ҵ带 �����ϴ� ������ �ϴ� �޼ҵ�
	public void menuSelect(int menu){
		switch(menu){
			case 1:
				insertMenu();
				break;
			case 2:
				loginMenu();
				break;
			case 3:
				//updateMenu();
				break;
			case 4:
				//deleteMenu();
				break;
			case 5:
				showAllMenu();
				break;
			case 6:
				//findByAddrMenu();
				break;
			case 7:
				System.exit(0);
		}
	}
	/*@Override
	public void deleteMenu() {
		// TODO Auto-generated method stub

	}*/

	/*@Override
	public void findByAddrMenu() {
		System.out.println("********�˻�********");
		System.out.print("�˻��� �ּҸ� �Է��ϼ���:");
		String addr = key.next();
		List<MemberDTO> userlist = dao.findByAddr(addr);
		for (int i = 0; i < userlist.size(); i++) {
			MemberDTO user = userlist.get(i);
			System.out.print(user.getId()+"\t");
			System.out.print(user.getPass()+"\t");
			System.out.print(user.getName()+"\t");
			System.out.print(user.getAddr()+"\t");
			System.out.print(user.getMemo()+"\t");
			System.out.println(user.getHiredate()+"\t");
		}
	}*/

	@Override
	public void insertMenu() {
		System.out.println("********ȸ������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		System.out.print("�޸�:");
		String memo = key.next();
		MyEmpDTO user
			= new MyEmpDTO(id, pass, name, addr, memo);
		dao.insert(user);

	}

	@Override
	public void loginMenu() {
		// TODO Auto-generated method stub
		System.out.println("********�α���********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		MyEmpDTO user = dao.login(id, pass);
		if(user==null){
			System.out.println("�α��ν���");
		}else{
			System.out.println(user.getName()+"�� �α��� ����!!");
		}
	}

	@Override
	public void showAllMenu() {
		List<MyEmpDTO> userlist = dao.select();
		for (int i = 0; i < userlist.size(); i++) {
			MyEmpDTO user = userlist.get(i);
			System.out.print(user.getId()+"\t");
			System.out.print(user.getPass()+"\t");
			System.out.print(user.getName()+"\t");
			System.out.print(user.getAddr()+"\t");
			System.out.print(user.getGrade()+"\t");
			System.out.println(user.getDeptno()+"\t");
		}

	}

	/*@Override
	public void updateMenu() {
		System.out.println("********ȸ����������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		System.out.print("�޸�:");
		String memo = key.next();
		MemberDTO user
			= new MemberDTO(id, pass, addr, memo);
		dao.update(user);

	}*/

}








