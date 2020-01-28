package problem3;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Test {
	public static void main(String []args) throws CloneNotSupportedException {
		Employee emp = new Employee("A", 1000000, new GregorianCalendar(), "123AB");
		Employee empclone = emp.clone();
		emp.getDate().set(2001, 2, 22);
		//System.out.println(emp + "\n" + empclone);
		empclone.setName("B");
		Manager manager = new Manager("C", 1200000, new GregorianCalendar(), "234BC");
		manager.addTeamMember(emp);
		manager.addTeamMember(empclone);
		Manager managerclone = manager.clone();
		manager.getTeam().remove(0);
		manager.setDate(new GregorianCalendar(2008, 11, 5));
		//System.out.println(manager + "\n" + managerclone);
		Vector<Employee> employees = new Vector<Employee>();
		employees.add(empclone);
		employees.add(manager);
		employees.add(emp);
		NameComparator nc = new NameComparator();
		DateComparator dc = new DateComparator();
		Collections.sort(employees, nc);
		//for (Employee e: employees) 
			//System.out.println(e);
		Collections.sort(employees, dc);
		for (Employee e: employees) 
			System.out.println(e);
	}
}
