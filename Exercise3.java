/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// February 12, 2021
// Exercise 3 - InputMismatchException
//
/////////////////////////////////////////////////////////

/** This program uses InputMismatchException via a throws
 * statement to check if the user has entered two integers
 * in the console. If both inputs are not integers, an error
 * message is displayed, if the two inputs are integers,
 * the sum of both integers is displayed in the console.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {
	
	public static Scanner userInput = new Scanner(System.in);
	public static int total = 0;
	/* I used a specific thought process for developing the 
	 * loop break system for this program. That being, after
	 * each successful try completion, the boolean values
	 * are reversed. Like train tracks being switched, if
	 * one path is made available, the other is no longer
	 * available, this makes for a simple and clean way
	 * to close loops and open others. Thus why continueLoopOne
	 * starts true but continueLoopTwo is false. */
	public static boolean continueLoopOne = true;
	public static boolean continueLoopTwo = false;
	
	public static void main(String[] args) {

		//boolean continueLoopOne and continueLoopTwo will act as the while loop condition and will loop until boolean value is false
		while (continueLoopOne) {
			//passing Scanner object userInput to Scanner Method throwsUserInput for throws checking and adding user token to global int total
			throwsUserInput(userInput);
		}
			while (continueLoopTwo) {
				throwsUserInput(userInput);
			}
			System.out.println("The sum of the integers entered is: " + total);
		}
	//method for Scanner throws and loop break
	public static void throwsUserInput(Scanner userInput) {
		//try to scan for int token from user and exit loop
		try {
			System.out.println("Enter an integer: ");
			//token added to global int total
			total += userInput.nextInt();
			//switching boolean values 
			continueLoopOne =! continueLoopOne;
			continueLoopTwo =! continueLoopTwo;
		}
		//throws by Scanner to indicate that input token was not of matching type int
		catch (InputMismatchException ex) {
			//error message for throws
			System.out.println("Try again. (" + "Inccorect input: an integer is required)");
			//Discard userInput
			userInput.nextLine(); 
		}
	}
}