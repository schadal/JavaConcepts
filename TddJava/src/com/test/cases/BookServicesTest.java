package com.test.cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ext.model.Book;
import com.ext.services.ExternalBookDetailsService;
import com.test.service.BookService;

class BookServicesTest {

	@Test
	void testCanGetLocatorCode() {
		
		ExternalBookDetailsService externalService = 
				new ExternalBookDetailsService() {
			
			public Book lookup(String isbn) {
				return new Book(isbn, "Of Mice and Men","Stenbook");
			}
		};
				
		String isbn = "0140177396";
		BookService bookService = new BookService();
		bookService.setService(externalService);
		String locatorCode = bookService.getLocatorCode(isbn);
		assertEquals("739634", locatorCode);
	}

}
