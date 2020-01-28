package problem4;

import java.util.Vector;

public class MinHeap<T extends Comparable<T>> {
	private Vector<T> a;
	private int size;
	
	public MinHeap() {
		a = new Vector<T>();
		this.size = 0;
	}
	
	int parent(int i) {
		return (i - 1) / 2;
	}
	
	int left(int i) {
		return 2 * i + 1;
	}
	
	int right(int i) {
		return 2 * i + 2;
	}
	
	void insert(T t) {
		a.add(t);
		size++;
		int i = size - 1;
		while (i > 0 && a.get(parent(i)).compareTo(a.get(i)) > 0) {
			Sort.swap(a, parent(i), (i));
			i = parent(i);
		}
	}
	
	void heapify(int i) {
		if (left(i) > size - 1)
			return;
		int j = left(i);
		if (right(i) < size && a.get(j).compareTo(a.get(right(i))) > 0)
			j = right(i);
		if (a.get(i).compareTo(a.get(j)) > 0) {
			Sort.swap(a, i, j);
			heapify(j);
		}
	}
	
	T extractMin() {
		T root_value = a.get(0);
		Sort.swap(a, 0, size - 1);
		a.remove(size - 1);
		size--;
		heapify(0);
		return root_value;
	}
}
