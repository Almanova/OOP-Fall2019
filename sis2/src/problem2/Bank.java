package problem2;

import java.util.Vector;
public class Bank {
	private Vector<Account> accounts;
	
	{
		accounts = new Vector<Account>();
	}
	
	public Vector<Account> getAccounts() {
		return accounts;
	}
	
	public void update() {
		for (Account a: accounts) {
			if (a instanceof CheckingAccount)
				((CheckingAccount)a).deductFee();
			else if (a instanceof SavingsAccount)
				((SavingsAccount)a).addInterest();
		}
	}
	
	public void openAccount(Account a) {
		accounts.add(a);
	}
	
	public void closeAccount(Account a) {
		accounts.remove(a);
	}
}
