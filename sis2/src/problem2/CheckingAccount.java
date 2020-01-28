package problem2;

public class CheckingAccount extends Account {
	private int counter = 0;
	private static final int FREE_TRANSACTIONS = 1; 
	private static final double TRANSACTION_COST = 0.02;
	
	public CheckingAccount(int a) {
		super(a);
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void deposit(double sum) {
		super.deposit(sum);
		counter++;
	}
	
	public void withdraw(double sum) {
		super.withdraw(sum);
		counter++;
	}
	
	public void deductFee() {
		double sum = 0.0;
		if (counter > FREE_TRANSACTIONS)
			sum = (counter - FREE_TRANSACTIONS) * TRANSACTION_COST;
		this.withdraw(sum);
	}
	
	public String toString() {
		return super.toString() + "\nNumber of Transactions: " + counter;
	}
}
