package problem5;

enum Position {
	TEACHER,
	STUDENT
}

public class Person {
	Position position;
	final String university = "KBTU";
	static int auditorium;
	String name;
	String id;
	
	static { //runs once when class is initialized
		System.out.println("The lesson has started");
	}
	
	{
		System.out.println("Person has entered the room");
	}
	
	public Person(String id) {
		this.id = id;
	}
	
	public Person(String id, String name) {
		this(id);
		setName(name);
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printName(int i, Person person) { //overloading - different numbers of parameters
		System.out.println(i + ". " + person.name);
	}
	
	public void  printName(Person person) {
		System.out.println(person.name);
	}
	
	public static void main() {
	}
}
