package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class bonus2 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner inside = new Scanner(new File("C:\\Users\\Madina\\Desktop\\Third Semester\\OOP\\labs\\lab1\\src\\lab1\\input.txt"));
		ArrayList<String> dictionary = new ArrayList<String>();
		while(inside.hasNextLine()) {
			dictionary.add(inside.nextLine());
		}
		inside.close();
		System.out.println(Arrays.toString(dictionary.toArray()));
	}
}
