package university;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import data.*;
import enumerations.TeacherTitle;

public class Teacher extends Employee implements HavingFaculty, BookingClass {
	private TeacherTitle teacherTitle;
	private Faculty faculty;
	private ArrayList<Course> courses;
	private ArrayList<Message> messages;
	private ArrayList<Integer> rating; 
	
	public Teacher(String id, String firstName, String lastName, String login, String password,
			double salary, TeacherTitle teacherTitle, Faculty faculty) {
		super(id, firstName, lastName, login, password, salary);
		this.teacherTitle = teacherTitle;
		this.courses = new ArrayList<Course>();
		this.messages = new ArrayList<Message>();
		this.rating = new ArrayList<Integer>();
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	public void setTeacherTitle(TeacherTitle teacherTitle) {
		this.teacherTitle = teacherTitle;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public boolean recieveMesssage(Message message) {
		return messages.add(message);
	}
	
	public boolean recieveRating(int rate) {
		return rating.add(rate);
	}
	
	public double viewRating() {
		double sum = 0;
		for (double d: rating)
			sum += d;
		return sum / rating.size();
	}
 	
	public void putMark(Course c, Student s, Score score, int att) {
		Attestation a = null;
		for (HashMap.Entry<Course, Attestation> entry : s.getTranscript().getMarks().entrySet()) {
			if (entry.getKey().equals(c)) {
				a = entry.getValue();
				break;
			}
		}
		if (att == 1)
			a.addMarkToFirst(score);
		else if (att == 2)
			a.addMarkToSecond(score);
		else if (att == 3)
			a.setFinals(score);
	}
	
	public void putAttendance(Student s, Attendance a) {
		s.addAttendance(a);
	}
	
	@Override
	public void updateUser() {
		UserFactory.updateTeacher(this);
	}
	
	@Override
	public boolean equals(Object object) {
		if (!super.equals(object))
			return false;
		Teacher teacher = (Teacher)object;
		if (this.teacherTitle == teacher.teacherTitle && /*this.faculty.equals(teacher.faculty)
				&&*/ this.courses.equals(teacher.courses) && this.messages.equals(teacher.messages))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(teacherTitle, faculty, courses, messages);
	}
	
	public String getAllInformation() {
		return toString() + "\n" + teacherTitle + "\n" + faculty; 
	}
	
	public void userInterface() {
		TeacherController tc = new TeacherController(this);
		tc.teacherUserInterface();
	}
	
	public boolean bookClass(BookingCell cell) {
		cell.setUser(this);
		cell.book();
		return true;
	}
}
