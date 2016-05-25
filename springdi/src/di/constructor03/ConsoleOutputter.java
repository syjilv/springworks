package di.constructor03;

public class ConsoleOutputter implements Outputter {

	public void output(String message) {
		System.out.println("ConsoleOutputter : " + message);
	}
	
}
