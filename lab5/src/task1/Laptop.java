package task1;

import java.util.ArrayList;

public class Laptop {
	private ArrayList<Application> applications;
	
	public Laptop(ArrayList<Application> applications) {
		this.applications = applications;
	}
	
	public ArrayList<Application> getApplications() {
		return applications;
	}
	
	public void setApplications(ArrayList<Application> applications) {
		this.applications = applications;
	}
	
	public void getCodeEditors() {
		System.out.println("Code Editors:");
		for (int i = 0; i < applications.size(); i++)
			if (applications.get(i) instanceof CodeEditor)
				System.out.println(applications.get(i));
	}
	
	public void getViewables() {
		System.out.println("Applications to open text files:");
		for (int i = 0; i < applications.size(); i++)
			if (applications.get(i) instanceof Viewable)
				System.out.println(applications.get(i));
	}
	
	public void getAllApplications() {
		System.out.println("All applications:");
		for (int i = 0; i < applications.size(); i++)
			if (applications.get(i) instanceof Application) {
				System.out.println(applications.get(i));
				applications.get(i).installApplication();
				applications.get(i).runApplication();
				applications.get(i).closeApplication();
			}
	}
}
