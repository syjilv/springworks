package di.setter.basic;

public class InsaImpl implements Insa {
	MemberDAO dao;
	public InsaImpl() {}
	
	public MemberDAO getDao() {
		return dao;
	}

	public void setDao1(MemberDAO dao) {
		this.dao = dao;
		System.out.println("setter�޼ҵ� : " + dao);
	}

	public InsaImpl(MemberDAO dao) {
		super();
		this.dao = dao;
		System.out.println("dao injetiton �Ϸ�");
	}
	
	public void addUser(MemberDTO user) {
		dao.add(user);
	}

	@Override
	public MemberDTO getUser(String id) {
		dao.getUser("id");
		return null;
	}

}
