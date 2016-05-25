package di.setter03;

public class ConsoleOutputter implements Outputter {
	private String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void output(String message) {
		System.out.println("ConsoleOutputter : " + message);
	}
	
}
