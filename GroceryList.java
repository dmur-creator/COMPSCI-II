/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// March 7, 2021
// Lab 5 - Grocery LinkedList
//
/////////////////////////////////////////////////////////

/** This program allows the user to add, delete and retrieve
 * a shopping list stored in a LinkedList. */

import java.util.LinkedList;
import java.util.Scanner;

public class GroceryList {
	public static void main(String[] args) {
		LinkedList<String> grocery = new LinkedList<String>();
		Scanner userIn = new Scanner(System.in);
		//base loop condition for while statement
		boolean loopCon = true;

		while (loopCon) {
			printList(grocery);
			System.out.println("\nWould you like to (a)dd to the list or (d)elete something from the list or (p)rint the list?");
			char charChoice = userIn.next().charAt(0);
			switch (charChoice) {

			case 'a' :
				System.out.println("Type what you would like to add: ");
				String stringChoice = userIn.next();
				//adding user String input to LinkedList grocery
				grocery.add(stringChoice);
				break;

			case 'd' : 
				System.out.println(grocery + " please type which item to remove or (n)o to return to selection: ");
				stringChoice = userIn.next();
				//breaking loop without removing anything from the LinkedList grocery
				if (stringChoice == "n") {
					break;
				}
				else {
					//removing element that matches user input string from LinkedList grocery 
					grocery.remove(stringChoice);
					break;
				}

			case 'p' :
				printList(grocery);
				loopCon = false;
				break;
			}

		}
		userIn.close();
	}
	//method for displaying status of LinkedList grocery as either empty or displaying each element on a separate line
	public static void printList(LinkedList<String> in) {
		if (in.isEmpty()) {
			System.out.println("Your list is empty");
		}
		else {
			System.out.println("Your list is: ");
			//prints out all elements found in linkedlist grocery by using an iterator to loop through each element and assign it to a temp variable and printing that variable to the console
			for (String tempVar : in) {
				System.out.println(tempVar);
			}
		}
	}
}

//Pseudo code
/** loop "would you like to (a)dd..." with all three options boolean loopCon = true
 * 
 * if (stringChoice = a)
 * (a)dd uses addLast()
 * 	"type what you would like to add"
 * 		LinkedListName.addLast(stringChoice);
 * 		break;
 * 
 * if (stringChoice = d)
 * (d)elete uses removeLast()
 * 	"display LinkedList, starting at 0, which item to remove? (n)o to return to selection"
 * 		if (choice != n) LinkedList.remove(intChoice);
 * 		if (choice = n) return to menu
 * 		break;
 * 
 * if (stringChoice = p)
 * (p)rint uses name of LinkList and prints to console
 * 	"Your grocery list is: "
 * loopCon = false
 * 
 * */