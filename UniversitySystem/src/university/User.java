package university;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import data.Faculty;

public abstract class User implements Serializable, Comparable {
	private String id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	
	public User(String id, String firstName, String lastName, String login, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if ( ! (object instanceof User))
			return false;
		User user = (User)object;
		if (this.id.equals(user.id) && this.firstName.equals(user.firstName) &&
				this.lastName.equals(user.lastName) && this.login.equals(user.login))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, login);
	}
	
	@Override
	public int compareTo(Object object) {
		User user = (User)object;
		return lastName.compareTo(user.lastName);
	}
	
	public String toString() {
		return "id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName;
	}
	
	public void viewNews() {
		UniversitySystem.printNews(UniversitySystem.getData().getNews());
	}

	public abstract void userInterface();
	
	public abstract void updateUser();
}
