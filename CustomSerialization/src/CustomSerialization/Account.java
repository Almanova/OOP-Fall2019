package CustomSerialization;

import java.io.*;

public class Account implements Externalizable {
	private String firstname;
	private String lastname;
	private String username;
	private transient String password;
	
	public Account() {
		
	}
	
	public Account(String firstname, String lastname, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(firstname);
		out.writeUTF(lastname);
		out.writeUTF(username);
		out.writeUTF(encrypt(password));
	}

	public void readExternal(ObjectInput in) throws IOException {
		firstname = (String)in.readUTF();
		lastname = (String)in.readUTF();
		username = (String)in.readUTF();
		password = encrypt((String)in.readUTF());
	}
	
	private String encrypt(String str) {
		StringBuilder sb = new StringBuilder(str); 
        sb.setCharAt(0, str.charAt(2)); 
        sb.setCharAt(2, str.charAt(0)); 
        sb.setCharAt(1, str.charAt(3));
        sb.setCharAt(3, str.charAt(1)); 
        return sb.toString();
	}
	
	public String toString() {
		return "First Name: " + firstname + "\nLastName: " + lastname + "\nUsername: " +
				username + "\nPassword: " + password;
	}
}
