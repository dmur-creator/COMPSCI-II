/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// April 20, 2021
// Exercise 8 - Recursion
//
/////////////////////////////////////////////////////////

/** This program displays asterisks incrementally by one
 * in the console by using recursion. It looks like this:
 * 
 * *
 * **
 * ***
 * ****
 * *****
 * 
 * There are two different methods(no pun intended) for 
 * printing out the asterisks. One that Requires the 
 * value passed to the recursive method to remain at one
 * while changing the actual number of lines of asterisks
 * requires changing the value in the method and a method
 * that uses an ArrayList. */

import java.util.ArrayList;
import java.util.List;

public class Recursion {
	//setting up globals
	private static String text = "*";
	private static List<String> str = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Call to method 1
//		asteriskRecursion(1);	//keep at one
		//Call to method 2
		asteriskRecursion2(5);	//can be changed to any int and this int will dictate the number of calls that happen within the method
	}

	public static void asteriskRecursion(int a) {
		//Starting at 1 for the passed in value 
		int repeat = a;
		//repeat == 6 used for base case
		if (repeat == 6) {	//change what repeat equals to decide the number of method calls
			return;
		} else {
				//using .repeat we can pass the int var. repeat in and have it repeat our text repeat times
				System.out.println(text.repeat((repeat)));
				//after each call, increment repeat by 1
				asteriskRecursion(repeat + 1);
		}
	}
	
	
	public static void asteriskRecursion2(int a) {
		//Passed in value will be used for our base case
		int repeat = a;
		if (repeat <= 0) {
			return;
		} else {
				//after each call, add text to ListArray
				str.add(text);
				//iterate through each element of ListArray str and assign it to temp var. tempText then display to console
				for (String tempText : str) {
					System.out.print(tempText);
				}
				//after this is done, print line break as to space out each recursive call
				System.out.print("\n");
				//after each call, decrement repeat by one 
				asteriskRecursion2(repeat - 1);
		}
	}
}