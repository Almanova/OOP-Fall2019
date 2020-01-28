package task1;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.StringTokenizer;

public class Analysis {
	private ArrayList<Grade> marks;
	private Grade minimum;
	private Grade maximum;
	private Grade average;

	{
		marks = new ArrayList<Grade>();
		minimum = new Grade(100);
		maximum = new Grade(0);
	}

	public ArrayList<Grade> getGrades() {
		return marks;
	}

	public Grade getMaximum() {
		return maximum;
	}

	public Grade getMinimum() {
		return minimum;
	}

	public Grade getAverage() {
		return average;
	}

	public void setAverage(Grade grade) {
		this.average = grade;
	}

	public void readMarks() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("scores.txt"));
			String line, temp;
			while ((line = in.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				temp = tokenizer.nextToken();
				temp = tokenizer.nextToken();
				int numerical = Integer.parseInt(tokenizer.nextToken());
				Grade grade = new Grade(numerical);
				marks.add(grade);
			}
			in.close();
		} catch (IOException ioe) {
			System.out.println("Can't read the file.");
		} catch (NoSuchElementException nsee) {
			System.out.println("Wrong format of an input file.");
		}
	}

	public void doAnalysis() {
		double sum = 0, temp;
		for (int i = 0; i < marks.size(); i++) {
			temp = marks.get(i).getNumerical();
			sum += temp;
			if (temp < minimum.getNumerical())
				minimum.setNumerical(temp);
			if (temp > maximum.getNumerical())
				maximum.setNumerical(temp);
		}
		setAverage(new Grade(sum / marks.size()));
	}

	public void writeMarks() {
		try {
			File file = new File("grades.txt");
			if (!file.exists())
				throw (new FileNotFoundException());
			else {
				PrintWriter pw = new PrintWriter(new FileWriter("grades.txt", true));
				pw.write("Average – " + average.getNumerical() + "\n");
				pw.write("Minimum – " + minimum.getNumerical() + "\n");
				pw.write("Maximum – " + maximum.getNumerical() + "\n");
				pw.close();
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File does not exist in the directory.");
		} catch (IOException ioe) {
			System.out.println("Can't write into the file.");
		}
	}
}
