package problem2;

import java.util.ArrayList;

public class Course {
	String name;
	String description;
	int credits;
	ArrayList<String> prerequisites;

	public Course(String name, String description, int credits) {
		this.name = name;
		this.description = description;
		this.credits = credits;
		prerequisites = new ArrayList<String>();
	}

	public void addPrerequisites(String prerequisite) {
		prerequisites.add(prerequisite);
	}

	public String toString() {
		return this.name + " " + this.description;
	}
}
