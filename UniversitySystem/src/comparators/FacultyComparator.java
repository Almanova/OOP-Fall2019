package comparators;

import java.util.Comparator;

import university.HavingFaculty;

public class FacultyComparator implements Comparator<HavingFaculty> {
	@Override
	public int compare(HavingFaculty o1, HavingFaculty o2) {
		return o1.getFaculty().compareTo(o2.getFaculty());
	}
}
