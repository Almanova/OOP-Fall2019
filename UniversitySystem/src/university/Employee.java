package university;

import java.util.Objects;

import data.Order;

public abstract class Employee extends User {
	private double salary;
	
	public Employee(String id, String firstName, String lastName, String login, String password,
			double salary) {
		super(id, firstName, lastName, login, password);
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public boolean sendOrder(TechSupportGuy tsg, Order order) {
		return tsg.recieveOrder(order);
	}
	
	@Override
	public boolean equals(Object object) {
		if ( ! super.equals(object))
			return false;
		Employee employee = (Employee)object;
		if (this.salary == employee.salary)
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(salary);
	}
}
