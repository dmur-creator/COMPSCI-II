/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 160 Computer Science I
// Oct 2, 2020
// Lab 5.3 Upper case all user input with a sentinel loop
//
/////////////////////////////////////////////////////////

/* This program asks for user input in the console for a 
 * string and then converts it to all caps until it is told 
 * to quit. This is achieved using a sentinel do while loop 
 * so when the user enters quit, the program will stop 
 * requesting user input.*/

// Importing Scanner
import java.util.Scanner;
// Opening public class Main
public class Lab_53 {
	public static void main(String[] args) {
		// Creating scanner named "input" as it will be used for getting user input
		Scanner input = new Scanner(System.in);
		// Declaring variable "phrase" to be a string and equal to ""
		String phrase = "";
		/* Do while is used to cut down on repeated requests for
		 * user input scans that would be used otherwise in a base
		 * while statement. Displaying user input in all caps, then 
		 * scanning for more user string input.*/
		do {
			System.out.println(phrase.toUpperCase());		
			phrase = input.nextLine();	
				
		// If "quit" is type either at the start or after a string has been entered the loop will end.
		} while (!phrase.equals("quit"));
		// Closing scanner "input" as it is not needed outside of the loop.
		input.close();
	}
	

}



//import java.util.Scanner;
//public class Lab_53 {
//
//	public static void main(String[] args) {
//
//		Scanner input = new Scanner(System.in);
//
//		System.out.println("Please type a line of characters: ");
//		String phrase = input.nextLine();
//		
//		while (!phrase.equals("quit")) {			
//			System.out.println(phrase.toUpperCase());
//			System.out.println("Please type a line of characters: ");
//			phrase = input.nextLine();
//			
//			
//
//		}
//		input.close();
//		
//	}
//
//}
