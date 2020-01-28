package task2;

import java.io.*;
import java.util.Objects;

public class Instructor implements Serializable {
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	
	public Instructor(String firstName, String lastName, String department, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Instructor\nFirst Name: " + firstName + "\nLast Name: " + lastName +
				"\nDepartment: " + department + "\nEmail: " + email;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if (!(object instanceof Instructor))
			return false;
		Instructor instructor = (Instructor)object;
		return this.firstName.equals(instructor.firstName) && 
				this.lastName.equals(instructor.lastName) &&
				this.department.equals(instructor.department) && 
				this.email.equals(instructor.email);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, department, email);
	}
}

