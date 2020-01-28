package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import data.Attestation;
import data.Course;
import data.Transcript;
import university.Student;

public class CourseStatistics {
	private HashMap<Student, Double> marks;
	
	public CourseStatistics() {
		marks = new HashMap<Student, Double>();
	}
	
	public void fillMarks(Course course) {
		for (Student s: course.getStudents()) {
			for (HashMap.Entry<Course, Attestation> entry : s.getTranscript().getMarks().entrySet()) {
				if (entry.getKey().equals(course)) {
					marks.put(s, Transcript.countMark(entry.getValue()).getNumerical());
					break;
				}
			}
		}
	}
	
	public double determineClassAverage() {
		double sum = 0;
		double avg = 0;
		for (HashMap.Entry<Student, Double> entry : marks.entrySet()) {
			sum += entry.getValue();
		}
		avg = sum / marks.size();
		return avg;
	}
	
	public double determineClassBestGrade() {
		double best = 0;
		for (HashMap.Entry<Student, Double> entry : marks.entrySet()) {
			if (entry.getValue() > best)
				best = entry.getValue();
		}
		return best;
	}
	
	public double determineClassLowestGrade() {
		double worst = 100;
		for (HashMap.Entry<Student, Double> entry : marks.entrySet()) {
			if (entry.getValue() < worst)
				worst = entry.getValue();
		}
		return worst;
	}
	
	public String outputBarChart() {
		ArrayList<Integer> distribution = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 0; i < 11; i++) {
			distribution.add(0);
		}
		for (HashMap.Entry<Student, Double> entry : marks.entrySet()) {
			if (entry.getValue() >= 0 && entry.getValue() < 10) {
				temp = distribution.get(0);
				temp++;
				distribution.set(0, temp);
			}
			else if (entry.getValue() >= 10 && entry.getValue() < 20) {
				temp = distribution.get(1);
				temp++;
				distribution.set(1, temp);
			}
			else if (entry.getValue() >= 20 && entry.getValue() < 30) {
				temp = distribution.get(2);
				temp++;
				distribution.set(2, temp);
			}
			else if (entry.getValue() >= 30 && entry.getValue() < 40) {
				temp = distribution.get(3);
				temp++;
				distribution.set(3, temp);
			}
			else if (entry.getValue() >= 40 && entry.getValue() < 50) {
				temp = distribution.get(4);
				temp++;
				distribution.set(4, temp);
			}
			else if (entry.getValue() >= 50 && entry.getValue() < 60) {
				temp = distribution.get(5);
				temp++;
				distribution.set(5, temp);
			}
			else if (entry.getValue() >= 60 && entry.getValue() < 70) {
				temp = distribution.get(6);
				temp++;
				distribution.set(6, temp);
			}
			else if (entry.getValue() >= 70 && entry.getValue() < 80) {
				temp = distribution.get(7);
				temp++;
				distribution.set(7, temp);
			}
			else if (entry.getValue() >= 80 && entry.getValue() < 90) {
				temp = distribution.get(8);
				temp++;
				distribution.set(8, temp);
			}
			else if (entry.getValue() >= 90 && entry.getValue() < 100) {
				temp = distribution.get(9);
				temp++;
				distribution.set(9, temp);
			}
			else {
				temp = distribution.get(10);
				temp++;
				distribution.set(10, temp);
			}
		}
		String bar = "";
		int l = 0;
		int r = 9;
		for (int i = 0; i < 11; i++) {
			if (i == 0)
				bar += "00-09: ";
			else if (i == 10)
				bar += "100:   ";
			else {
				bar += l + "-";
				bar += r + ": ";
			}
			for (int j = 0; j < distribution.get(i); j++)
				bar += "*";
			bar += "\n";
			l += 10;
			r += 10;
		}
		return bar;
	}
	
	public void displayGradeReport() {
		System.out.println("\nClass average is " + determineClassAverage()
		+ ". Lowest grade is " + determineClassLowestGrade() + ". " +
		"Highest grade is " + determineClassBestGrade() + ". \n");
		System.out.println(outputBarChart());
	}
}
