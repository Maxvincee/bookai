package bookai;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;



class LibraryMemberTest {

	private LibraryMember member;
	private Book book;

	@BeforeEach
	void setUp() {
		member = new LibraryMember("123", "John Doe", "john.doe@example.com");
		book = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-0");
	}

	@Test
	void testLibraryMemberConstructor() {
		assertEquals("123", member.memberId());
		assertEquals("John Doe", member.name());
		assertEquals("john.doe@example.com", member.email());
		assertTrue(member.borrowedBooks().isEmpty());
	}

	@Test
	void testBorrowBook() {
		member.borrowBook(book);
		List<Book> borrowedBooks = member.borrowedBooks();
		assertEquals(1, borrowedBooks.size());
		assertEquals(book, borrowedBooks.get(0));
		assertFalse(book.isAvailable());
	}

	@Test
	void testReturnBook() {
		member.borrowBook(book);
		member.returnBook(book);
		List<Book> borrowedBooks = member.borrowedBooks();
		assertTrue(borrowedBooks.isEmpty());
		assertTrue(book.isAvailable());
	}

	@Test
	void testBorrowMultipleBooks() {
		Book anotherBook = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0-06-112008-4");
		member.borrowBook(book);
		member.borrowBook(anotherBook);
		List<Book> borrowedBooks = member.borrowedBooks();
		assertEquals(2, borrowedBooks.size());
		assertTrue(borrowedBooks.contains(book));
		assertTrue(borrowedBooks.contains(anotherBook));
	}

	@Test
	void testReturnOneOfMultipleBooks() {
		Book anotherBook = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0-06-112008-4");
		member.borrowBook(book);
		member.borrowBook(anotherBook);
		member.returnBook(book);
		List<Book> borrowedBooks = member.borrowedBooks();
		assertEquals(1, borrowedBooks.size());
		assertFalse(borrowedBooks.contains(book));
		assertTrue(borrowedBooks.contains(anotherBook));
		assertTrue(book.isAvailable());
		assertFalse(anotherBook.isAvailable());
	}
}