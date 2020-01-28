package lab1;

import java.util.Scanner;
import java.lang.Math;

public class problem4 {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int a, b, c;
		double x, y;
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		int d = b * b - 4 * a * c;
		System.out.println(d);
		if (d < 0) {
			System.out.println("No solution");
		}
		else if (d == 0) {
			x = (-1 * b) / 2 * a;
			System.out.println("Equation has only one root: " + x);
		}
		else if (d > 0) {
			x = ((-1 * b) + Math.sqrt(d)) / (2 * a);
			y = ((-1 * b) - Math.sqrt(d)) / (2 * a);
			System.out.println("Equation has two roots: " + x + " and " + y);
		}
	}
}
