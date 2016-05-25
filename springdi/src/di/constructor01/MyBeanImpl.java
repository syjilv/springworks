package di.constructor01;

public class MyBeanImpl implements MyBean {
	String name;
	String msg;
	MyBeanLogic logic;
	
	public MyBeanImpl() {}
	
	public MyBeanImpl(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
		System.out.println("�Ű����� 2�� ������");
	}
	
	public MyBeanImpl(String name, String msg, MyBeanLogic logic) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
		System.out.println("�Ű����� 3�� ������");

	}

	@Override
	public void sayHello() {
		System.out.println(msg + "! " + name);
		logic.logic();

	}

}
