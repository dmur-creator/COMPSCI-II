/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 160 Computer Science I
// Sep 29, 2020
// Lab 5.2 Multiples of 3
//
/////////////////////////////////////////////////////////

/* This program takes an assigned variable "i = 3" and checks
 * to see if it is divisible by itself and if so, prints the 
 * number and increases the quantity of i by 1 until i is 99.*/

// Opening class Main
public class Lab_52 {
	public static void main(String[] args) {
		
		// Displaying text to user in console " Multiples of Three" with line space after
		System.out.println("Multiples of Three \n");
		
		/* Using for statement to declare variable i to equal 
		 * 3, checking if i is less than 100 and increasing i 
		 * by 1 each time the for loops. */
		for(int i = 3; i<100; i++)
		{
			// If is used to check if variable i's current value equals 0 when divided by itself
			if(i%3 == 0)
				// So long as i divided by 3 equals 0 then variable i value is displayed to user in console
				System.out.println("\n" + i);

		}
	}
}
	
	
