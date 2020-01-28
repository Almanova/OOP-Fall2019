package data;

import java.io.Serializable;
import java.time.LocalDateTime;

import university.UniversitySystem;

public class Score implements Serializable {
	private LocalDateTime time;
	private double points;
	
	public Score(double points) {
		this.points = points;
		this.time = UniversitySystem.getCurrentTime();
	}
	
	public double getPoints() {
		return points;
	}
	
	public String toString() {
		return UniversitySystem.getFormatter().format(time) + " - " + points;
	}
}
