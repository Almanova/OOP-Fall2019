package problem1;

public class Parallel extends Circuit {
	private Circuit a;
	private Circuit b;
	
	public Parallel (Circuit a, Circuit b) {
		this.a = a;
		this.b = b;
	}
	
	public double getResistance() {
		double R1 = a.getResistance(), R2 = b.getResistance();
		return (R1 * R2) / (R1 + R2);
	}
	
	public double getPotentialDifference() {
		if (a.getPotentialDifference() != b.getPotentialDifference())
			throw new RuntimeException();
		return a.getPotentialDifference();
	}
	
	public void applyPotentialDifference(double V) {
		a.applyPotentialDifference(V);
		b.applyPotentialDifference(V);
	}
}
