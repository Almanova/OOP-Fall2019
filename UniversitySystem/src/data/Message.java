package data;

import java.io.IOException;
import java.io.Serializable;

import university.UniversitySystem;
import university.User;

public class Message implements Serializable {
	private User from;
	private User to;
	private String text;
	
	public Message(User from, User to, String text) {
		this.from = from;
		this.to = to;
		this.text = text;
	}
	
	public User getFrom() {
		return from;
	}
	
	public User getTo() {
		return to;
	}
	
	public String getText() {
		return text;
	}
	
	public String toString() {
		return "From: " + from + "\nTo: " + to + "\n" + text; 
	}
}
