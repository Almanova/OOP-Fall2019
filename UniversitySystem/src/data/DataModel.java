package data;

import java.io.IOException;

import university.Employee;
import university.TechSupportGuy;
import university.UniversitySystem;
import university.User;

public class DataModel {

	public static Faculty createFaculty() {
		UniversitySystem.printConsole("Please, enter Faculty name:");
		Faculty faculty = new Faculty(UniversitySystem.getConsoleInput());
		return faculty;
	}
	
	public static void updateFaculty(Faculty faculty) {
		UniversitySystem.printConsole("What Faculty information do you want to update?"
				+ "\n1. Name\n2. Specialties");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			UniversitySystem.printConsole("Enter new Faculty name:");
			faculty.setName(UniversitySystem.getConsoleInput());
		}
		else if (selection.equals("2")) {
			UniversitySystem.printConsole("What changes do you want to make?" + 
					"\n1. Add new Specialty\n2. Update information\n3. Delete specialty");
			selection = UniversitySystem.getConsoleInput();
			if (selection.equals("1"))
				faculty.addSpecialty(createSpecialty());
			else if (selection.equals("2")) {
				UniversitySystem.printConsole("Enter number of Specialty you want to update:");
				faculty.printSpecialties();
				updateSpecialty(faculty.getSpecialties().get(Integer.parseInt(UniversitySystem.getConsoleInput()) - 1));
			}
			else if (selection.equals("3")) {
				UniversitySystem.printConsole("Enter number of Specialty you want to delete:");
				faculty.printSpecialties();
				faculty.getSpecialties().remove(Integer.parseInt(UniversitySystem.getConsoleInput()) - 1);
			}
		}
	}
	
	public static Specialty createSpecialty() {
		UniversitySystem.printConsole("Please, enter Specialty name:");
		Specialty specialty = new Specialty(UniversitySystem.getConsoleInput());
		return specialty;
	}
	
	public static void updateSpecialty(Specialty specialty) {
		UniversitySystem.printConsole("What Specialty information do you want to update?"
				+ "\n1. Name\n2. Courses");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			UniversitySystem.printConsole("Enter new Faculty name:");
			specialty.setName(UniversitySystem.getConsoleInput());
		}
		else if (selection.equals("2")) {
			UniversitySystem.printConsole("What changes do you want to make?" + 
					"\n1. Add new Course\n2. Delete Course");
			selection = UniversitySystem.getConsoleInput();
			if (selection.equals("1")) {
				UniversitySystem.printConsole("Choose number of Course you want to add:");
				UniversitySystem.printList(UniversitySystem.getData().getCourses());
				String in = UniversitySystem.getConsoleInput();
				specialty.addCourse(UniversitySystem.getData().getCourses().get(Integer.parseInt(in) - 1));
			}
			else if (selection.equals("2")) {
				UniversitySystem.printConsole("Enter number of Course you want to delete:");
				specialty.printCourses();
				specialty.getCourses().remove(Integer.parseInt(UniversitySystem.getConsoleInput()) - 1);
			}
		}
	}
	
	public static Course createCourse() {
		UniversitySystem.printConsole("Please, enter Course id:");
		String id = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Please, enter Course name:");
		String name = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Please, enter Number Of Credits:");
		int numberOfCredits = Integer.parseInt(UniversitySystem.getConsoleInput());
		Course course = new Course(id, name, numberOfCredits);
		return course;
	}
	
	public static void updateCourse(Course course) {
		UniversitySystem.printConsole("What Course information do you want to update?"
				+ "\n1. Id\n2. Name\n3. Number of Credits\n4. Add Prerequisite\n5. Add Course File");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			UniversitySystem.printConsole("Enter new Course id:");
			course.setId(UniversitySystem.getConsoleInput());
		}
		else if (selection.equals("2")) {
			UniversitySystem.printConsole("Enter new Course name:");
			course.setName(UniversitySystem.getConsoleInput());
		}
		else if (selection.equals("3")) {
			UniversitySystem.printConsole("Enter new Number of Credits:");
			course.setNumberOfCredits(Integer.parseInt(UniversitySystem.getConsoleInput()));
		}
		else if (selection.equals("4")) {
			UniversitySystem.printConsole("Choose number of Course you want to add:");
			UniversitySystem.printList(UniversitySystem.getData().getCourses());
			String in = UniversitySystem.getConsoleInput();
			course.addPrerequisite(UniversitySystem.getData().getCourses().get(Integer.parseInt(in) - 1));
		}
		else if (selection.equals("5")) {
			course.addCourseFile(DataModel.createCourseFile());
		}
	}
	
	public static News createNews() {
		System.out.println("Enter the subject of News:");
		String subject = UniversitySystem.getConsoleInput();
		System.out.println("Enter the text:");
		String text = UniversitySystem.getConsoleInput();
		return new News(subject, text);
	}
	
	public static Message createMessage() throws NumberFormatException {
		UniversitySystem.printConsole("Enter the number of author:");
		UniversitySystem.printList(UniversitySystem.getData().getManagers());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		User from = UniversitySystem.getData().getManagers().get(in);
		UniversitySystem.printConsole("Enter the number of reciever:");
		UniversitySystem.printList(UniversitySystem.getData().getTeachers());
		in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		User to = UniversitySystem.getData().getTeachers().get(in);
		UniversitySystem.printConsole("Enter the message text:");
		String text = UniversitySystem.getConsoleInput();
		return new Message(from, to, text);
	}
	
	public static Order createOrder(Employee e, TechSupportGuy t) throws NumberFormatException {
		System.out.println("Enter the text:");
		String text = UniversitySystem.getConsoleInput();
		return new Order(e, t, text);
	}
	
	public static Score createScore() {
		System.out.println("Enter Score:");
		double s = Double.parseDouble(UniversitySystem.getConsoleInput());
		return new Score(s);
	}
	
	public static Attendance createAttendance(Course course) {
		System.out.println("1. Attended\n2. Absent");
		String in = UniversitySystem.getConsoleInput();
		if (in.equals("1"))
			return new Attendance(course, true);
		else 
			return new Attendance(course, false);
	}
	
	public static Attestation createAttestation() {
		return new Attestation();
	}
	
	public static CourseFile createCourseFile() {
		UniversitySystem.printConsole("Please, enter Course File name:");
		String name = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Please, enter Course File path:");
		String path = UniversitySystem.getConsoleInput();
		CourseFile courseFile = new CourseFile(name, path);
		return courseFile;
	}
	
	public static Auditorium createAuditorium() {
		UniversitySystem.printConsole("Please, enter the number of Auditorium:");
		int num = Integer.parseInt(UniversitySystem.getConsoleInput());
		return new Auditorium(num);
	}
	
	public static BookingCell createBookingCell() {
		UniversitySystem.printConsole("Please, enter available time:");
		int num = Integer.parseInt(UniversitySystem.getConsoleInput());
		return new BookingCell(num);
	}
	
	public static ScheduleCell createScheduleCell(Course course) {
		System.out.println("Choose day of the week: \n1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday" +
				"\n5. Friday\n6. Suturday");
		int day = Integer.parseInt(UniversitySystem.getConsoleInput());
		System.out.println("Input time of the beginnig of a class:");
		int hour = Integer.parseInt(UniversitySystem.getConsoleInput());
		System.out.println("Choose the number of Auditorium:");
		UniversitySystem.printList(UniversitySystem.getData().getAuditoriums());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Auditorium a = UniversitySystem.getData().getAuditoriums().get(in);
		return new ScheduleCell(course, day, hour, a);
	}
 }
