package problem3;

import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee {
	private Vector<Employee> team;
	private double bonus;
	
	{
		team = new Vector<Employee>();
	}
	
	public Manager(String name, int salary, int year, String insurancenumber) {
		super(name, salary, year, insurancenumber);
		this.bonus = 0;
	}
	
	public Vector<Employee> getTeam() {
		return team;
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
