package data;

import java.io.Serializable;
import java.time.LocalDateTime;

import university.BookingClass;
import university.UniversitySystem;

public class BookingCell implements Serializable {
	private BookingClass user;
	private boolean booked;
	private int time;
	
	public BookingCell(int time) {
		this.user = null;
		this.booked = false;
		this.time = time;
	}
	
	public void setUser(BookingClass user) {
		this.user = user;
	}
	
	public void book() {
		this.booked = true;
	}
	
	public String toString() {
		String b = "";
		if (booked) 
			b = "Occupied";
		else
			b = "Available";
		return user + "\n" + b + "\nTime: " + time + ":00";
	}
}
