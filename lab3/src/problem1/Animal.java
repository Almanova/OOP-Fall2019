package problem1;

public class Animal {
	private String name;
	private String breed;
	private int age;
	
	public Animal(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public int getAge() {
		return age;
	}
	
	public void makeSound() {
		System.out.println("No sound");
	}

	public void incrementAge() {
		age++;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name + ", the breed is " + breed + " and the age is " + age;
	}
}
