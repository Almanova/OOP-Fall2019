package lab1;

import java.util.Scanner;
import java.util.*;

public class bonus {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int Length = input.nextInt();
		int[] Arr = new int[Length];
		for (int i = 0; i < Length; i++) {
			Arr[i] = input.nextInt();
		}
		
        int arra[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
        	arra[i] = 0;
        }

		for (int i = 0; i < Length; i++) {
			arra[Arr[i]]++;
		}
		
		for (int i = 0; i < 1000; i++) {
			if (arra[i] != 0) {
				System.out.println("[" + i + ", " + arra[i] + "]");
			}
		}
	}
}
