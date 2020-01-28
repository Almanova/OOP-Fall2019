package lab1;

import java.util.Scanner;

public class problem6 {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if (IsPalindrome(str))
			System.out.println("Input string is a Palindrome");
		else
			System.out.println("Input string is not a Palindrome");
	}
	
	public static boolean IsPalindrome(String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		return s.equals(reverse);
	}
}
