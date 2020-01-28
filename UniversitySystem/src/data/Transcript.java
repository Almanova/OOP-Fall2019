package data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Transcript implements Serializable {
	private double gpa;
	private HashMap<Course, Attestation> marks;
	
	public Transcript() {
		this.gpa = 0;
		marks = new HashMap<Course, Attestation>();
	}
	
	public HashMap<Course, Attestation> getMarks() {
		return marks;
	}
	
	public static Mark countMark(Attestation a) {
		double points = a.getFirstAtt() + a.getSecondAtt() + a.getFinal();
		return new Mark(points);
	}
	
	public void determineGpa() {
		double creditsum = 0;
		double temp = 0;
		for (HashMap.Entry<Course, Attestation> entry : marks.entrySet()) {
			creditsum += entry.getKey().getNumberOfCredidts();
			temp += countMark(entry.getValue()).getGpa() * entry.getKey().getNumberOfCredidts();
		}
		this.gpa = temp / creditsum;
	}
	
	public String toString() {
		String allmarks = "";
		for (HashMap.Entry<Course, Attestation> entry : marks.entrySet()) {
			allmarks += "\n" + entry.getKey().getName() + "\n1: " + entry.getValue().getFirstAtt() + 
					" 2: " + entry.getValue().getSecondAtt() + " Final: " + entry.getValue().getFinal()
					+ " Mark: " + countMark(entry.getValue()).getLetter();
		}
		determineGpa();
		return "GPA: " + gpa + allmarks;
	}
}
