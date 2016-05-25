package jdbc;

public interface AbstractUI {
	//프로그램의 시작을 나타내는 메소드
	void show();
	//insert와 관련된 메소드(dao의 insert를 호출하는 메소드)
	void insertMenu();
	//update와 관련된 메소드(dao의 update를 호출하는 메소드)
	//void updateMenu();
	//delete와 관련된 메소드(dao의 delete를 호출하는 메소드)
	//void deleteMenu();
	//전체목록보기와 관련된 메소드(dao의 전체목록보기 메소드를 호출하는 메소드)
	void showAllMenu();
	//login와 관련된 메소드(dao의 login를 호출하는 메소드)
	void loginMenu();
	//검색과 관련된 메소드(dao의 검색기능 메소드를 호출하는 메소드)
	//void findByAddrMenu();
	
	
}
