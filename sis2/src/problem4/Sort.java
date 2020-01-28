package problem4;

import java.util.ArrayList;
import java.util.Vector;

public class Sort {
	static <E> void swap(E[] array, int i, int j) {
		E e = array[i];
		array[i] = array[j];
		array[j] = e;
	}
	
	static <T> void swap(Vector<T> v, int i, int j) {
		T t = v.get(i);
		v.set(i, v.get(j));
		v.set(j, t);
	}
	
	static <E extends Comparable<E>> void mergeSort(E[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	static <E extends Comparable<E>> void mergeSort(E[] array, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(array, l, m);
			mergeSort(array, m + 1, r);
			merge(array, l, m, r);
		}
	}
	
	static <E extends Comparable<E>> void merge(E[] array, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		ArrayList<E> L = new ArrayList<E>(); 
		ArrayList<E> R = new ArrayList<E>();
		for (int i = 0; i < n1; i++)
			L.add(array[l + i]);
		for (int i = 0; i < n2; i++)
			R.add(array[m + i + 1]);
		int p1 = 0, p2 = 0, k = l;
		while (p1 < n1 && p2 < n2) {
			if (L.get(p1).compareTo(R.get(p2)) <= 0) {
				array[k] = L.get(p1);
				p1++;
			}
			else {
				array[k] = R.get(p2);
				p2++;
			}
			k++;
		}
		while (p1 < n1) {
			array[k] = L.get(p1);
			p1++;
			k++;
		}
		while (p2 < n2) {
			array[k] = R.get(p2);
			p2++;
			k++;
		}
	}
	
	static <T extends Comparable<T>> void heapSort(T[] array) {
		MinHeap<T> minHeap = new MinHeap<T>();
		for (int i = 0; i < array.length; i++) 
			minHeap.insert(array[i]);
		for (int i = 0; i < array.length; i++)
			array[i] = minHeap.extractMin();
	}
}
