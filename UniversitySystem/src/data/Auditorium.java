package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Auditorium implements Serializable {
	private int number;
	private ArrayList<BookingCell> bookingCells;
	
	public Auditorium(int number) {
		this.number = number;
		bookingCells = new ArrayList<BookingCell>();
	}
	
	public int getNumber() {
		return number;
	}
	
	public void addBookingCells(BookingCell cell) {
		bookingCells.add(cell);
	}
	
	public ArrayList<BookingCell> getBookingCells() {
		return bookingCells;
	}
	
	public String toString() {
		return "Auditorium: " + number;
	}
}
