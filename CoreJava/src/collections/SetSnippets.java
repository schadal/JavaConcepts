package collections;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetSnippets {

	protected static List<Integer> listNumbers = Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6);
	
	public static void main(String[] args){
		//set doesn't allow duplicates
		//it models set in mathematics
		//unordered elements
		//use set if we want to store elements in a random order
		//there are HashSet, LinkedHashSet and TreeSet are three implementations of Sets
		//TreeSet is ordered and is an implementation of set interface
		
		
		System.out.println(listNumbers);
		Set<Integer> uniqueNumbers = new HashSet<>(listNumbers);
		System.out.println(uniqueNumbers);
		
		System.out.println("====useStreamAndGetOddNumbers====");
		useStreamAndGetOddNumbers();
		System.out.println("===End===");
		
	}
	
	/**
	 * useStreamAndGetOddNumbers
	 * @author sudheervchadalavada
	 */
	public static void useStreamAndGetOddNumbers(){
		Set<Integer> oddNumberSet = listNumbers.stream().filter(number -> number%2 != 0).collect(Collectors.toSet());
		oddNumberSet.forEach(number -> System.out.println(number));
		
	}
	
	/**
	 * subsetOperation
	 * @author sudheervchadalavada
	 */
	public static void subsetOperation(){
		Set<Integer> s1 = new HashSet<>(Arrays.asList(20, 56, 89, 31, 8, 5));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(8, 89));
		 
		if (s1.containsAll(s2)) {
		    System.out.println("s2 is a subset of s1");
		}
	}
	
	/**
	 * unionSetOperation
	 * @author sudheervchadalavada
	 */
	public static void unionSetOperation(){
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		 
		System.out.println("s1 before union: " + s1);
		 
		s1.addAll(s2);
		 
		System.out.println("s1 after union: " + s1);
	}
	
	/**
	 * intersectionOperation
	 * @author sudheervchadalavada
	 */
	public static void intersectionOperation(){
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		 
		System.out.println("s1 before intersection: " + s1);
		 
		s1.retainAll(s2);
		 
		System.out.println("s1 after intersection: " + s1);
	}
	
	/**
	 * differenceSetOperation
	 * @author sudheervchadalavada
	 */
	public static void differenceSetOperation(){
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		 
		System.out.println("s1 before difference: " + s1);
		 
		s1.removeAll(s2);
		     
		System.out.println("s1 after difference: " + s1);
	}
	
	/**
	 * checkConcurrency()
	 * @author sudheervchadalavada
	 */
	public static void checkConcurrency(){
		//for thread safety using multiple concurrent threads
		//The returned set is synchronized (thread-safe). And remember you must manually synchronize on the returned set when iterating over it:
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
		Set<Integer> numbers = Collections.synchronizedSet(s1);
		synchronized (numbers) {
		    Iterator<Integer> iterator = numbers.iterator();
		 
		    while (iterator.hasNext()) {
		        Integer number = iterator.next();
		        System.out.println(number);
		    }
		}
	}
}
