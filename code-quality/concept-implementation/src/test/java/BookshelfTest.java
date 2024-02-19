import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookshelfTest {

	private  Bookshelf bookshelf;

	@BeforeEach
	void setUp() {
		bookshelf = new Bookshelf();
	}

	@Test
	@DisplayName("add clean code book to bookshelf and the bookshelf should contain clean code book")
	void addCleanCodeBook() {
		// var bookshelf = new Bookshelf();

		bookshelf.addBook(new Book(1, "Clean Code"));

		String actual = bookshelf.findBookById(1).title();
		String expect = "Clean Code";

		assertEquals(expect, actual);
	}

	@Test
	@DisplayName("find book by id 2 should throw BookNotFoundException")
	void findBookId2ShouldThrowException() {
		bookshelf.addBook(new Book(1, "Clean Code"));

		assertThrows(BookNotFoundException.class, ()-> bookshelf.findBookById(2));
	}

	@Test
	@DisplayName("find book by id 2 should return message book not found")
	void throwBookNotFound() {
		bookshelf.addBook(new Book(1, "Clean Code"));

		var exception = assertThrows(BookNotFoundException.class, ()-> bookshelf.findBookById(2));
		String expected = "book not found";

		assertEquals(expected, exception.getMessage());
	}

	@Test
	@DisplayName("given bookshelf empty should throw BookNotFoundException")
	void findBookById1InEmptyBookshelf() {
		// var bookshelf = new Bookshelf();

		assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));
	}

	@Test
	@DisplayName("given bookshelf empty should throw BookNotFoundException with message book not found")
	void findBookById1InEmptyBookshelfExceptionShouldBeBookNotFound() {
		// var bookshelf = new Bookshelf();

		var exception = assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));

		assertEquals("book not found", exception.getMessage());
	}
}
