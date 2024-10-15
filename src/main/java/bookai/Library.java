package bookai;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private List<LibraryMember> members;

	public Library() {
		this.books = new ArrayList<>();
		this.members = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void addMember(LibraryMember member) {
		members.add(member);
	}

	public List<Book> books() {
		return books;
	}

	public List<LibraryMember> members() {
		return members;

	}

}
