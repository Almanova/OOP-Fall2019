package problem3;

public class Person {
	Gender gender;
	String name;
	int age;
	
	public Person(Gender gender, String name, int age) {
		this.gender = gender;
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + " " + age;
	}
}
