package task1;

public class Browser implements Application {
	private String name;
	
	public Browser (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void installApplication() {
		System.out.println("Installation of a Browser...");
	}
	
	public void runApplication() {
		System.out.println("Running Browser...");
	}
	
	public void closeApplication() {
		System.out.println("Closing Browser...");
	}

	public String toString() {
		return name;
	}
}
