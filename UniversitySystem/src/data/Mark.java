package data;

import java.io.Serializable;

public class Mark implements Serializable {
	private double numerical;
	private String letter;
	private double gpa;
	
	public Mark(double numerical) {
		this.numerical = numerical;
		determineLetter();
	}
	
	public double getNumerical() {
		return numerical;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setNumerical(double numerical) {
		this.numerical = numerical;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public void determineLetter() {
		String[] letters = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D"};
		double[] gpa = {4.0, 3.67, 3.33, 3.0, 2.67, 2.33, 2.0, 1.67, 1.33, 1.0};
		int[] scores = {95, 90, 85, 80, 75, 70, 65, 60, 55, 50};
		String foundLetter = null; 
		double foundGpa = 0;
		for (int i = 0; i < scores.length; i++) {
			if (this.numerical >= scores[i]) {
				foundLetter = letters[i];
				foundGpa = gpa[i];
				break;
			}
		}
		if (foundLetter.equals(null)) 
			foundLetter = "F";
		this.letter = foundLetter;
		this.gpa = foundGpa;
	}
}
