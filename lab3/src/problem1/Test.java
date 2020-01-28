package problem1;

public class Test {
	public static void main(String []args) {
		Dog dog = new Dog("Becks", "Golden Retriever", 4);
		dog.makeSound();
		dog.incrementAge();
		System.out.println(dog.toString());
		dog.incrementAge(3);
		System.out.println(dog.toString());
	}
}
