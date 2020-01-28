package task1;

public class Notepad implements Viewable, Application {
	private String name;
	
	public Notepad(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void installApplication() {
		System.out.println("Installation of a Notepad...");
	}
	
	public void runApplication() {
		System.out.println("Running Notepad...");
	}
	
	public void closeApplication() {
		System.out.println("Closing Notepad...");
	}
	
	public String toString() {
		return name;
	}
}
