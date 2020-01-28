package lab1;

import java.util.Scanner;

public class problem3 {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int score;
		String grade = "";
		System.out.print("Enter your score: ");
		score = input.nextInt();
		if (score >= 95 && score <= 100)
			grade = "A";
		else if (score < 95 && score >= 90)
			grade = "A-";
		else if (score < 90 && score >= 85)
			grade = "B+";
		else if (score < 85 && score >= 80)
			grade = "B";
		else if (score < 80 && score >= 75)
			grade = "B-";
		else if (score < 75 && score >= 70)
			grade = "C+";
		else if (score < 70 && score >= 65)
			grade = "C";
		else if (score < 65 && score >= 60)
			grade = "C-";
		else if (score < 60 && score >= 55)
			grade = "D+";
		else if (score < 55 && score >= 50)
			grade = "D";
		else if (score < 50)
			grade = "F";
		System.out.println("The grade is " + grade);
	}
}
