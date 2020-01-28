package problem1;

public class Resistor extends Circuit {
	private double resistance;
	private double potentialDifference;
	
	public Resistor(double resistance) {
		this.resistance = resistance;
	}
	
	public double getResistance() {
		return resistance;
	}
	
	public double getPotentialDifference() {
		return potentialDifference;
	}
	
	public void applyPotentialDifference(double V) {
		potentialDifference = V;
	}
}
