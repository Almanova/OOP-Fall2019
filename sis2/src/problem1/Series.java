package problem1;

public class Series extends Circuit {
	private Circuit a;
	private Circuit b;
	
	public Series(Circuit a, Circuit b) {
		this.a = a;
		this.b = b;
	}

	public double getResistance() {
		return a.getResistance() + b.getResistance();
	}
	
	public double getPotentialDifference() {
		return a.getPotentialDifference() + b.getPotentialDifference();
	}
	
	public void applyPotentialDifference(double V) {
		double I = V / getResistance();
		a.applyPotentialDifference(I * a.getResistance());
		b.applyPotentialDifference(I * b.getResistance());
	}
}