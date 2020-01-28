package university;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import data.Auditorium;
import data.Course;
import data.Faculty;
import data.News;

public final class Data implements Serializable {
	private static final Data INSTANCE = new Data();
	private ArrayList<User> users;
	private ArrayList<Faculty> faculties;
	private ArrayList<Course> courses;
	private ArrayList<Manager> managers;
	private ArrayList<Teacher> teachers;
	private ArrayList<Student> students; 
	private ArrayList<TechSupportGuy> techSupportGuys;
	private ArrayList<News> news;
	private ArrayList<Auditorium> auditoriums;
	
	public Data() {
		users = new ArrayList<User>();
		faculties = new ArrayList<Faculty>();
		courses = new ArrayList<Course>();
		managers = new ArrayList<Manager>();
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		techSupportGuys = new ArrayList<TechSupportGuy>();
		news = new ArrayList<News>();
		auditoriums = new ArrayList<Auditorium>();
	}
	
	public static Data getInstance() {
		return INSTANCE;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public ArrayList<Manager> getManagers() {
		return managers;
	}
	
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public ArrayList<TechSupportGuy> getTechSupportGuys() {
		return techSupportGuys;
	}
	
	public ArrayList<News> getNews() {
		return news;
	}
	
	public ArrayList<Auditorium> getAuditoriums() {
		return auditoriums;
	}
}
