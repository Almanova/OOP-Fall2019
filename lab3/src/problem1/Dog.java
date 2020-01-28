package problem1;

public class Dog extends Animal {
	
	public Dog(String name, String breed, int age) {
		super(name, breed, age);
	}
	
	public void makeSound() {
		System.out.println("Woof!");
	}
	
	public void incrementAge(int incr) {
		setAge(this.getAge() + incr);
	}
	
	public String toString() {
		return "This little dog's name is " + super.toString();
	}
}
