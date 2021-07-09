/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// January 27, 2021
// Lab 1 - String Manipulation
//
/////////////////////////////////////////////////////////

/* This program prompts user input of a phone number in the
 * format of (555)-555-5555 and uses .matches to ensure that
 * the entered phone number is in the correct format with valid
 * and error messages telling the user if their number passed
 * the .matches test. .matches was chosen to check for String
 * consistency as it is Java's built-in regex tool which enables
 * easy string manipulation such as the consistency checking of
 * strings, and by using .matches instead of creating a program
 * in-place of it, the readability and compactness of the code
 * is greatly positively effected. */

import java.util.Scanner;

public class PhoneFormat {
	public static void main(String[] args) {
		
		// establishing input scanner
		Scanner sc = new Scanner(System.in);
		// messages below will only show in console
		System.out.println("Please enter a phone number in the format of (555)-555-5555");
		String phoneNumber = sc.next();
		
		// testing user input String for valid regex consistency using .matches. If match is true, set validCheckMsg to valid message, if false, set validCheckMsg to error. 
		// Ternary operator was chosen as .matches is boolean so it makes the code more compact for better readability   
		String validCheckMsg = phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}") ? "Valid Phone Number" : "Bad Format for Phone number";
		System.out.println(validCheckMsg);
		// Scanner closed for security
		sc.close();
		}
}