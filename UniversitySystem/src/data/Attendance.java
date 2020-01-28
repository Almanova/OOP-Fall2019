package data;

import java.io.Serializable;
import java.time.LocalDateTime;

import university.*;

public class Attendance implements Serializable {
	private LocalDateTime time;
	private Course course;
	private boolean attended;
	
	protected Attendance(Course course, boolean attended) {
		this.time = UniversitySystem.getCurrentTime();
		this.course = course;
		this.attended = attended;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public boolean getAttended() {
		return attended;
	}
	
	public String toString() {
		String a;
		if (attended)
			a = "Attended";
		else
			a = "Absent";
		return UniversitySystem.getFormatter().format(time) + ", " + course.getName() + " - " + a;
	}
}
