/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// February 16, 2021
// Lab 2 - ArrayLists Sorting
//
/////////////////////////////////////////////////////////

/** This program asks for user input of 5 integers, puts 
 * the integers into an array and sorts the integers in
 * ascending order. If a non-integer is entered, a throws
 * statement will check the token and display an error
 * message in the console and wait for a new entry. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayLists {
	public static void main(String[] args) {
		//Instantiating class variable 'i' which will be used for do while condition 
		int i = 0;
		System.out.println("Enter five integers");
		Scanner userInput = new Scanner(System.in);
		//creating new ArrayList named 'list'
		ArrayList<Integer> list = new ArrayList<Integer>();	

		do {
			//try to scan for int token from user and exit loop after 5 successful loops
			try {
				System.out.println("Enter an integer: ");
				//adding user inputed integer to Array 'list'
				list.add(userInput.nextInt());
				i++;
			}
			//throws by Scanner to indicate that input token was not of matching type int
			catch (InputMismatchException ex) {
				//error message displayed in console is as follows
				System.out.println("Try again. (" + "Inccorect input: an integer is required)");
				//Discard userInput
				userInput.nextLine(); 
			} 
			//if 'i' equals 5, pass Array 'list' to method sortNums, display 'list' in console and break do while loop
			if (i == 5) {
				sortNums(list);
				System.out.println(list);
				break;
			}
		} while (i >= 0 || i <= 5);
		//closed userInput for security
		userInput.close();
	}
	//method sortNums used to sort integers in Array 'list' in ascending order
	public static void sortNums(ArrayList<Integer> list) {
		//using built-in method Collections.sort to sort Array 'list'
		Collections.sort(list);
	}
}
