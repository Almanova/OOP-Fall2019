package task2;

import java.util.Objects;

public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if ( ! (object instanceof Person))
			return false;
		Person person = (Person)object;
		if (this.name.equals(person.name))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	public String toString() {
		return "Name: " + name;
	}
}
