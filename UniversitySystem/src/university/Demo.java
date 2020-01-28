package university;

import java.io.IOException;

import data.Faculty;

public class Demo {
	
	public void authentication(UniversitySystem us) throws IOException {
		System.out.println("Welcome! \nEnter login:");
		String login = UniversitySystem.getConsoleInput();
		System.out.println("Enter password:");
		String password = UniversitySystem.getConsoleInput();
		//String h = UserFactory.encryptPassword(password);
		for (User u: UniversitySystem.getData().getUsers()) {
			if (u.getLogin().equals(login)) {
				if (u.getPassword().equals(password)) {
					us.startSession(u);
					break;
				}
				else {
					System.out.println("Wrong Login or Password!");
					authentication(us);
					break;
				}
			}
		}
		authentication(us);
	}
	
	public static void main(String []args) throws IOException {
		Demo demo = new Demo();
		UniversitySystem us = new UniversitySystem();
		demo.authentication(us);
		//Admin admin = new Admin("1", "first", "admin", "in", "system");
		//admin.userInterface();
		//us.serialize("data.out", UniversitySystem.getData());
	}
}
