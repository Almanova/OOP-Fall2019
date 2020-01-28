package CustomSerialization;

import java.io.*;

public class Test {
	
	public static void serialize(Account account) throws IOException {
		FileOutputStream fos = new FileOutputStream("accounts.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(account);
		oos.close();
	}
	
	public static Account deserialize() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("accounts.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Account account = (Account) ois.readObject();
		ois.close();
		return account;
	}
	
	public static void main(String []args) throws IOException, ClassNotFoundException {
		Account account = new Account("Madina", "Almanova", "MaddieKan", "Sushi");
		System.out.println(account);
		serialize(account);
		Account account2 = deserialize();
		System.out.println(account2);
	}
}
