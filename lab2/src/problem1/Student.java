package problem1;

public class Student {
	String name;
	String id;
	int yearofstudy;
	
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
		yearofstudy = 1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public int Increment() {
		yearofstudy++;
		return yearofstudy;
	}
	
	public String toString() {
		return "Student " + name + ", id: " + id;
	}
	
	public static void main(String []args) {
		Student student = new Student("Madina Almanova", "18BD133333");
		System.out.println("Name: " + student.getName());
		System.out.println("Id: " + student.getId());
		System.out.println("Year of study: " + student.Increment());
	}
}
