package task2;

import java.util.Objects;
import java.io.*;

public class Course implements Serializable {
	private String courseTitle;
	private Textbook textbook;
	private Instructor instructor;
	
	public Course(String courseTitle, String isbn, String title, String[] authors,
			String firstName, String lastName, String department, String email) {
		this.courseTitle = courseTitle;
		this.textbook = new Textbook(isbn, title, authors);
		this.instructor = new Instructor(firstName, lastName, department, email);
	}
	
	public String getCourseTitle() {
		return courseTitle;
	}
	
	public Textbook getTextbook() {
		return textbook;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public String toString() {
		return courseTitle + "\n\n" + textbook.toString() + "\n" +
				instructor.toString();
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if (!(object instanceof Course))
			return false;
		Course course = (Course)object;
		return this.courseTitle.equals(course.courseTitle) && 
				this.textbook.equals(course.textbook) &&
				this.instructor.equals(course.instructor);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courseTitle, textbook, instructor);
	}
}
