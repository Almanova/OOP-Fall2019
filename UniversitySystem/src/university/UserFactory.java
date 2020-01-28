package university;

import enumerations.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import data.*;

public class UserFactory {
	private String id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private double salary;
	private TeacherTitle teacherTitle;
	private Faculty faculty;
	private YearOfStudy yearOfStudy;
	private Degree degree;
	private Specialty specialty;
	
	public User optionsForCreation() {
		UniversitySystem.printConsole("What User do you want to create?\n1. Admin" +
				"\n2. Manager\n3. Teacher\n4. TechSupportGuy\n5. Student");
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput());
		if (selection == 1)
			return createAdmin();
		else if (selection == 2)
			return createManager();
		else if (selection == 3)
			return createTeacher();
		else if (selection == 4)
			return createTechSupportGuy();
		else if (selection == 5)
			return createStudent();
		return null;
	}
	
	public static String encryptPassword(String password) {
		String hashed = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			hashed = digest.toString();
		} catch (NoSuchAlgorithmException nsae) {
			UniversitySystem.printConsole("Error");
		}
		return hashed;
	}
	
	private void collectUserInformation() {
		UniversitySystem.printConsole("Enter User id:");
		this.id = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Enter User First Name:");
		this.firstName = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Enter User Last Name:");
		this.lastName = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Enter User login:");
		this.login = UniversitySystem.getConsoleInput();
		UniversitySystem.printConsole("Enter User password:");
		this.password = UniversitySystem.getConsoleInput();
		//password = encryptPassword(password);
	}
	
	private void collectEmployeeInformation() {
		collectUserInformation();
		UniversitySystem.printConsole("Enter Employee salary:");
		this.salary = Double.parseDouble(UniversitySystem.getConsoleInput());
	}
	
	private Admin createAdmin() {
		collectUserInformation();
		return new Admin(id, firstName, lastName, login, password);
	}
	
	private Manager createManager() {
		collectEmployeeInformation();
		return new Manager(id, firstName, lastName, login, password, salary);
	}
	
	private Teacher createTeacher() {
		collectEmployeeInformation();
		this.teacherTitle = selectionOfTeacherTitle();
		this.faculty = selectionOfFaculty();
		return new Teacher(id, firstName, lastName, login, password, salary, teacherTitle, faculty);
	}
	
	public static TeacherTitle selectionOfTeacherTitle() {
		UniversitySystem.printConsole("Choose Teacher title:\n1. Tutor\n2. Lector\n3. Senior Lector" +
				"\n4. Professor");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1"))
			return TeacherTitle.TUTOR;
		else if (selection.equals("2"))
			return TeacherTitle.LECTOR;
		else if (selection.equals("3"))
			return TeacherTitle.SENIOR_LECTOR;
		else if (selection.equals("4"))
			return TeacherTitle.PROFESSOR;
		return null;
	}
	
	private TechSupportGuy createTechSupportGuy() {
		collectEmployeeInformation();
		return new TechSupportGuy(id, firstName, lastName, login, password, salary);
	}
	
	private Student createStudent() {
		collectUserInformation();
		this.yearOfStudy = selectionOfYearOfStudy();
		this.degree = selectionOfDegree();
		this.faculty = selectionOfFaculty();
		this.specialty = selectionOfSpecialty(this.faculty);
		return new Student(id, firstName, lastName, login, password, yearOfStudy, degree,
				faculty, specialty);
	}
	
	public static YearOfStudy selectionOfYearOfStudy() {
		UniversitySystem.printConsole("Choose Year of Study:\n1. First\n2. Second\n3. Senior Third" +
				"\n4. Fourth");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1"))
			return YearOfStudy.FIRST;
		else if (selection.equals("2"))
			return YearOfStudy.SECOND;
		else if (selection.equals("3"))
			return YearOfStudy.THIRD;
		else if (selection.equals("4"))
			return YearOfStudy.FOURTH;
		return null;
	}
	
	public static Degree selectionOfDegree() {
		UniversitySystem.printConsole("Choose Degree:\n1. Bachelor\n2. Master\n3. Doctor");
		String selection = UniversitySystem.getConsoleInput();
		if (selection.equals("1"))
			return Degree.BACHELOR;
		else if (selection.equals("2"))
			return Degree.MASTER;
		else if (selection.equals("3"))
			return Degree.DOCTOR;
		return null;
	}
	
	public static Faculty selectionOfFaculty() {
		UniversitySystem.printConsole("Choose the number of Faculty:");
		UniversitySystem.printList(UniversitySystem.getData().getFaculties());
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return UniversitySystem.getData().getFaculties().get(in);
	}
	
	public static Specialty selectionOfSpecialty(Faculty faculty) {
		UniversitySystem.printConsole("Choose the number of Specialty:");
		faculty.printSpecialties();
		int in = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		return faculty.getSpecialties().get(in);
	}
	
	public static void optionsAlterUserInformation() {
		UniversitySystem.printConsole("Choose the number of field you want to alter:\n1. First Name" +
				"\n2. Last Name");
	}
	
	public static void optionsAlterEmployeeInformation() {
		optionsAlterUserInformation();
		UniversitySystem.printConsole("3. Salary");
	}
	
	public static void optionsAlterTeacherInformation() {
		optionsAlterEmployeeInformation();
		UniversitySystem.printConsole("4. Title\n5. Faculty");
	}
	
	public static void optionsAlterStudentInformation() {
		optionsAlterUserInformation();
		UniversitySystem.printConsole("3. Year of Study\n4. Degree\n5. Faculty\n6. Specialty");
	}
	
	public static void alterFirstName(User user) {
		UniversitySystem.printConsole("Enter First Name:");
		user.setFirstName(UniversitySystem.getConsoleInput());
	}
	
	public static void alterLastName(User user) {
		UniversitySystem.printConsole("Enter Last Name:");
		user.setLastName(UniversitySystem.getConsoleInput());
	}
	
	public static void alterSalary(Employee employee) {
		UniversitySystem.printConsole("Enter Salary:");
		employee.setSalary(Double.parseDouble(UniversitySystem.getConsoleInput()));
	}
	
	public static void alterTeacherTitle(Teacher teacher) {
		teacher.setTeacherTitle(selectionOfTeacherTitle());
	}
	
	public static void alterYearOfStudy(Student student) {
		student.setYearOfStudy(selectionOfYearOfStudy());
	}
	
	public static void alterDegree(Student student) {
		student.setDegree(selectionOfDegree());
	}
	
	public static void alterFaculty(Teacher teacher) throws NumberFormatException {
		teacher.setFaculty(selectionOfFaculty());
	}
	
	public static void alterFaculty(Student student) throws NumberFormatException {
		student.setFaculty(selectionOfFaculty());
	}
	
	public static void alterSpecialty(Student student) throws NumberFormatException {
		student.setSpecialty(selectionOfSpecialty(student.getFaculty()));
	}
	
	public static void updateAdmin(Admin admin) {
		String selection = "";
		while (!selection.equals("Quit")) {
			optionsAlterUserInformation();
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					alterFirstName(admin);
					break;
				case "2":
					alterLastName(admin);
					break;
				case "quit":
					selection = "Quit";
					break;
			}
		}
	}
	
	public static void updateEmployee(Employee employee) {
		String selection = "";
		while (!selection.equals("Quit")) {
			optionsAlterEmployeeInformation();
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					alterFirstName(employee);
					break;
				case "2":
					alterLastName(employee);
					break;
				case "3":
					alterSalary(employee);
					break;
				case "quit":
					selection = "Quit";
					break;
			}
		}
	}
	
	public static void updateTeacher(Teacher teacher) {
		String selection = "";
		while (!selection.equals("Quit")) {
			optionsAlterTeacherInformation();
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					alterFirstName(teacher);
					break;
				case "2":
					alterLastName(teacher);
					break;
				case "3":
					alterSalary(teacher);
					break;
				case "4":
					alterTeacherTitle(teacher);
					break;
				case "5":
					alterFaculty(teacher);
					break;
				case "quit":
					selection = "Quit";
					break;
			}
		}
	}
	
	public static void updateStudent(Student student) {
		String selection = "";
		while (!selection.equals("Quit")) {
			optionsAlterStudentInformation();
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					alterFirstName(student);
					break;
				case "2":
					alterLastName(student);
					break;
				case "3":
					alterYearOfStudy(student);
					break;
				case "4":
					alterDegree(student);
					break;
				case "5":
					alterFaculty(student);
					break;
				case "6":
					alterSpecialty(student);
					break;
				case "quit":
					selection = "Quit";
					break;
			}
		}
	}
 }
