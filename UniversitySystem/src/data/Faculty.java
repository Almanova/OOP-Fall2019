package data;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import university.UniversitySystem;

public class Faculty implements Serializable, Comparable {
	private String name;
	private ArrayList<Specialty> specialties;
	
	{
		specialties = new ArrayList<Specialty>();
	}
	
	protected Faculty(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Specialty> getSpecialties() {
		return specialties;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addSpecialty(Specialty specialty) {
		specialties.add(specialty);
	}
	
	public void printSpecialties() {
		for (int i = 0; i < specialties.size(); i++)
			System.out.println(i + 1 + ". " + specialties.get(i));
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if ( ! (object instanceof Faculty))
			return false;
		Faculty faculty = (Faculty)object;
		if (this.name.equals(faculty.name) && this.specialties.equals(faculty.specialties))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, specialties);
	}
	
	@Override
	public int compareTo(Object object) {
		Faculty faculty = (Faculty)object;
		return name.compareTo(faculty.name);
	}
	
	public String toString() {
		return "Faculty Name: " + name;
	}
}
