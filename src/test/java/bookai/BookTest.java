package bookai;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	@Test
	void testBook() {
		Book book = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-0");
		assertEquals("The Catcher in the Rye", book.title());
		assertEquals("J.D. Salinger", book.author());
		assertEquals(1951, book.year());
		assertEquals("978-0-316-76948-0", book.isbn());
		assertTrue(book.isAvailable());
	}

	@Test
	void testBorrow() {
		Book book = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-0");
		book.borrow();
		assertFalse(book.isAvailable());
	}

	@Test
	void testReturnBook() {
		Book book = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-0");
		book.borrow();
		book.returnBook();
		assertTrue(book.isAvailable());
	}
}
