package di.setter03;

public class FileOutputter implements Outputter {
	private String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void output(String message) {
		System.out.println("FileOutputter : " + message);
	}
}
