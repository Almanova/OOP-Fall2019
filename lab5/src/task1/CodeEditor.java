package task1;

import java.util.ArrayList;

abstract class CodeEditor implements Viewable, Application {
	private String name;
	private double size;
	private ArrayList<String> supportedOperatingSystems;
	private ArrayList<String> supportedProgrammingLanguages;
	
	public CodeEditor(String name, double size, ArrayList<String> supportedOperatingSystems,
			ArrayList<String> supportedProgrammingLanguages) {
		this.name = name;
		this.size = size;
		this.supportedOperatingSystems = supportedOperatingSystems;
		this.supportedProgrammingLanguages = supportedProgrammingLanguages;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSize() {
		return size;
	}
	
	public ArrayList<String> getSupportedOperatingSystems() {
		return supportedOperatingSystems;
	}
	
	public ArrayList<String> getSupportedProgrammingLanguages() {
		return supportedProgrammingLanguages;
	}
	
	public String toString() {
		return name + " " + size + " MB";
	}
	
	public String autoCompletition(String text) {
		return text + "completition";
	}
	
	abstract void syntaxHighlighting();
	
	public void runApplication() {
		System.out.println("Implementation of a runApplication in a parent class...");
	}
	
	public void closeApplication() {
		System.out.println("Implemetation of a closeApplication in a parent class...");
	}
}
