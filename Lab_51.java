/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 160 Computer Science I
// Sep 15, 2020
// Lab 5.1 While Do Loop Prime Numbers
//
/////////////////////////////////////////////////////////

/* This program checks for prime numbers starting with 2
 * until it has found 25 prime numbers using a basic 
 * do-while. It displays the prime numbers on a separate 
 * line with a blank line between each of them. */

// Opening class "Main"
public class Lab_51 {
	public static void main(String[] args) {
		
		// Displaying Text "Sample run" and "Prime numbers" on different lines with a blank line in between
		System.out.println("Sample run:\n" + "\nPrime numbers\n");
		
		/* Setting int variables count to 0 and p to 2. count
		 * is being used for the number of times a prime number 
		 * is found. P stands for prime and is equal to 2 because
		 * 2 is the first prime number. */
		int count=0, p=2;
	
	  /* This do statement contains what will be done when the 
	   * while statement is true. */
		do { 
			 
			// if variable p returnValue is true then print it on a separate line with a blank space above and below it. Also increase count by one.
			if (numberIsPrime(p) ) {
				System.out.printf("%n"+p+"%n");
				count++; 
			}
      // Any time the do statement is read, increase variable p by one to test if it is a prime
			p++;
		}
		// While count is less than 25, loop.
		while( count < 25 ); 
	}
	// Visible method associated with class using boolean to condense test inside method. 
	public static boolean numberIsPrime(int p) {
		
		// Using boolean logic to see if p variable passes for statement.
		boolean returnValue = true;
		for(int x = 2; x <= (p/2); x++)		
		{
			// If variable p divided by x is zero than returnValue is false.
			if(p%x == 0)  returnValue = false;
		}
		
		return returnValue;
	}
		
}