/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// March 4, 2021
// Exercise 5 - ArrayList of Words
//
/////////////////////////////////////////////////////////

/** This program takes a txt file named colors which has
 * been placed in the Java Project folder, and adds each
 * word from it into an array, displays the array and then
 * alphabetizes it and displays the array again. All of
 * this is done with BufferedReader instead of Scanner
 * due to BufferedReader reading files line by line instead
 * of parsing and will allow for memory optimization. 
 * However, a Scanner Version in commented out at the 
 * bottom for reference. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

public class Colors {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		System.out.println("List of colors unsorted:"); 
		
		try {
			//Establishing BufferedReader and FileReader for reading Strings out of colors.txt
			BufferedReader in = new BufferedReader(new FileReader("colors.txt"));
			//Adding each read String into Collection list
			list = in.lines().collect(Collectors.toList());		
			//Closed for security
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//printing each String from Array List(or collection) by using temporary variable tempList and assigning it one element, iterating until every element from the Array has been displayed
		for (String tempList: list) {
			System.out.println(tempList);
		}
		//Using Java's built-in collection method for sorting Strings Alphabetically
		Collections.sort(list);
		System.out.println("\nAlphabetized list of colors:");
		//using the same method as seen above to print each element of the collection one at a time
		for (String counter: list) {
			System.out.println(counter);
		}

		 
		 //Java 8 Stream testing
/**
		 try (Stream<String> stream = Files.lines(Paths.get("colors.txt"))) {
		 stream.sorted().forEach(s -> System.out.println(s));
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//Scanner Version, you will need to add the appropriate imports for it to work
/**
		System.out.println("List of colors unsorted:"); 
		//Established scanner for scanning Strings out of colors.txt
		Scanner scan = new Scanner(new File("colors.txt"));
		ArrayList<String> list = new ArrayList<String>();
		//looping scanner to add each String to ArrayList
		while (scan.hasNext()){
		    list.add(scan.next());
		}
		//Closed for security 
		scan.close();
		//printing each String from Array List(or collection) by using temporary variable tempList and assigning it one element, iterating until every element from the Array has been displayed
		for (String tempList: list) {
			System.out.println(tempList);
		}
		//Using Java's built-in collection method for sorting Strings Alphabetically
		Collections.sort(list);
		System.out.println("\nAlphabetized list of colors:");
		//using the same method as seen above to print each element of the collection one at a time
		for (String counter: list) {
			System.out.println(counter);
		}
		*/
	}

}


