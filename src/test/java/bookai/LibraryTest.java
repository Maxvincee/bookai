package bookai;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;



class LibraryTest {

	private Library library;
	private Book book1;
	private Book book2;
	private Book book3;

	@BeforeEach
	void setUp() {
		library = new Library();
		book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-0");
		book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0-06-112008-4");
		book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "978-0-7432-7356-5");
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
	}

	@Test
	void testSearchBookByTitleExactMatch() {
		List<Book> result = library.searchBookByTitle("The Catcher in the Rye");
		assertEquals(1, result.size());
		assertEquals(book1, result.get(0));
	}

	@Test
	void testSearchBookByTitlePartialMatch() {
		List<Book> result = library.searchBookByTitle("Mockingbird");
		assertEquals(1, result.size());
		assertEquals(book2, result.get(0));
	}

	@Test
	void testSearchBookByTitleCaseInsensitive() {
		List<Book> result = library.searchBookByTitle("the great gatsby");
		assertEquals(1, result.size());
		assertEquals(book3, result.get(0));
	}

	@Test
	void testSearchBookByTitleNoMatch() {
		List<Book> result = library.searchBookByTitle("Moby Dick");
		assertTrue(result.isEmpty());
	}

	@Test
	void testSearchBookByTitleMultipleMatches() {
		library.addBook(new Book("The Great Adventures", "Author", 2000, "123-456-789"));
		List<Book> result = library.searchBookByTitle("Great");
		assertEquals(2, result.size());
		assertTrue(result.contains(book3));
	}
}























































