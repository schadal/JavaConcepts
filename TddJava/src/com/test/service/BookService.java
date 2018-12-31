package com.test.service;

import com.ext.model.Book;
import com.ext.services.ExternalBookDetailsService;

public class BookService {

	private ExternalBookDetailsService webService;
	private ExternalBookDetailsService databaseService;
		

	public String getLocatorCode(String isbn) {
		Book book = databaseService.lookup(isbn);
		if(book == null) book = webService.lookup(isbn);
		
		StringBuilder locator = new StringBuilder();
		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor().substring(0,1));
		locator.append(book.getTitle().split(" ").length);
		
		return locator.toString();
	}


	public void setWebService(ExternalBookDetailsService service) {
		this.webService = service;
	}
	
	public void setDatabaseService(ExternalBookDetailsService dbService) {
		this.databaseService = dbService;
	}

}
