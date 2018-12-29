package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import models.Book;

public class ListSnippets {

	protected static List<Book> books = getBookslist();
	
	public static void main(String[] args) {
		
		ListFunctionsWithLambdas();
		useIteratorOnList();
		usingComparators();
		convertListToArrays();
		
		//working with linkedlists
		//LinkedList uses more memory as it stores more pointers
		//They provide sequential access and read in order
		//They can grow and shrink in size during the execution
		//They cannot accept heterogeneous objects.
		//Advantage is we can insert a node at any given position, before or after the list as well.
		synchronizeLinkedList();
		iterateLinkList();
		System.out.println("====convertListsToSets===");
		convertListsToSets();
		System.out.println("====End convertListsToSetss====");
	}
	
	/**
	 * Get Bookslist
	 * @author sudheervchadalavada
	 * @return List<Book>
	 */
	public static List<Book> getBookslist(){
		
		List<Book> booksList = new ArrayList<Book>(9);
		
		Book book1 = new Book(1, "book1","author1", "isbn1","", 10);
		Book book2 = new Book(2, "book2","author1", "isbn1","", 10);
		Book book3 = new Book(3, "book3","author1", "isbn1","", 10);
		Book book7 = new Book(7, "book7","author1", "isbn1","", 10);
		Book book8 = new Book(8, "book8","author1", "isbn1","", 10);
		Book book9 = new Book(9, "book9","author1", "isbn1","", 10);
		Book book10 = new Book(10, "book10","author1", "isbn1","", 10);
		Book book4 = new Book(4, "book4","author1", "isbn1","", 10);
		Book book5 = new Book(5, "book5","author1", "isbn1","", 10);
		Book book6 = new Book(6, "book6","author1", "isbn1","", 10);
		
		
		booksList.add(book1);
		booksList.add(book2);
		booksList.add(book3);
		booksList.add(book4);
		booksList.add(book5);
		booksList.add(book6);
		booksList.add(book7);
		booksList.add(book8);
		booksList.add(book9);
		booksList.add(book10);
		
		return booksList;
	}
	
	/**
	 * ListFunctionsWithLambdas()
	 * @author sudheervchadalavada
	 */
	public static void ListFunctionsWithLambdas(){
		System.out.println("1. Foreach approach 1");
		books.forEach(book -> {
			System.out.println(book);
		});
		
		//using method reference can work if the collection is a string
		System.out.println("2. foreach approach 2");
		books.forEach(book -> System.out.println(book.getAuthor()));
	}
	
	/**
	 * useIteratorOnList
	 * @author sudheervchadalavada
	 */
	public static void useIteratorOnList(){
		//iterate using iterator
				System.out.println("Iterator approach 1");
				Iterator<Book> iterator = books.iterator();
				while(iterator.hasNext()){
					System.out.println(iterator.next().getIsbn());
				}
				
				//4. Iterate loop
				System.out.println("Iterate approach 2");
				for(Book book: books){
					System.out.println(book.getTitle());
				}
	}
	/**
	 * usingComparators
	 * @author sudheervchadalavada
	 */
	public static void usingComparators(){
		
		System.out.println("===== Old way comparator i.e. using inner class======");
		Comparator<Book> bookComparator = new Comparator<Book>() {
		    @Override
		    public int compare(Book book1, Book book2) {
		        return (book1.getTitle().compareTo(book2.getTitle()));
		    }
		};
		Collections.sort(books, bookComparator);
		System.out.println("====End====");
		
		//lambda here!
		System.out.println("===Lambda Sorting here for string comparison====");
		books.sort((Book b1, Book b2) -> b1.getTitle().compareTo(b2.getTitle()));
		books.forEach(book -> System.out.println(book.getTitle()));
		System.out.println("===End====");
		
		System.out.println("===Lambda Sorting here for sorting numbers comparison====");
		Comparator<Book> booksForLambda  = (b1, b2) -> b1.getID() - b2.getID();
		Collections.sort(books, booksForLambda);
		books.forEach(book -> System.out.println(book.getID()));
	}
	
	/**
	 * convertListToArrays
	 * @author sudheervchadalavada
	 */
	public static void convertListToArrays(){
		
		System.out.println("===== Convert list to array======");
		Object[] bookArray = books.toArray();
		//Book[] bookArray = (Book[]) books.toArray();
		System.out.println(bookArray.length);
		System.out.println("===End====");
		
		
	}
	
	/**
	 * synchronizeLinkedList
	 * @author sudheervchadalavada
	 */
	public static void synchronizeLinkedList(){
		List<Book> linkBooks = Collections.synchronizedList(getLinkedList());
		linkBooks.forEach(book -> System.out.println(book.getIsbn()));
		
	}
	
	/**
	 * iterateLinkList
	 * @author sudheervchadalavada
	 */
	public static void iterateLinkList(){
		List<Book> linkBooks = Collections.synchronizedList(getLinkedList());
		Iterator<Book> iterator = linkBooks.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().getAuthor());
		}
	}
	
	/**
	 * getLinkedList
	 * @author sudheervchadalavada
	 * @return
	 */
	public static List<Book> getLinkedList(){
		return new LinkedList<>(books);
		
	}
	
	/**
	 * convertListsToSets
	 * @author sudheervchadalavada
	 */
	public static void convertListsToSets(){
		List<Book> linkBooks = Collections.synchronizedList(getLinkedList());
		Set<Book> bookSet = linkBooks.stream().collect(Collectors.toSet());
		//convert list to hashset
		//HashSet<Book> bookSet = (HashSet<Book>)linkBooks.stream().collect(Collectors.toSet());
		
		bookSet.forEach(book -> System.out.println(book.getAuthor()));
	}
	

	
	
	

}
