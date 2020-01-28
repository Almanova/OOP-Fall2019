package problem2;

public class Test {
	public static void main(String []args) {
		Bank b = new Bank();
		Account a1 = new Account(6578);
		SavingsAccount a2 = new SavingsAccount(5356, 0.05);
		CheckingAccount a3 = new CheckingAccount(7845);
		b.openAccount(a1);
		b.openAccount(a2);
		b.openAccount(a3);
		for (Account a: b.getAccounts()) {
			a.deposit(10000);
		}
		a1.transfer(500, a3);
		b.update();
		//b.closeAccount(a2);
		for (Account a: b.getAccounts()) {
			a.print();
		}
	}
}
