package task2;

import java.util.Objects;
import java.util.GregorianCalendar;

public class Employee extends Person implements Comparable, Cloneable {
	private double salary;
	private GregorianCalendar date;
	private String insurancenumber;
	
	public Employee(String name, int salary, String insurancenumber) {
		super(name);
		this.salary = salary;
		this.insurancenumber = insurancenumber;
	}
	
	public Employee(String name, int salary, GregorianCalendar date, String insurancenumber) {
		this(name, salary, insurancenumber);
		this.date = date;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public GregorianCalendar getDate() {
		return date;
	}
	
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	public String getInsuranceNumber() {
		return insurancenumber;
	}
	
	public void setInsuranceNumber(String insurancenumber) {
		this.insurancenumber = insurancenumber;
	}
	
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned = (Employee)super.clone();
		cloned.setDate((GregorianCalendar)date.clone());
		return cloned;
	}
	
	@Override
	public int compareTo(Object object) {
		Employee employee = (Employee)object;
		if (salary < employee.salary) return -1;
		if (salary > employee.salary) return 1;
		return 0;
	}
	
	@Override
	public boolean equals(Object object) {	
		if (!super.equals(object))
			return false;
		Employee employee = (Employee)object;
		return this.salary == employee.salary && this.date.equals(employee.date) && 
			this.insurancenumber.equals(employee.insurancenumber);
			
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(salary, date, insurancenumber);
	}
	
	public String toString() {
		return super.toString() + "\nSalary: " + salary + "\nDate: " + date.getTime() +
				"\nInsurance number: " + insurancenumber;
	}
}