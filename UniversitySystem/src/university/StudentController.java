package university;

import java.util.ArrayList;

import algorithms.Election;
import data.Course;
import data.ScheduleCell;

public class StudentController {
	private Student student;
	
	public StudentController(Student student) {
		this.student = student;
	}
	
	public void studentUserInterface() {
		String selection = "";
		while (!selection.equals("Quit")) {
			UniversitySystem.printConsole("1. View Courses\n2. Register for a Course" +
					"\n3. View Marks\n4. View Transcript\n5. Rate Teachers\n6. View Attendance" + 
					"\n7. Manage Schedule\n8. View Schedule\n9. Quit");
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					viewCourses();
					break;
				case "2":
					registration();
					break;
				case "3":
					viewMarks();
					break;
				case "4":
					printTranscript();
					break;
				case "5":
					rateTeachers();
					break;
				case "6":
					viewAttendance();
					break;
				case "7":
					manageSchedule();
					break;
				case "8":
					viewSchedule();
					break;
				case "9":
					selection = "Quit";
					break;
			}
		}
	}
	
	private void viewCourses() {
		UniversitySystem.printList(student.viewListOfCourses());
		System.out.println("Сhoose the course to view information:");
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = student.viewListOfCourses().get(in);
		System.out.println("1. View List of Files\n2. View Information about Teacher");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1"))
			UniversitySystem.printList(c.getCourseFiles());
		else if (selection.equals("2"))
			System.out.println(c.getTeacher().getAllInformation());
	}
	
	private void registration() {
		System.out.println("Choose the number of Course:");
		UniversitySystem.printList(student.getSpecialty().getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = student.getSpecialty().getCourses().get(in);
		try {
			student.registerForCourse(c);
		} catch (CreditsOverflowException coe) {
			System.out.println("You are not allowed to take more than 21 credits!");
		}
	}
	
	private void viewMarks() {
		System.out.println("Choose the number of Course:");
		UniversitySystem.printList(student.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = student.getCourses().get(in);
		System.out.println(student.viewMarks(c));
	}
	
	private void printTranscript() {
		System.out.println(student.viewTranscript());
	}
	
	private void rateTeachers() {
		Teacher t = Election.chooseTeacher();
		System.out.println("Rate the Teacher(max 5):");
		int rate = Integer.parseInt(UniversitySystem.getConsoleInput());
		if (student.rateTeacher(t, rate)) 
			System.out.println("Succesfully added!");
		else 
			System.out.println("Error occured...");
	}
	
	private void viewAttendance() {
		System.out.println("Choose the number of Course:");
		UniversitySystem.printList(student.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = student.getCourses().get(in);
		System.out.println(student.viewAttendance(c));
	}
	
	private void manageSchedule() {
		System.out.println("Choose the Course:");
		UniversitySystem.printList(student.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = student.viewListOfCourses().get(in);
		for (int i = 0; i < c.getNumberOfCredidts(); i++) {
			ArrayList<ScheduleCell> cells = new ArrayList<ScheduleCell>();
			for (ScheduleCell cell: c.getCells()) {
				if (student.getSchedule().getCells()[cell.getDayOfTheWeek()][cell.getHour() - 8] == null)
					cells.add(cell);
			}
			System.out.println("Choose available time:");
			UniversitySystem.printList(cells/*c.getCells()*/);
			in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
			student.addToScedule(cells.get(in)/*c.getCells().get(in)*/);
		}
	}
	
	private void viewSchedule() {
		System.out.println(student.getSchedule());
	}
}
