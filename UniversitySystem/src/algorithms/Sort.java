package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import comparators.FacultyComparator;
import comparators.NameComparator;
import comparators.SalaryComparator;
import comparators.SpecialtyComparator;
import data.Course;
import data.Faculty;
import university.Student;
import university.UniversitySystem;

public class Sort {

	public static void managersSorting() {
		UniversitySystem.printConsole("1. Sort by Last Name\n2. Sort by Salary");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("2"))
			Collections.sort(UniversitySystem.getData().getManagers(), new SalaryComparator());
		else 
			Collections.sort(UniversitySystem.getData().getManagers(), new NameComparator());
	}
	
	public static void techSupportGuysSorting() {
		UniversitySystem.printConsole("1. Sort by Last Name\n2. Sort by Salary");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("2"))
			Collections.sort(UniversitySystem.getData().getTechSupportGuys(), new SalaryComparator());
		else 
			Collections.sort(UniversitySystem.getData().getTechSupportGuys(), new NameComparator());
	}
	
	public static void teachersSorting() {
		UniversitySystem.printConsole("1. Sort by Last Name\n2. Sort by Faculty");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("2"))
			Collections.sort(UniversitySystem.getData().getTeachers(), new FacultyComparator());
		else 
			Collections.sort(UniversitySystem.getData().getTeachers(), new NameComparator());
	}
	
	public static ArrayList<Student> studentsSorting() {
		UniversitySystem.printConsole("Choose Faculty:");
		UniversitySystem.printList(UniversitySystem.getData().getFaculties());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Faculty f = UniversitySystem.getData().getFaculties().get(selection);
		ArrayList<Student> list = new ArrayList<Student>();
		for (Student s: UniversitySystem.getData().getStudents()) {
			if (s.getFaculty().equals(f))
				list.add(s);
		}
		UniversitySystem.printConsole("1. Sort by Last Name\n2. Sort by Specialty");
		String in = UniversitySystem.getConsoleInput();
		if (in.equals("2"))
			Collections.sort(list, new SpecialtyComparator());
		else 
			Collections.sort(list, new NameComparator());
		return list;
	}
}
