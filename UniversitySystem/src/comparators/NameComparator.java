package comparators;

import java.util.Comparator;

import university.User;

public class NameComparator implements Comparator<User> {
	@Override
	public int compare(User o1, User o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}
}
