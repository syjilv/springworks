package di.constructor03;

public class MessageBean implements InterMessage {
	private String name;
	private String greeting;
	private Outputter outputter;
	
	public void sayHello() {
		outputter.output(name + " : " + greeting);
	}
	
	public MessageBean() {}
	public MessageBean(String name, String greeting,
				Outputter outputter) {
		super();
		this.name = name;
		this.greeting = greeting;
		this.outputter = outputter;
	}
}
