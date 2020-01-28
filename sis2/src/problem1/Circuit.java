package problem1;

public abstract class Circuit {
	public abstract double getResistance();
	public abstract double getPotentialDifference();
	public abstract void applyPotentialDifference(double V);
	
	public double getCurrent() {
		return getPotentialDifference() / getResistance();
	}
	
	public double getPower() {
		return getCurrent() * getCurrent() * getResistance(); 
	}
}
