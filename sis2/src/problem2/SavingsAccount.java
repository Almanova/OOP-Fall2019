package problem2;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(int a, double interestRate) {
		super(a);
		this.interestRate = interestRate;
	}
	
	public double interestRate() {
		return interestRate;
	}
	
	public void addInterest() {
		deposit(getBalance() * interestRate);
	}
	
	public String toString() {
		return super.toString() + "\nInterest Rate: " + interestRate;
	}
}
