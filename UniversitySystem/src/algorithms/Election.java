package algorithms;

import java.util.ArrayList;

import data.Course;
import data.Faculty;
import university.Student;
import university.Teacher;
import university.TechSupportGuy;
import university.UniversitySystem;

public class Election {
	public static Course chooseCourse() {
		UniversitySystem.printConsole("Choose the Course:");
		UniversitySystem.printList(UniversitySystem.getData().getCourses());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return UniversitySystem.getData().getCourses().get(selection);
	}
	
	public static Teacher chooseTeacher() {
		UniversitySystem.printConsole("Choose the Teacher:");
		Sort.teachersSorting();
		UniversitySystem.printList(UniversitySystem.getData().getTeachers());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return UniversitySystem.getData().getTeachers().get(selection);
	}
	
	public static Student chooseStudent() {
		UniversitySystem.printConsole("Choose the Student:");
		UniversitySystem.printList(UniversitySystem.getData().getStudents());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return UniversitySystem.getData().getStudents().get(selection);
	}
	
	public static TechSupportGuy chooseTechSupportGuy() {
		UniversitySystem.printConsole("Choose the TechSupportGuy:");
		UniversitySystem.printList(UniversitySystem.getData().getTechSupportGuys());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return UniversitySystem.getData().getTechSupportGuys().get(selection);
	}
	
	public static Student chooseStudent(ArrayList<Student> list) {
		UniversitySystem.printConsole("Choose the Student:");
		UniversitySystem.printList(list);
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return list.get(selection);
	}
	
	public static Faculty chooseFaculty() {
		UniversitySystem.printConsole("Choose the Faculty:");
		UniversitySystem.printList(UniversitySystem.getData().getFaculties());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return UniversitySystem.getData().getFaculties().get(selection);
	}
}
