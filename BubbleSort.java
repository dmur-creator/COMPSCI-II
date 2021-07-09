/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// April 14, 2021
// Exercise 7 - Bubble Sort
//
/////////////////////////////////////////////////////////

/** This program creates a 25 long array comprised of 25 
 * pseudo random ints between 1-100, prints outs each int
 * and then using the bubble sort method, sorts the ints
 * in the array by ascending numerical order. I.E. if the
 * array has 2 5 4 2 6  then the bubble sort checks the 
 * current position and the position to its right to see 
 * if the current number is bigger than the one on the
 * right and if so switches them. So 2 and 5 would remain
 * in their positions but 5 and 4 would get switched, thus
 * sorting by having the largest numbers "bubble" up to the
 * top of the array, leaving you with 2 2 4 5 6 */

import java.util.Random;

public class BubbleSort {

	public static void bubbleSorter(int [] tempArray) { 
		//This logic was taken out of the Intro to Java Programming by Daniel Liang
		boolean needNextPass = true;
		for (int k = 1; k < tempArray.length && needNextPass; k++) {
			needNextPass = false ;
			//for each position in the array, check each position and then increment position by one
			for (int i = 0; i < tempArray.length - k; i++) {
				//if value of current array object is greater then the value of the next object over, swap the values via temp variables
				if (tempArray[i] > tempArray[i + 1]) {
					//swap intArray[i] with intArray[i + 1];
					int temp = tempArray[i];
					tempArray[i] = tempArray[i + 1];
					tempArray[i + 1] = temp;
					needNextPass = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray= new int[25];
		//fills array
		for (int i = 0; i < intArray.length; i++) {
			Random random = new Random();
			//bounds set to 1 - 100(non inclusive for 101)
			int temp = random.nextInt(101 - 1) + 1;
			intArray[i] = temp;
		}
		System.out.println(": Before Sort :\n");
		for (int i : intArray) {
			System.out.println(i);
		}
		System.out.println("\n: After Sort :\n");
		bubbleSorter(intArray);
		for (int i : intArray) {
			System.out.println(i);
		}
	}

}