package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Attestation implements Serializable {
	private ArrayList<Score> firstAttScores;
	private ArrayList<Score> secondAttScores;
	private double firstAtt;
	private double secondAtt;
	private Score finals;
	
	public Attestation() {
		this.firstAttScores = new ArrayList<Score>();
		this.secondAttScores = new ArrayList<Score>();
		this.firstAtt = 0;
		this.secondAtt = 0;
		this.finals = new Score(0);
	}
	
	public ArrayList<Score> getFirstAttScores() {
		return firstAttScores;
	}
	
	public ArrayList<Score> getSecondAttScores() {
		return secondAttScores;
	}
	
	public double getFirstAtt() {
		return firstAtt;
	}
	
	public double getSecondAtt() {
		return secondAtt;
	}
	
	public double getFinal() {
		return finals.getPoints();
	}
	
	public void addMarkToFirst(Score score) {
		firstAttScores.add(score);
		firstAtt += score.getPoints();
	}
	
	public void addMarkToSecond(Score score) {
		secondAttScores.add(score);
		secondAtt += score.getPoints();
	}
	
	public void setFinals(Score score) {
		this.finals = score;
	}
	
	public String toString() {
		String firstatt = "";
		for (Score s: firstAttScores)
			firstatt += "\n" + s.toString();
		String secondatt = "";
		for (Score s: secondAttScores)
			secondatt += "\n" + s.toString();
		return "Marks of First Attestation:" + firstatt + "\nMarks of Second Attestation:" +
					secondatt + "\nFinal: " + finals.getPoints(); 
	}
}
