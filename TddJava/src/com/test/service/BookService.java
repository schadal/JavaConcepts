package com.test.service;

import com.ext.model.Book;
import com.ext.services.ExternalBookDetailsService;

public class BookService {

	private ExternalBookDetailsService service;
	
	public String getLocatorCode(String isbn) {
		Book book = service.lookup(isbn);
		
		StringBuilder locator = new StringBuilder();
		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor());
		locator.append(book.getTitle());
		
		return locator.toString();
	}


	public void setService(ExternalBookDetailsService service) {
		this.service = service;
	}

}
