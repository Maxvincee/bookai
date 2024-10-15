package bookai;

public class Book {
	private String title;
	private String author;
	private int year;
	private String isbn;
	private boolean isAvailable;

	public Book(String title, String author, int year, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.isAvailable = true;
	}

	public String title() {
		return title;
	}

	public String author() {
		return author;
	}

	public int year() {
		return year;
	}

	public String isbn() {
		return isbn;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void borrow() {
		isAvailable = false;
	}

	public void returnBook() {
		isAvailable = true;
	}

}