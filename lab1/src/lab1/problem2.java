package lab1;

import java.util.Scanner;
import java.lang.Math;

public class problem2 {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int side, area, perimeter;
		double diagonal;
		System.out.print("Enter the length of a side of a square: ");
		side = input.nextInt();
		area = side * side;
		perimeter = side * 4;
		diagonal = side * Math.sqrt(2);
		System.out.printf("The area of a square: %d\n", area);
		System.out.printf("The perimeter is %d\n", perimeter);
		System.out.println("Length of a diagonal is " + diagonal);
	}
}
