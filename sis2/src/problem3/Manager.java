package problem3;

import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee {
	private Vector<Employee> team;
	private double bonus;
	
	{
		team = new Vector<Employee>();
	}
	
	public Manager(String name, int salary, GregorianCalendar date, String insurancenumber) {
		super(name, salary, date, insurancenumber);
		this.bonus = 0;
	}
	
	public Vector<Employee> getTeam() {
		return team;
	}
	
	public void setTeam(Vector<Employee> team) {
		this.team = team;
	}
	
	public void addTeamMember(Employee employee) {
		team.add(employee);
	}
	
	public double getBonuses() {
		return bonus;
	}
	
	public void addBonus(double bonus) {
		this.bonus += bonus;
		this.setSalary(this.getSalary() + bonus);
	}
	
	public Manager clone() throws CloneNotSupportedException {
		Manager cloned = (Manager)super.clone();
		cloned.setTeam((Vector<Employee>)team.clone());
		return cloned;
	}
	
	@Override
	public int compareTo(Object object) {
		if (object instanceof Manager && super.compareTo(object) == 0) {
			Manager manager = (Manager)object;
			if (bonus < manager.bonus) return -1;
			if (bonus > manager.bonus) return 1;
		}
		return super.compareTo(object);
	}
	
	@Override
	public boolean equals(Object object) {
		if (!super.equals(object))
			return false;
		Manager manager = (Manager)object;
		if (this.team.equals(manager.team) && this.bonus == manager.bonus)
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hashCode(bonus);
	}
	
	public String toString() {
		return super.toString() + "\nBonuses: " + bonus + "\nTeam: " + team;
	}
}
