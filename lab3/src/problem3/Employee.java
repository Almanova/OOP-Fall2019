package problem3;

import java.util.Objects;

public class Employee extends Person {
	private double salary;
	private int year;
	private String insurancenumber;
	
	public Employee(String name, int salary, String insurancenumber) {
		super(name);
		this.salary = salary;
		this.insurancenumber = insurancenumber;
	}
	
	public Employee(String name, int salary, int year, String insurancenumber) {
		this(name, salary, insurancenumber);
		this.year = year;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getInsuranceNumber() {
		return insurancenumber;
	}
	
	public void setInsuranceNumber(String insurancenumber) {
		this.insurancenumber = insurancenumber;
	}
	
	@Override
	public boolean equals(Object object) {	
		if (!super.equals(object))
			return false;
		Employee employee = (Employee)object;
		return this.salary == employee.salary && this.year == employee.year && 
			this.insurancenumber.equals(employee.insurancenumber);
			
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(salary, year, insurancenumber);
	}
	
	public String toString() {
		return super.toString() + "\nSalary: " + salary + "\nYear: " + year + 
				"\nInsurance number: " + insurancenumber;
	}
}
