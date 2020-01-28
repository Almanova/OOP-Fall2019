package task1;

import java.util.ArrayList;

public class VisualStudioCode extends CodeEditor {
	
	public VisualStudioCode(String name, double size, ArrayList<String> supportedOperatingSystems,
			ArrayList<String> supportedProgrammingLanguages) {
		super(name, size, supportedOperatingSystems, supportedProgrammingLanguages);
	}
	
	public void syntaxHighlighting() {
		System.out.println("Your Visual Studio Code code is colorful now!");
	}
	
	public void embeddedVersionControl() {
		System.out.println("Implementing embedded version control...");
	}
	
	public void installApplication() {
		System.out.println("Visual Studio Code implementation of an installApplication...");
	}
}
