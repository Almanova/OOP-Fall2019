package problem2;

import java.util.Scanner;
import problem1.Student;

public class GradeBookTest {
	GradeBook gradebook;
	
	public GradeBookTest(GradeBook gradebook) {
		this.gradebook = gradebook;
	}
	
	public void testTheGradeBook() {
		int temp = 0;
		Scanner input = new Scanner(System.in);
		gradebook.displayMessage();
		for (int i = 0; i < gradebook.students.size(); i++) {
			System.out.print("Student " + gradebook.students.get(i).getName() + ": ");
			temp = input.nextInt();
			gradebook.addGrade(gradebook.students.get(i), temp);
		}
		gradebook.displayGradeReport();
		System.out.println(gradebook.toString());
	}
	
	public static void main(String []args) {
		Course course = new Course("CS101", "Object-Oriented Programming and Design", 3);
		GradeBook gradebook = new GradeBook(course);
		Student student = null;
		String names = "ABCDEFGHIJ";
		for (int i = 0; i < 10; i++) {
			student = new Student(Character.toString(names.charAt(i)), (i + 1) + "");
			gradebook.addStudent(student);
		}
		GradeBookTest gradebooktest = new GradeBookTest(gradebook);
		gradebooktest.testTheGradeBook();
	}
}
