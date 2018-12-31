package com.ext.model;

public class Book {
	
	private String isbn;
	private String author;
	private String title;
	
	public Book(String isbn2, String title2, String author2) {
		this.isbn = isbn2;
		this.title = title2;
		this.author = author2;
	}

	
	public String getIsbn() {
		return isbn;
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}

	
	

}
