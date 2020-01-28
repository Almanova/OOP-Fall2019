package task2;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Test {
	public static void main(String []args) {
		Vector<Employee> st = new Vector<Employee>();
		GregorianCalendar gc = new GregorianCalendar(2019, 1, 1);
		st.add(new Employee("B", 130000, gc, "AB123"));
		st.add(new Employee("B", 100000, gc, "AB123"));
		st.add(new Employee("C", 93000, gc, "AB1234"));
		Manager m1 = new Manager("D", 90000, gc, "AC123");
		m1.addBonus(3000);
		st.add(m1);
		Manager m2 = new Manager("D", 92000, gc, "AC123");
		m2.addBonus(1000);
		st.add(m2);
		Collections.sort(st);
		for (Employee p: st) {
			System.out.println(p + "\n");
		}
	}
}
