package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import data.*;
import enumerations.Degree;
import enumerations.YearOfStudy;

public class Student extends User implements HavingFaculty, BookingClass {
	private static final int maxCredits = 21;
	private YearOfStudy yearOfStudy;
	private Degree degree;
	private Faculty faculty;
	private Specialty specialty;
	private Transcript transcript;
	private ArrayList<Course> courses;
	private ArrayList<Attendance> attendance;
	private Schedule schedule;
	
	public Student(String id, String firstName, String lastName, String login, String password,
			YearOfStudy yearOfStudy, Degree degree, Faculty faculty, Specialty specialty) {
		super(id, firstName, lastName, login, password);
		this.yearOfStudy = yearOfStudy;
		this.degree = degree;
		this.faculty = faculty;
		this.specialty = specialty;
		transcript = new Transcript();
		courses = new ArrayList<Course>();
		attendance = new ArrayList<Attendance>();
		schedule = new Schedule();
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public Specialty getSpecialty() {
		return specialty;
	}
	
	public Transcript getTranscript() {
		return transcript;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
	public ArrayList<Course> viewListOfCourses() {
		return courses;
	}
	
	public Transcript viewTranscript() {
		return transcript;
	}
	
	public ArrayList<Attendance> viewAttendance(Course course) {
		ArrayList<Attendance> atten = new ArrayList<Attendance>();
		for (Attendance a: attendance) {
			if (a.getCourse().equals(course))
				atten.add(a);
		}
		return atten;
	}
	
	public boolean rateTeacher(Teacher t, int rate) {
		return t.recieveRating(rate);
	}
	
	public Attestation viewMarks(Course course) {
		Attestation a = null;
		for (HashMap.Entry<Course, Attestation> entry : transcript.getMarks().entrySet()) {
			if (entry.getKey().equals(course)) {
				a = entry.getValue();
				break;
			}
		}
		return a;
	}
	
	public boolean registerForCourse(Course course) throws CreditsOverflowException {
		int credits = 0;
		for (Course c: courses) 
			credits += c.getNumberOfCredidts();
		if (credits + course.getNumberOfCredidts() > maxCredits)
			throw new CreditsOverflowException();
		else {
			transcript.getMarks().put(course, DataModel.createAttestation());
			return courses.add(course) && course.getStudents().add(this);
		}
	}
	
	public void addToScedule(ScheduleCell cell) {
		schedule.addCell(cell);
	}
	
	public void addAttendance(Attendance a) {
		attendance.add(a);
	}
	
	@Override
	public boolean equals(Object object) {
		if (!super.equals(object))
			return false;
		Student student = (Student)object;
		if (this.yearOfStudy == student.yearOfStudy && this.degree == student.degree
				&& this.faculty.equals(student.faculty) && this.specialty.equals(student.specialty)
				&& this.transcript.equals(student.transcript) && this.courses.equals(student.courses))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(yearOfStudy, degree, faculty, transcript, courses);
	}
	
	@Override
	public void updateUser() {
		UserFactory.updateStudent(this);
	}
	
	public String getAllInformation() {
		return toString() + "\n" + yearOfStudy + "\n" + degree + "\n" + faculty + "\n" + specialty; 
	}

	public void userInterface() {
		StudentController sc = new StudentController(this);
		sc.studentUserInterface();
	}
	
	public boolean bookClass(BookingCell cell) {
		cell.setUser(this);
		cell.book();
		return true;
	}
}
