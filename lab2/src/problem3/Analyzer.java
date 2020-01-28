package problem3;

import java.util.Scanner;

public class Analyzer {
	Data data;
	
	public Analyzer() {
		data = new Data();
	}
	
	public void startAnalyzer() {
		String temp = "";
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Enter number (Q to quit): ");
			temp = input.nextLine();
			if (temp.equals("Q"))
				break;
			else
				data.getValue(Double.parseDouble(temp));
		}
		System.out.println("Average = " + data.getAverage());
		System.out.println("Maximum = " + data.getMaximum());
	}
}
