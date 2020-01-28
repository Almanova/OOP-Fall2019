package data;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import university.Student;
import university.Teacher;
import university.UniversitySystem;

public class Course implements Serializable {
	private String id;
	private String name;
	private int numberOfCredits;
	private Teacher teacher;
	private ArrayList<Student> students;
	private ArrayList<Course> prerequisites;
	private ArrayList<CourseFile> courseFiles;
	private ArrayList<ScheduleCell> cells;
	
	{
		students = new ArrayList<Student>();
		prerequisites = new ArrayList<Course>();
		courseFiles = new ArrayList<CourseFile>();
		cells = new ArrayList<ScheduleCell>();
	}
	
	protected Course(String id, String name, int numberOfCredits) {
		this.id = id;
		this.name = name;
		this.numberOfCredits = numberOfCredits;
		this.teacher = null;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfCredidts() {
		return numberOfCredits;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public ArrayList<ScheduleCell> getCells() {
		return cells;
	}
	
	public void addCell(ScheduleCell cell) {
		cells.add(cell);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}
	
	public ArrayList<CourseFile> getCourseFiles() {
		return courseFiles;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void addPrerequisite(Course prerequisite) {
		prerequisites.add(prerequisite);
	}
	
	public void addCourseFile(CourseFile courseFile) {
		courseFiles.add(courseFile);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if ( ! (object instanceof Course))
			return false;
		Course course = (Course)object;
		if (this.id.equals(course.id) && this.name.equals(course.name) && 
				this.numberOfCredits == course.numberOfCredits && this.prerequisites.equals(course.prerequisites)
				&& this.courseFiles.equals(course.courseFiles))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, numberOfCredits, prerequisites, courseFiles);
	}
	
	public String toString() {
		return "Course Id: " + id + "\nCourse Name: " + name;
	}
}
