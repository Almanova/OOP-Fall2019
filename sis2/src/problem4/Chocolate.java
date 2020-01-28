package problem4;

public class Chocolate implements Comparable {
	private String name;
	private double weight;
	
	public Chocolate(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return name + " - " + weight + "g";
	}

	@Override
	public int compareTo(Object object) {
		Chocolate chocolate = (Chocolate)object;
		if (weight < chocolate.weight) return -1;
		if (weight > chocolate.weight) return 1;
		return 0;
	}
}
