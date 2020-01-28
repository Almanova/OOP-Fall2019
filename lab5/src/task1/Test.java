package task1;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> systems = new ArrayList<String>();
		ArrayList<String> languages = new ArrayList<String>();
		SublimeText st = new SublimeText("Sublime Text", 40.3, systems, languages);
		VisualStudioCode vsc = new VisualStudioCode("Visual Studio Code", 63.5, systems, languages);
		Notepad n = new Notepad("Notepad");
		Browser b = new Browser("Google Chrome");
		ArrayList<Application> list = new ArrayList<Application>();
		list.add(st);
		list.add(vsc);
		list.add(n);
		list.add(b);
		Laptop laptop = new Laptop(list);
		laptop.getAllApplications();
		laptop.getViewables();
		laptop.getCodeEditors();
	}
}
