package task2;

import java.io.*;
import java.util.Objects;

public class Textbook implements Serializable {
	private String isbn;
	private String title;
	private String[] authors;
	
	public Textbook(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}
	
	public Textbook(String isbn, String title, String[] authors) {
		this(isbn, title);
		this.authors = authors;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String[] getAuthors() {
		return authors;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		String authorslist = "";
		for (int i = 0; i < authors.length; i++)
			authorslist += authors[i] + "\n";
		return "Textbook\n" + isbn + " – «" + title + "»\nAuthors:\n" + authorslist;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null)
			return false;
		if (!(object instanceof Textbook))
			return false;
		Textbook textbook = (Textbook)object;
		return this.isbn.equals(textbook.isbn) && this.title.equals(textbook.title)
				&& this.authors.equals(textbook.authors);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn, title, authors);
	}
}
