package university;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import data.Course;
import data.Faculty;
import data.News;

public class UniversitySystem {
	private static Data data;
	private static BufferedReader userInput; 
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	
	{
		data = Data.getInstance();
		try {
			data = deserialize("data.out", data);
		} catch (ClassNotFoundException e) {
			printConsole("Error");
		}
	}
	
	public UniversitySystem() {
		userInput = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static Data getData() {
		return data;
	}
	
	public static DateTimeFormatter getFormatter() {
		return dtf;
	}
	
	public static String getConsoleInput() {
		String input = "";
		try {
			input = userInput.readLine();
		} catch (IOException ioe) {
			printConsole("Wrong Format!");
		}
		return input;
	}
	
	public static void printConsole(String s) {
		System.out.println(s);
	}
	
	public static <T> void printList(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++) 
			System.out.println(i + 1 + ". " + list.get(i));
	}
	
	public static LocalDateTime getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();  
		return now;
	}
	
	public static String getCurrentTimeString() {
		LocalDateTime now = LocalDateTime.now();  
		String currenttime = dtf.format(now);
		return currenttime;
	}
	
	public static void printNews(ArrayList<News> news) {
		for (int i = news.size() - 1; i >= 0; i--) {
			printConsole(news.get(i).toString());
		}
	}


	public void startSession(User user) throws IOException {
		String output = getCurrentTimeString() + " User loged in into the system;";
		printToLogFile(output, user.getLogin());
		user.userInterface();
		serialize("data.out", data);
	}
	
	public Data deserialize(String path, Data data) throws ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			data = (Data) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			data = Data.getInstance();
		}
		return data;
	}
	
	public void serialize(String path, Data data) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			File f = new File(path);
			f.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(data);
		oos.close();
		fos.close();
	}
	
	public static void printToLogFile(String output, String login) {
		try {
			String path = login + ".txt"; 
			PrintWriter out = new PrintWriter(new FileWriter(path, true));
			out.write("\n" + output);
			out.close();
		}
		catch (IOException ioe) {
			System.out.println("Error occured...");
		}
	}
}
