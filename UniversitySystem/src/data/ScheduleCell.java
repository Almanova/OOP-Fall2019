package data;

import java.io.Serializable;
import java.util.Arrays;

import university.*;

public class ScheduleCell implements Serializable {
	private Course course;
	private int dayOfTheWeek;
	private Auditorium auditorium;
	private int hour;
	
	protected ScheduleCell (Course course, int dayOfTheWeek, int hour, Auditorium auditorium) {
		this.course = course;
		this.dayOfTheWeek = dayOfTheWeek;
		this.hour = hour;
		this.auditorium = auditorium;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public int getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	
	public int getHour() {
		return hour;
	}
	
	public String toString() {
		String day = "";
		if (dayOfTheWeek == 1)
			day = "Monday";
		else if (dayOfTheWeek == 2)
			day = "Tuesday";
		else if (dayOfTheWeek == 3)
			day = "Wednesday";
		else if (dayOfTheWeek == 4)
			day = "Thursday";
		else if (dayOfTheWeek == 5)
			day = "Friday";
		else if (dayOfTheWeek == 6)
			day = "Suturday";
		return course.getName() + " - " + day + ", " + hour + ":00" + " - " + (hour + 1) + ":00, " +
						auditorium.getNumber() + ";";
	}
}
