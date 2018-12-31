package com.test.cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.test.service.BookService;

class BookServicesTest {

	@Test
	void testCanGetLocatorCode() {
		String isbn = "0140177396";
		BookService bookService = new BookService();
		String locatorCode = bookService.getLocatorCode(isbn);
		assertEquals("739634", locatorCode);
	}

}
