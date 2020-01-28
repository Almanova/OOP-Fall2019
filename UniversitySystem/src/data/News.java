package data;

import java.io.Serializable;
import java.time.LocalDateTime;

import university.UniversitySystem;

public class News implements Serializable {
	private String subject;
	private String text;
	private LocalDateTime time;
	
	public News(String subject, String text) {
		this.subject = subject;
		this.text = text;
		this.time = UniversitySystem.getCurrentTime();
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getText() {
		return text;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public String toString() {
		return subject + "\n" + text + "\n" + UniversitySystem.getFormatter().format(time);
	}
}
