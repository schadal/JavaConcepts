package com.ext.services;

import com.ext.model.Book;

public interface ExternalBookDetailsService {
	
	public Book lookup(String isbn);
	
	
}
