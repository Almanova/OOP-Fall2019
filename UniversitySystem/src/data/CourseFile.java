package data;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import university.UniversitySystem;

public class CourseFile implements Serializable {
	private String name;
	private File file;
	
	protected CourseFile(String name, String path) {
		this.name = name;
		this.file = new File(path);
	}
	
	public String getName() {
		return name;
	}
	
	public File getFile() {
		return file;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if ( ! (object instanceof CourseFile))
			return false;
		CourseFile courseFile = (CourseFile)object;
		if (this.name.equals(courseFile.name) && this.file.equals(courseFile.file))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, file);
	}
	
	public String toString() {
		return "File Name: " + name;
	}
}
