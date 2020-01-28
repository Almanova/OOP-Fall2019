package task1;

import java.util.ArrayList;

public class SublimeText extends CodeEditor {
	
	public SublimeText(String name, double size, ArrayList<String> supportedOperatingSystems,
			ArrayList<String> supportedProgrammingLanguages) {
		super(name, size, supportedOperatingSystems, supportedProgrammingLanguages);
	}
	
	public void syntaxHighlighting() {
		System.out.println("Your Sublime Text code is colorful now!");
	}
	
	public void installApplication() {
		System.out.println("Sublime Text implementation of an installApplication...");
	}
}
