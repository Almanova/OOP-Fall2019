package problem3;

import java.util.HashSet;

public class Test {

	public static void main(String []args) {
		HashSet<Person> st = new HashSet<Person>();
		st.add(new Person("A"));
		st.add(new Person("A"));
		st.add(new Employee("B", 100000, 2018, "AB123"));
		st.add(new Employee("B", 100000, 2018, "AB123"));
		st.add(new Employee("C", 120000, 2018, "AB1234"));
		st.add(new Manager("D", 120000, 2019, "AC123"));
		st.add(new Manager("D", 120000, 2019, "AC123"));
		for (Person p: st) {
			System.out.println(p + "\n");
		}
	}
}
