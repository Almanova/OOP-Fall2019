package task3;

public interface MyCollection {
	
	void add(Object object);
	
	void clear();
	
	boolean contains(Object object);
	
	boolean equals(Object object);
	
	int hashCode();
	
	boolean isEmpty();
	
	void remove(Object object);
	
	int size();
}
