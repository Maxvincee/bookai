package bookai;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
	private String memberId;
	private String name;
	private String email;
	private List<Book> borrowedBooks;

	public LibraryMember(String memberId, String name, String email) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.borrowedBooks = new ArrayList<>();
	}

	public String memberId() {
		return memberId;
	}

	public String name() {
		return name;
	}

	public String email() {
		return email;
	}

	public List<Book> borrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
		book.borrow();
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
		book.returnBook();
	}

}