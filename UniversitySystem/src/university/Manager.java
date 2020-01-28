package university;

import java.io.IOException;
import java.util.ArrayList;

import data.Course;
import data.DataModel;
import data.Faculty;
import data.Message;
import data.News;
import data.ScheduleCell;
import data.Specialty;

public class Manager extends Employee {
	
	public Manager(String id, String firstName, String lastName, String login, String password,
			double salary) {
		super(id, firstName, lastName, login, password, salary);
	}
	
	public boolean addCourse(Course course) {
		return UniversitySystem.getData().getCourses().add(course);
	}
	
	public boolean addCourseForRegistration(Specialty specialty, Course course) {
		specialty.addCourse(course);
		return true;
	}
	
	public void assignTeacher(Course course, Teacher teacher) {
		course.setTeacher(teacher);
		teacher.getCourses().add(course);
	}
	
	public String viewTeacherInformation(Teacher teacher) {
		return teacher.getAllInformation();
	}
	
	public String viewStudentInformation(Student student) {
		return student.getAllInformation();
	}
	
	public boolean addNewFaculty(Faculty faculty) {
		return UniversitySystem.getData().getFaculties().add(faculty);
	}

	public void updateFaculty(Faculty faculty) {
		DataModel.updateFaculty(faculty);
	}
	
	public boolean addNews(News news) {
		return UniversitySystem.getData().getNews().add(news);
	}
	
	public boolean sendMessageToTeacher(Teacher teacher, Message message) {
		return teacher.recieveMesssage(message);
	}
	
	public void addScheduleCell(Course course, ScheduleCell cell) {
		course.addCell(cell);
	}
	
	@Override 
	public boolean equals(Object object) {
		return super.equals(object);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public void userInterface() {
		ManagerController mc = new ManagerController(this);
		mc.managerUserInterface();
	}

	@Override
	public void updateUser() {
		UserFactory.updateEmployee(this);
	}
}
