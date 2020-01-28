package data;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import university.UniversitySystem;

public class Specialty implements Serializable, Comparable {
	private String name;
	private ArrayList<Course> courses;
	
	{
		courses = new ArrayList<Course>();
	}
	
	protected Specialty(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void printCourses() {
		for (int i = 0; i < courses.size(); i++)
			System.out.println(i + 1 + ". " + courses.get(i));
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if ( ! (object instanceof Specialty))
			return false;
		Specialty specialty = (Specialty)object;
		if (this.name.equals(specialty.name) && this.courses.equals(specialty.courses))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, courses);
	}
	
	@Override
	public int compareTo(Object object) {
		Specialty specialty = (Specialty)object;
		return name.compareTo(specialty.name);
	}
	
	public String toString() {
		return "Specialty Name: " + name;
	}
}
