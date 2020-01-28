package university;

import java.io.IOException;

import algorithms.CourseStatistics;
import algorithms.Election;
import algorithms.Sort;
import data.Auditorium;
import data.Course;
import data.DataModel;
import data.Order;
import data.Score;

public class TeacherController {
	private Teacher teacher;
	
	public TeacherController(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void teacherUserInterface() {
		String selection = "";
		while (!selection.equals("Quit")) {
			UniversitySystem.printConsole("1. View Courses/Students\n2. Manage Course Files" +
					"\n3. Put Mark\n4. View Course Statistics" +
					"\n5. View Messages\n6. Send Order\n7. View Rating\n8. Book Auditorium" +
					"\n9. Put Attendance\n10. Quit");
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					viewCourses();
					break;
				case "2":
					manageCourseFiles();
					break;
				case "3":
					putMark();
					break;
				case "4":
					viewStatistics();
					break;
				case "5":
					viewMessages();
					break;
				case "6":
					sendOrder();
					break;
				case "7":
					viewRating();
					break;
				case "8":
					bookAuditorium();
					break;
				case "9":
					putAttendance();
					break;
				case "10":
					selection = "Quit";
					break;
			}
		}
	}
	
	private void viewCourses() {
		System.out.println("Choose the Course:");
		UniversitySystem.printList(teacher.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = teacher.getCourses().get(in);
		System.out.println("Choose the Student:");
		UniversitySystem.printList(c.getStudents());
		in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		System.out.println(c.getStudents().get(in).getAllInformation());
	}
	
	private void manageCourseFiles() {
		System.out.println("Choose the Course:");
		UniversitySystem.printList(teacher.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = teacher.getCourses().get(in);
		DataModel.updateCourse(c);
	}
	
	private void viewMessages() {
		UniversitySystem.printList(teacher.getMessages());
	}
	
	private void sendOrder() {
		TechSupportGuy tsg = Election.chooseTechSupportGuy();
		Order o = DataModel.createOrder(teacher, tsg);
		if (teacher.sendOrder(tsg, o))
			System.out.println("Order sent!");
		else 
			System.out.println("Error occured...");
	}
	
	private void bookAuditorium() {
		System.out.println("Choose the number of Auditorium:");
		UniversitySystem.printList(UniversitySystem.getData().getAuditoriums());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Auditorium a = UniversitySystem.getData().getAuditoriums().get(in);
		String output = UniversitySystem.getCurrentTimeString() + " booked auditorium #" +
				a.getNumber() + ";";
		UniversitySystem.printToLogFile(output, teacher.getLogin());
		System.out.println("Choose the Available time:");
		UniversitySystem.printList(a.getBookingCells());
		in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		a.getBookingCells().get(in).book();
		a.getBookingCells().get(in).setUser(teacher);
		System.out.println("Auditorium has been booked!");
	}
	
	private void viewRating() {
		System.out.println("Your rating: " + teacher.viewRating());
	}
	
	private void viewStatistics() {
		System.out.println("Choose the Course:");
		UniversitySystem.printList(teacher.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = teacher.getCourses().get(in);
		CourseStatistics cs = new CourseStatistics();
		cs.fillMarks(c);
		cs.displayGradeReport();
	}
	
	private void putMark() {
		System.out.println("Choose the Course:");
		UniversitySystem.printList(teacher.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = teacher.getCourses().get(in);
		System.out.println("Choose Student:");
		UniversitySystem.printList(c.getStudents());
		in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Student s = c.getStudents().get(in);
		String output = UniversitySystem.getCurrentTimeString() + " put mark on course " +
				c.getName() + " to student " + s.getLastName() + ";";
		UniversitySystem.printToLogFile(output, teacher.getLogin());
		System.out.println("1. First Attestation\n2. Second Attestation\n3. Final");
		String selection = UniversitySystem.getConsoleInput();
		Score score = DataModel.createScore();
		if (selection.equals("1"))
			teacher.putMark(c, s, score, 1);
		else if (selection.equals("2"))
			teacher.putMark(c, s, score, 2);
		else if (selection.equals("3"))
			teacher.putMark(c, s, score, 3);
	}
	
	public void putAttendance() {
		System.out.println("Choose the Course:");
		UniversitySystem.printList(teacher.getCourses());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Course c = teacher.getCourses().get(in);
		System.out.println("Choose Student:");
		UniversitySystem.printList(c.getStudents());
		in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Student s = c.getStudents().get(in);
		teacher.putAttendance(s, DataModel.createAttendance(c));
		System.out.println("Attendance has been added!");
	}
}
