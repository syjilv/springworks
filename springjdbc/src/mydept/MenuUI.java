package mydept;

import java.util.List;
import java.util.Scanner;

import myemp.MyEmpDTO;

public class MenuUI implements AbstractUI {
	Scanner key = new Scanner(System.in);
	MyDeptDAO dao;

	public MenuUI(MyDeptDAO dao) {
		super();
		this.dao = dao;
	}
	
	//������ �˸��� �޼ҵ�
	public void show(){
		System.out.println("**********�μ����� �ý���************");
		System.out.println("1. �μ��ż�");
		System.out.println("2. �μ���������");
		System.out.println("3. �μ�����");
		System.out.println("4. �μ���Ϻ���");
		System.out.println("5. �μ���ȣ�˻�");
		System.out.println("6. �μ�����ȸ");
		System.out.println("7. �μ��� �����ȸ");
		System.out.println("8. ����");
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
				updateMenu();
				break;
			case 3:
				deleteMenu();
				break;
			case 4:
				showAllMenu();
				break;
			case 5:
				findByDeptnoMenu();
				break;
			case 6:
				countMenu();
				break;
			case 7:
				findEmpByDeptnameMenu();
				break;
			case 8:
				System.exit(0);
		}
	}
	@Override
	public void deleteMenu() {
		System.out.println("******����*******");
		System.out.println("������ �μ���ȣ�� �Է��ϼ���:");
		String deptno = key.next();
		dao.delete(deptno);

	}

	@Override
	public void findByDeptnoMenu() {
		System.out.println("********�˻�********");
		System.out.print("�˻��� �μ���ȣ�� �Է��ϼ���:");
		String deptno = key.next();
		List<MyDeptDTO> deptlist = dao.findByDeptno(deptno);
		for (int i = 0; i < deptlist.size(); i++) {
			MyDeptDTO dept = deptlist.get(i);
			System.out.print(dept.getDeptno()+"\t");
			System.out.print(dept.getDeptname()+"\t");
			System.out.print(dept.getLoc()+"\t");
			System.out.println(dept.getTelnum());
		}
	}

	@Override
	public void insertMenu() {
		System.out.println("********�μ��ż�********");
		System.out.print("�μ���ȣ:");
		String deptno = key.next();
		System.out.print("�μ���:");
		String deptname = key.next();
		System.out.print("��ġ:");
		String loc = key.next();
		System.out.print("��ȭ��ȣ:");
		String telnum = key.next();
		MyDeptDTO dept
			= new MyDeptDTO(deptno, deptname, loc, telnum);
		dao.insert(dept);

	}

	@Override
	public void showAllMenu() {
		
		List<MyDeptDTO> deptlist = dao.getDeptList();
		System.out.println("dao�� �޼ҵ� ȣ�� ��");
		for (int i = 0; i < deptlist.size(); i++) {
			MyDeptDTO dept = deptlist.get(i);
			System.out.print(dept.getDeptno()+"\t");
			System.out.print(dept.getDeptname()+"\t");
			System.out.print(dept.getLoc()+"\t");
			System.out.println(dept.getTelnum());
		}

	}

	@Override
	public void updateMenu() {
		System.out.println("********�μ���������********");
		System.out.print("�μ���ȣ:");
		String deptno = key.next();
		System.out.print("�μ���:");
		String deptname = key.next();
		System.out.print("��ġ:");
		String loc = key.next();
		System.out.print("��ȭ��ȣ:");
		String telnum = key.next();
		MyDeptDTO dept
			= new MyDeptDTO(deptno, deptname, loc, telnum);
		dao.update(dept);
		

	}
	@Override
	public void countMenu() {
		System.out.println("��ü �μ� ��:"+dao.count());
	}

	@Override
	public void findEmpByDeptnameMenu() {
		System.out.println("********�����ȸ********");
		System.out.print("�˻��� �μ����� �Է��ϼ���:");
		String deptname = key.next();
		List<MyEmpDTO> emplist = dao.findEmpByDeptname(deptname);
		for (int i = 0; i < emplist.size(); i++) {
			MyEmpDTO emp = emplist.get(i);
			System.out.print(emp.getId()+"\t");
			System.out.print(emp.getPass()+"\t");
			System.out.print(emp.getName()+"\t");
			System.out.print(emp.getAddr()+"\t");
			System.out.print(emp.getGrade()+"\t");
			System.out.print(emp.getSal()+"\t");
			System.out.println(emp.getDeptno());
		}
		
	}

}








