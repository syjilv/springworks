package di.constructor03;

public class FileOutputter implements Outputter {
	private String filePath;

	public FileOutputter(String filePath) {
		super();
		this.filePath = filePath;
	}
	
	public void output(String message) {
		System.out.println("FileOutputter : " + message);
	}
	
}
