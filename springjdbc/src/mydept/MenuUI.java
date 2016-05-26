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
	
	//시작을 알리는 메소드
	public void show(){
		System.out.println("**********부서관리 시스템************");
		System.out.println("1. 부서신설");
		System.out.println("2. 부서정보수정");
		System.out.println("3. 부서삭제");
		System.out.println("4. 부서목록보기");
		System.out.println("5. 부서번호검색");
		System.out.println("6. 부서수조회");
		System.out.println("7. 부서별 사원조회");
		System.out.println("8. 종료");
		System.out.print("원하는 작업을 선택하세요:");
		int menu=key.nextInt();
		menuSelect(menu);
	}
	//show에서 선택한 값을 넘겨받아서 각각의 메소드를 선택하는 역할을 하는 메소드
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
		System.out.println("******삭제*******");
		System.out.println("삭제할 부서번호를 입력하세요:");
		String deptno = key.next();
		dao.delete(deptno);

	}

	@Override
	public void findByDeptnoMenu() {
		System.out.println("********검색********");
		System.out.print("검색할 부서번호를 입력하세요:");
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
		System.out.println("********부서신설********");
		System.out.print("부서번호:");
		String deptno = key.next();
		System.out.print("부서명:");
		String deptname = key.next();
		System.out.print("위치:");
		String loc = key.next();
		System.out.print("전화번호:");
		String telnum = key.next();
		MyDeptDTO dept
			= new MyDeptDTO(deptno, deptname, loc, telnum);
		dao.insert(dept);

	}

	@Override
	public void showAllMenu() {
		
		List<MyDeptDTO> deptlist = dao.getDeptList();
		System.out.println("dao의 메소드 호출 후");
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
		System.out.println("********부서정보수정********");
		System.out.print("부서번호:");
		String deptno = key.next();
		System.out.print("부서명:");
		String deptname = key.next();
		System.out.print("위치:");
		String loc = key.next();
		System.out.print("전화번호:");
		String telnum = key.next();
		MyDeptDTO dept
			= new MyDeptDTO(deptno, deptname, loc, telnum);
		dao.update(dept);
		

	}
	@Override
	public void countMenu() {
		System.out.println("전체 부서 수:"+dao.count());
	}

	@Override
	public void findEmpByDeptnameMenu() {
		System.out.println("********사원조회********");
		System.out.print("검색할 부서명을 입력하세요:");
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








