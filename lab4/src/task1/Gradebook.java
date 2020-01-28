package task1;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.io.*;

public class Gradebook {
	private HashMap<Student, Grade> grades;

	{
		grades = new HashMap<Student, Grade>();
	}

	public HashMap<Student, Grade> getGrades() {
		return grades;
	}

	public void readGrades() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("scores.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				String firstname = tokenizer.nextToken();
				String lastname = tokenizer.nextToken();
				double numerical = Integer.parseInt(tokenizer.nextToken());
				Student student = new Student(firstname, lastname);
				Grade grade = new Grade(numerical);
				grades.put(student, grade);
			}
			in.close();
		} catch (IOException ioe) {
			System.out.println("Can't read the file.");
		} catch (NoSuchElementException nsee) {
			System.out.println("Wrong format of input file.");
		}
	}

	public Grade getBestGrade() {
		Grade best = new Grade(0);
		for (HashMap.Entry<Student, Grade> entry : grades.entrySet()) {
			if (entry.getValue().getNumerical() > best.getNumerical()) {
				best.setNumerical(entry.getValue().getNumerical());
			}
		}
		return best;
	}

	public void determineAllLetters() {
		Grade best = getBestGrade();
		for (HashMap.Entry<Student, Grade> entry : grades.entrySet()) {
			entry.getValue().determineLetter(best);
		}
	}

	public void writeGrades() throws IOException {
		//File file = new File("grades.txt");
		//if (file.exists())
			//file.delete();
		//File f = new File("grades.txt");
		//f.createNewFile();
		PrintWriter pw = new PrintWriter(new FileWriter("grades.txt"));
		int cnt = 1;
		for (HashMap.Entry<Student, Grade> entry : grades.entrySet()) {
			String output = cnt + ") " + entry.getKey().toString() + " – «" + entry.getValue().getLetter() + "»";
			pw.write(output + "\n");
			cnt++;
		}
		pw.close();
	}
}
