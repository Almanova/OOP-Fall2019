package university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import comparators.FacultyComparator;
import comparators.NameComparator;
import comparators.SalaryComparator;
import comparators.SpecialtyComparator;
import data.Faculty;

public class Admin extends User {
	public Admin(String id, String firstName, String lastName, String login, String password) {
		super(id, firstName, lastName, login, password);
	}
	
	public void userInterface() {
		AdminController ac = new AdminController(this);
		ac.adminUserInterface();
	}
	
	public boolean addNewUser(User user) {
		if (user instanceof Manager)
			UniversitySystem.getData().getManagers().add((Manager)user);
		else if (user instanceof Teacher)
			UniversitySystem.getData().getTeachers().add((Teacher)user);
		else if (user instanceof Student)
			UniversitySystem.getData().getStudents().add((Student)user);
		else if (user instanceof TechSupportGuy)
			UniversitySystem.getData().getTechSupportGuys().add((TechSupportGuy)user);
		return UniversitySystem.getData().getUsers().add(user);
	}
	
	public ArrayList<User> viewListOfAllUsers() {
		Collections.sort(UniversitySystem.getData().getUsers(), new NameComparator());
		UniversitySystem.printList(UniversitySystem.getData().getUsers());
		return UniversitySystem.getData().getUsers();
	}
	
	public ArrayList<Manager> viewListOfManagers() {
		UniversitySystem.printList(UniversitySystem.getData().getManagers());
		return UniversitySystem.getData().getManagers();
	}
	
	public ArrayList<Teacher> viewListOfTeachers() {
		UniversitySystem.printList(UniversitySystem.getData().getTeachers());
		return UniversitySystem.getData().getTeachers();
	}
	
	public ArrayList<Student> viewListOfStudents(ArrayList<Student> list) {
		UniversitySystem.printList(list);
		return list;
	}
	
	public ArrayList<TechSupportGuy> viewListOfTechSupportGuys() {
		UniversitySystem.printList(UniversitySystem.getData().getTechSupportGuys());
		return UniversitySystem.getData().getTechSupportGuys();
	}
	
	public void updateUserInformation(User user) {
		user.updateUser();
	}
	
	public boolean deleteUser(User user) {
		if (user instanceof Student)
			UniversitySystem.getData().getStudents().remove((Student)user);
		else if (user instanceof Manager)
			UniversitySystem.getData().getManagers().remove((Manager)user);
		else if (user instanceof Teacher)
			UniversitySystem.getData().getTeachers().remove((Teacher)user);
		else if (user instanceof TechSupportGuy)
			UniversitySystem.getData().getTechSupportGuys().remove((TechSupportGuy)user);
		return UniversitySystem.getData().getUsers().remove(user);
	}
	
	@Override 
	public boolean equals(Object object) {
		return super.equals(object);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public void updateUser() {
		UserFactory.updateAdmin(this);
	}
}
