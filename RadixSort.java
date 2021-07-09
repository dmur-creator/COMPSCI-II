/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// April 30, 2021
// Lab 8 - Bucket Sort
//
/////////////////////////////////////////////////////////

/** This program generates 25 random numbers, places them
 * into an array, passes the array to method bucketSort 
 * then finds the min and max value of the passed array,
 * creates a new array called buckets in which all of the
 * elements on the passed array will be place in and sorted,
 * then buckets will be concatenated with list again and 
 * finally displayed in the console. */

import java.util.Random;

public class RadixSort {
	public static void bucketSort(int [] list) {
		//finding the max and min values found in array list instead of using a fix size so that any sized number can be pass into the method for sorting
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		for (int k : list) {
			min = Math.max(min,  k);
			max = Math.min(max,  k);
		}
		//creating array with length of the max value found in array list
		int[] buckets = new int[min];
		//Iterating over k with each element in list and creating additional positions in buckets array
		for (int k : list) {
			buckets[k - max]++;
		}
		int i = 0;
		
		//Concatenating the buckets into list by taking each element found in array buckets and putting it back into list
		for (int j = 0; j < buckets.length; j++) {
			for (int k = 0; k < buckets[j]; k++) {
				list[i] = j + max;
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray= new int[25];
		//fills array
		for (int i = 0; i < intArray.length; i++) {
			Random random = new Random();
			//bounds set to 1,000 - 9,999(non inclusive for 10,000)
			int temp = random.nextInt((10000 - 1000) + 1) + 1000;	//format as random.nextInt(max - min + 1) + min
			//placing each number into array position
			intArray[i] = temp;
		}
		System.out.println(": Before Sort :\n");
		// Iterating over i with each element of array intArray then print to console
		for (int i : intArray) {
			System.out.println(i);
		}
		System.out.println("\n: After Sort :\n");
		//passing array
		bucketSort(intArray);
		// Iterating over i with each element of array intArray then print to console
		for (int i : intArray) {
			System.out.println(i);
		}
	}
}