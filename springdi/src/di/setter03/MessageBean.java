package di.setter03;

public class MessageBean implements InterMessage {
	private String name;
	private String greeting;
	private Outputter outputter;
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	public void sayHello() {
		outputter.output(name + " : " + greeting);
	}
	
	public MessageBean(String name) {
		super();
		this.name = name;
	}
}
