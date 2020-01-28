package university;

import java.util.ArrayList;

import algorithms.Election;
import algorithms.Sort;
import data.Auditorium;
import data.Course;
import data.DataModel;
import data.Faculty;
import data.Message;
import data.News;
import data.Order;
import data.Specialty;

public class ManagerController {
	private Manager manager;
	
	public ManagerController(Manager manager) {
		this.manager = manager;
	}
	
	public void managerUserInterface() {
		String selection = "";
		while (!selection.equals("Quit")) {
			UniversitySystem.printConsole("1. Add New Courses\n2. Add Courses For Registration" +
					"\n3. Assign Courses to Teachers\n4. View Information about Teachers" +
					"\n5. View Information about Students\n6. Manage News\n7. Manage Faculties" +
					"\n8. Send Message \n9.  Manage Auditoriums\n10. Manage Schedule\n11. Quit");
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					addNewCourses();
					break;
				case "2":
					addCoursesForRegistration();
					break;
				case "3":
					assignTeachers();
					break;
				case "4":
					viewTeacherInformation();
					break;
				case "5":
					viewStudentInformation();
					break;
				case "6":
					manageNews();
					break;
				case "7":
					manageFaculties();
					break;
				case "8":
					sendMessage();
					break;
				case "9":
					manageAuditoriums();
					break;
				case "10":
					manageCoursesSchedule();
					break;
				case "11":
					selection = "Quit";
					break;
			}
		}
	}
	
	private void addNewCourses() {
		if (manager.addCourse(DataModel.createCourse()))
			UniversitySystem.printConsole("Course has been succesfully added!");
		else 
			UniversitySystem.printConsole("Error occured...");
	}
	
	private void addCoursesForRegistration() {
		Faculty f = Election.chooseFaculty();
		UniversitySystem.printConsole("Choose the Specialty:");
		UniversitySystem.printList(f.getSpecialties());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Specialty s = f.getSpecialties().get(selection);
		Course c = Election.chooseCourse();
		if (manager.addCourseForRegistration(s, c))
			UniversitySystem.printConsole("Course has been succesfully added!");
		else 
			UniversitySystem.printConsole("Error occured...");
	}
	
	private void assignTeachers() {
		Course c = Election.chooseCourse();
		Teacher t = Election.chooseTeacher();
		manager.assignTeacher(c, t);
		UniversitySystem.printConsole("Teacher has been assigned!");
	}
	
	private void viewTeacherInformation() {
		UniversitySystem.printConsole(manager.viewTeacherInformation(Election.chooseTeacher()));
	}
	
	private void viewStudentInformation() {
		ArrayList<Student> list = Sort.studentsSorting();
		Student s = Election.chooseStudent(list);
		UniversitySystem.printConsole(manager.viewStudentInformation(s));
	}
	
	private void manageFaculties() {
		UniversitySystem.printConsole("1. Add New Faculty\n2. Update existing");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			Faculty f = DataModel.createFaculty();
			if (manager.addNewFaculty(f))
				UniversitySystem.printConsole("New Faculty has been successfully added!");
			else
				UniversitySystem.printConsole("Error occured...");
		}
		else if (selection.equals("2")) {
			Faculty f = Election.chooseFaculty();
			manager.updateFaculty(f);
			UniversitySystem.printConsole("Faculty has been succesfully updated!");
		}
	}
	
	private void manageNews() {
		News n = DataModel.createNews();
		if (manager.addNews(n))
			System.out.println("New has been added!");
		else 
			System.out.println("Error occured...");
	}
	
	private void manageAuditoriums() {
		System.out.println("1. Add new Auditorium to the System\n2. Manage Auditoriums schedule");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			Auditorium a = DataModel.createAuditorium();
			UniversitySystem.getData().getAuditoriums().add(a);
		}
		else if (selection.equals("2")) {
			System.out.println("Choose the number of Auditorium:");
			UniversitySystem.printList(UniversitySystem.getData().getAuditoriums());
			int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
			Auditorium a = UniversitySystem.getData().getAuditoriums().get(in);
			a.addBookingCells(DataModel.createBookingCell());
		}
	}
	
	private void sendMessage() {
		System.out.println("1. Message to Teacher\n2. Order to TechSupportGuy");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			Teacher t = Election.chooseTeacher();
			Message m = DataModel.createMessage();
			if (manager.sendMessageToTeacher(t, m))
				System.out.println("Message sent!");
			else 
				System.out.println("Error occured...");
		}
		else if (selection.equals("2")) {
			TechSupportGuy tsg = Election.chooseTechSupportGuy();
			Order o = DataModel.createOrder(manager, tsg);
			if (manager.sendOrder(tsg, o))
				System.out.println("Order sent!");
			else 
				System.out.println("Error occured...");
		}
	}
	
	private void manageCoursesSchedule() {
		Course c = Election.chooseCourse();
		manager.addScheduleCell(c, DataModel.createScheduleCell(c));
	}
}
