package comparators;

import java.util.Comparator;

import university.Student;

public class SpecialtyComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getSpecialty().compareTo(o2.getSpecialty());
	}
}
