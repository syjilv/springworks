package di.setter01;

public class MyBeanImpl implements MyBean {
	String name;
	String msg;
	MyBeanLogic logic;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MyBeanLogic getLogic() {
		return logic;
	}

	public void setLogic(MyBeanLogic logic) {
		this.logic = logic;
	}
	
	public MyBeanImpl() {}
	
	public MyBeanImpl(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
		System.out.println("매개변수 2개 생성자");
	}
	
//	public MyBeanImpl(String name, String msg, MyBeanLogic logic) {
//		super();
//		this.name = name;
//		this.msg = msg;
//		this.logic = logic;
//		System.out.println("매개변수 3개 생성자");
//
//	}

	@Override
	public void sayHello() {
		System.out.println(msg + "! " + name);
		logic.logic();

	}

}
