package university;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import algorithms.Sort;
import comparators.FacultyComparator;
import comparators.NameComparator;
import comparators.SalaryComparator;
import comparators.SpecialtyComparator;
import data.Faculty;

public class AdminController {
	private Admin admin;
	
	public AdminController(Admin admin) {
		this.admin = admin;
	}
	
	public void adminUserInterface() {
		String selection = "";
		while (!selection.equals("Quit")) {
			UniversitySystem.printConsole("1. Add New User\n2. View list of Users" +
					"\n3. Manage existing Users (update/remove/see actions)\n4. Quit");
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					addNewUser();
					break;
				case "2":
					optionsViewListOfUsers();
					break;
				case "3":
					manageUsers();
					break;
				case "4":
					selection = "Quit";
					break;
			}
		}
	}
	
	private void addNewUser() {
		UserFactory uf = new UserFactory();
		User user = uf.optionsForCreation();
		if (admin.addNewUser(user))
			UniversitySystem.printConsole("New User succesfully added!");
		else 
			UniversitySystem.printConsole("Error occured...");
	}
	
	private <T> ArrayList<T> optionsViewListOfUsers() {
		UniversitySystem.printConsole("1. View List of All Users\n2. View List of Managers" +
				"\n3. View List of Teachers\n4. View List of Students\n5. View List of TechSupportGuys");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1"))
			return (ArrayList<T>) admin.viewListOfAllUsers();
		else if (selection.equals("2")) {
			Sort.managersSorting();
			return (ArrayList<T>) admin.viewListOfManagers();
		}
		else if (selection.equals("3")) {
			Sort.teachersSorting();
			return (ArrayList<T>) admin.viewListOfTeachers();
		}
		else if (selection.equals("4")) {
			return (ArrayList<T>) admin.viewListOfStudents(Sort.studentsSorting());
		}
		else if (selection.equals("5")) {
			Sort.techSupportGuysSorting();
			return (ArrayList<T>) admin.viewListOfTechSupportGuys();
		}
		return null;
	}
	
	private void manageUsers() {
		ArrayList<User> users = optionsViewListOfUsers();
		UniversitySystem.printConsole("Choose the User:");
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		User user = users.get(in);
		UniversitySystem.printConsole("Choose option:\n1. Update User\n2. Delete User" +
				"\n3. See actions");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1")) {
			admin.updateUserInformation(user);
			UniversitySystem.printConsole("User has been succesfully updated!");
		}
		else if (selection.equals("2")) {
			if (admin.deleteUser(user))
				UniversitySystem.printConsole("Deletion complete!");
			else 
				UniversitySystem.printConsole("Error occured...");
		}
		else if (selection.equals("3")) {
			try {
				String path = user.getLogin() + ".txt";
				File file = new File(path); 
				BufferedReader br = new BufferedReader(new FileReader(file)); 
				String st; 
				while ((st = br.readLine()) != null) 
					System.out.println(st); 
				br.close();
			} catch (IOException ioe) {
				System.out.println("Error occured...");
			}
		}
	}
}
