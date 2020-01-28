package task1;

import java.io.*;

public class Test {
	public static void main(String []args) throws IOException {
		Gradebook gradebook = new Gradebook();
		gradebook.readGrades();
		gradebook.determineAllLetters();
		gradebook.writeGrades();
		Analysis analysis = new Analysis();
		analysis.readMarks();
		analysis.doAnalysis();
		analysis.writeMarks();
	}
}