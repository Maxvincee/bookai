package bookai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<Book> searchBookByTitle(String title) {
		return books.stream()
			.filter(book -> book.title().toLowerCase().contains(title.toLowerCase()))
			.collect(Collectors.toList());
	}

	public List<Book> sortBooksByYearThenAuthor() {
		return books.stream()
			.sorted((b1, b2) -> {
				if (b1.year() != b2.year()) {
					return b1.year() - b2.year();
				}
				return b1.author().compareTo(b2.author());
			})
			.collect(Collectors.toList());
	}

	public List<Book> searchBookByKeyword(String keyword) {
		return books.stream()
			.filter(book -> book.title().toLowerCase().contains(keyword.toLowerCase()) || book.author().toLowerCase().contains(keyword.toLowerCase()))
			.collect(Collectors.toList());
	}
}
