package problem2;

import problem1.Student;
import java.util.ArrayList;
import java.util.HashMap;

public class GradeBook {
	Course course;
	ArrayList<Student> students;
	HashMap<Student, Integer> grades;
	
	public GradeBook(Course course) {
		this.course = course;
		students = new ArrayList<Student>();
		grades = new HashMap<Student, Integer>();
	}
	
	public GradeBook() {
		this.course = null;
		students = new ArrayList<Student>();
		grades = new HashMap<Student, Integer>();
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void displayMessage() {
		System.out.println("Welcome to the grade book for " + course.toString()
				+ "!\n\nPlease, input grades for students:\n");
	}
	
	public void addGrade(Student student, int grade) {
		grades.put(student, grade);
	}
	
	public double determineClassAverage() {
		double sum = 0;
		double avg = 0;
		for (HashMap.Entry<Student, Integer> entry : grades.entrySet()) {
			sum += entry.getValue();
		}
		avg = sum / grades.size();
		return avg;
	}
	
	public Grade determineClassBestGrade() {
		int best = 0;
		Student student = null;
		for (HashMap.Entry<Student, Integer> entry : grades.entrySet()) {
			if (entry.getValue() > best) {
				best = entry.getValue();
				student = entry.getKey();
			}
		}
		Grade grade = new Grade(student, best);
		return grade;
	}
	
	public Grade determineClassLowestGrade() {
		int worst = 100;
		Student student = null;
		for (HashMap.Entry<Student, Integer> entry : grades.entrySet()) {
			if (entry.getValue() < worst) {
				worst = entry.getValue();
				student = entry.getKey();
			}
		}
		Grade grade = new Grade(student, worst);
		return grade;
	}
	
	public String outputBarChart() {
		ArrayList<Integer> distribution = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 0; i < 11; i++) {
			distribution.add(0);
		}
		for (HashMap.Entry<Student, Integer> entry : grades.entrySet()) {
			if (entry.getValue() >= 0 && entry.getValue() < 10) {
				temp = distribution.get(0);
				temp++;
				distribution.set(0, temp);
			}
			else if (entry.getValue() >= 10 && entry.getValue() < 20) {
				temp = distribution.get(1);
				temp++;
				distribution.set(1, temp);
			}
			else if (entry.getValue() >= 20 && entry.getValue() < 30) {
				temp = distribution.get(2);
				temp++;
				distribution.set(2, temp);
			}
			else if (entry.getValue() >= 30 && entry.getValue() < 40) {
				temp = distribution.get(3);
				temp++;
				distribution.set(3, temp);
			}
			else if (entry.getValue() >= 40 && entry.getValue() < 50) {
				temp = distribution.get(4);
				temp++;
				distribution.set(4, temp);
			}
			else if (entry.getValue() >= 50 && entry.getValue() < 60) {
				temp = distribution.get(5);
				temp++;
				distribution.set(5, temp);
			}
			else if (entry.getValue() >= 60 && entry.getValue() < 70) {
				temp = distribution.get(6);
				temp++;
				distribution.set(6, temp);
			}
			else if (entry.getValue() >= 70 && entry.getValue() < 80) {
				temp = distribution.get(7);
				temp++;
				distribution.set(7, temp);
			}
			else if (entry.getValue() >= 80 && entry.getValue() < 90) {
				temp = distribution.get(8);
				temp++;
				distribution.set(8, temp);
			}
			else if (entry.getValue() >= 90 && entry.getValue() < 100) {
				temp = distribution.get(9);
				temp++;
				distribution.set(9, temp);
			}
			else {
				temp = distribution.get(10);
				temp++;
				distribution.set(10, temp);
			}
		}
		String bar = "";
		int l = 0;
		int r = 9;
		for (int i = 0; i < 11; i++) {
			if (i == 0)
				bar += "00-09: ";
			else if (i == 10)
				bar += "100:   ";
			else {
				bar += l + "-";
				bar += r + ": ";
			}
			for (int j = 0; j < distribution.get(i); j++)
				bar += "*";
			bar += "\n";
			l += 10;
			r += 10;
		}
		return bar;
	}
	
	public String toString() {
		String s = "Available grades for " + course.toString() + ":\n";
		for (Student st: students) {
			s += st.toString() + " - ";
			s += grades.get(st).toString() + "\n";
		}
		/*for (HashMap.Entry<Student, Integer> entry : grades.entrySet()) {
			s += entry.getKey().toString() + ": ";
			s += entry.getValue().toString() + "\n";
		}*/
		return s;
	}
	
	public void displayGradeReport() {
		System.out.println("\nClass average is " + determineClassAverage()
		+ ". Lowest grade is " + determineClassLowestGrade().grade + 
		" (" + determineClassLowestGrade().student.toString() + "). " +
		"Highest grade is " + determineClassBestGrade().grade + " (" +
		determineClassBestGrade().student.toString() + "). \n");
		System.out.println(outputBarChart());
	}
}
