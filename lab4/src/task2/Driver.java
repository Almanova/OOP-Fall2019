package task2;

import java.io.*;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Driver {
	BufferedReader in;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	ArrayList<Course> courses;
	
	{
		System.out.println("Welcome!");
		in = new BufferedReader(new InputStreamReader(System.in));
		File file = new File("admin.txt");
		if (!file.exists()) {
			File f = new File("admin.txt");
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error");
			}
		}
		courses = new ArrayList<Course>();
	}

	public void displayModeSelection() throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
		deserialize();
		System.out.println("\nEnter the number of the mode you want to activate: " + 
				"\n1. User Mode\n2. Admin Mode");
		String selection = in.readLine();
		if (selection.equals("1"))
			displayUserChoices();
		else {
			adminAuthentication();
			addNewCourse();
		}
	}
	
	public void displayUserChoices() throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
		System.out.println("What action do you want to make?\n" + 
				"1. View the list of available courses\n" + 
				"2. Display information about the course");
		String selection = in.readLine();
		if (selection.equals("1"))
			printListOfCourses();
		else 
			selectCourseToPrintInfo();
		displayModeSelection();
	}
	
	public void adminAuthentication() throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
		System.out.println("Enter your username: ");
		String username = in.readLine();
		System.out.println("Enter your password: ");
		String password = in.readLine();
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String hashedpassword = digest.toString();
		String output = "\n\n" + getCurrentTime() + " admin logged into a system" + 
				"\nUsername: " + username + "\nPassword: " + hashedpassword + "\n\n";
		printToAdminFile(output);
		addNewCourse();
		displayModeSelection();
	}
	
	public void printToAdminFile(String output) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("admin.txt", true));
		out.write(output);
		out.close();
	}
	
	public void printListOfCourses() {
		System.out.println("List of available courses: ");
		for (int i = 0; i < courses.size(); i++)
			System.out.println(i + 1 + ". " + courses.get(i).getCourseTitle());
	}
	
	public void selectCourseToPrintInfo() throws IOException {
		printListOfCourses();
		System.out.println("Enter the number of a course you want to get information about: ");
		String selection = in.readLine();
		System.out.println(courses.get(Integer.parseInt(selection) - 1).toString());
	}
	
	public String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();  
		String currenttime = dtf.format(now);
		return currenttime;
	}
	
	public void addNewCourse() throws IOException {
		System.out.println("Please, enter the required information in order to add new course:" +
				"\nCourse title: ");
		String courseTitle = in.readLine();
		System.out.println("Textbook isbn: ");
		String isbn = in.readLine();
		System.out.println("Textbook title: ");
		String title = in.readLine();
		System.out.println("Textbook author(s): ");
		String authors = in.readLine();
		String[] authorslist = authors.split(", ");
		System.out.println("Instructor's first name: ");
		String firstName = in.readLine();
		System.out.println("Instructors's last name: ");
		String lastName = in.readLine();
		System.out.println("Instructor's department: ");
		String department = in.readLine();
		System.out.println("Instructor's email: ");
		String email = in.readLine();
		Course course = new Course(courseTitle, isbn, title, authorslist, firstName, 
				lastName, department, email);
		courses.add(course);
		printToAdminFile(getCurrentTime() + " admin added new course «" + courseTitle + "»");
		oneMoreCourse();
	}
	
	public void oneMoreCourse() throws IOException {
		System.out.println("Would you like to add another course?\n1. Yes\n2. No");
		String selection = in.readLine();
		if (selection.equals("1"))
			addNewCourse();
		else 
			serialize();
	}
	
	public void serialize() throws IOException {
		File file = new File("courses.out");
		if (!file.exists()) {
			File f = new File("courses.out");
			f.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream("courses.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
		fos.close();
	}
	
	public void deserialize() throws ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("courses.out");
			ObjectInputStream ois = new ObjectInputStream(fis);
			courses = (ArrayList<Course>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			courses = new ArrayList<Course>();
		}
	}
}
