package com.test.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ext.model.Book;
import com.ext.services.ExternalBookDetailsService;
import com.test.service.BookService;

class BookServicesTest {

	ExternalBookDetailsService testDatabaseService;
	ExternalBookDetailsService testWebService;
	BookService bookService;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup initialize");

		testDatabaseService = mock(ExternalBookDetailsService.class);
		testWebService = mock(ExternalBookDetailsService.class);

		bookService = new BookService();
		bookService.setWebService(testWebService);
		bookService.setDatabaseService(testDatabaseService);
	}

	@Test
	void testCanGetLocatorCode() {

		when(testDatabaseService.lookup(anyString())).thenReturn(null);
		when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396", "Of Mice and Men", "Stenbook"));

		String isbn = "0140177396";
		String locatorCode = bookService.getLocatorCode(isbn);
		assertEquals("7396S4", locatorCode);
	}

	@Test
	public void mockDatabaseServiceUsedIfDataPresent() {
		String isbn = "0140177396";

		when(testDatabaseService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice and Men", "Stenbook"));
		String locatorCode = bookService.getLocatorCode(isbn);
		verify(testDatabaseService).lookup("0140177396");
		verify(testWebService, never()).lookup(anyString());
	}

	@Test
	public void mockWebServiceUsedIfDataPresent() {
		String isbn = "0140177396";

		when(testDatabaseService.lookup(isbn)).thenReturn(null);
		when(testWebService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice and Men", "Stenbook"));
		String locatorCode = bookService.getLocatorCode(isbn);

		verify(testDatabaseService).lookup("0140177396");
		verify(testWebService).lookup("0140177396");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
