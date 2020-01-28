package problem5;

import java.util.Vector;

public class Test {
	Vector<Person> people;
	
	{
		people = new Vector<Person>();
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public void printPeople() {
		for (Person p: people) {
			System.out.println(p);
		}
	}
	
	public static void main(String []args) {
		Test test = new Test();
		test.addPerson(new Person("A", "A-55"));
		test.addPerson(new Student("B", "B-66", "abc", 2, 12));
		test.addPerson(new Staff("C", "C-77", "dd", 180000));
		test.printPeople();
	}
}
