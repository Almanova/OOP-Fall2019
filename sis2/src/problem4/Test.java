package problem4;

import problem4.Time;

public class Test {
	public static <E> void main(String []args) {
		Chocolate[] chocolates = new Chocolate[5];
		chocolates[0] = new Chocolate("Sneakers", 80);
		chocolates[1] = new Chocolate("Mars", 60);
		chocolates[2] = new Chocolate("Milka", 110);
		chocolates[3] = new Chocolate("KitKat", 50);
		chocolates[4] = new Chocolate("Toblerone", 200);
		print(chocolates);
		System.out.println("\nSorted:");
		Sort.heapSort(chocolates);
		print(chocolates);
		System.out.println("\n");
		Time[] time = new Time[3];
		time[0] = new Time(17, 26, 3);
		time[1] = new Time(16, 26, 3);
		time[2] = new Time(16, 26, 4);
		print(time);
		System.out.println("\nSorted:");
		Sort.mergeSort(time);
		print(time);
	}
	
	public static <E> void print(E[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
