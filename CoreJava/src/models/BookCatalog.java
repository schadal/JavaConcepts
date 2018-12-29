package models;

import java.util.HashMap;

public class BookCatalog {

	private HashMap<Integer, Book> bookMap;
	private Book[] bookArray = new Book[100];
	private int nextPosition = 0;

	public Book[] getBookArray() {
		return bookArray;
	}
	
	public HashMap<Integer, Book> getBookMap(){
		return bookMap;
	}
	
	public void addBook(Book newBook) {
		//bookArray[nextPosition] = newBook;//adds to the next position
		//nextPosition++;
		
		bookMap.put(newBook.getID(), newBook);
		
	}
	
	public Book findBook(String title) throws BookNotFoundException
	{
		for (int counter = 0; counter < nextPosition; counter++) {
			if (bookArray[counter].getTitle().equalsIgnoreCase((title))) {
				return bookArray[counter];
			}
		}
		throw new BookNotFoundException();
	}

}
