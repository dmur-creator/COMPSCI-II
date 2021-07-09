/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// March 31, 2021
// Exercise 6 - Are the Parentheses Balanced? Using Stack
//
/////////////////////////////////////////////////////////

/** This program reads a txt file and checks if any parens 
 * that it contains are balanced (i.e. a complete set like
 * () would be balanced and (() would be unbalanced). It
 * stores the parens in a stack and reads the txt file char
 * by char. */

import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;

public class parens {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String type Stack stack created for pushing and popping parens scanned from Parens.txt
		Stack<String> stack = new Stack<String>();
		//obvious
		System.out.println("Checking txt doc for balanced parens... \n");
		//buffered reader 'br' established and is reading file 'Parens.txt'
		try (BufferedReader br = new BufferedReader(new FileReader("Parens.txt")))	{
			//for string input form txt
			String input;
			//loop which loops until all lines are read in txt
			while ((input = br.readLine()) != null) {
				//converts all chars found in String 'input' into char array for individual char checks so that open parens can be pushed and closed parens popped 
				char[] ch = new char[input.length()];
				for (int copy = 0; copy < input.length(); copy++) {
					ch[copy] = input.charAt(copy);
				}
				//checking each char array position
				for (int i = 0; i < ch.length; i++) {
					//try catch established for pushing any found open parens and throws EmptyStackException in the case that are more closed parens than open
					try {
						if(ch[i] == '(') {	//(input.contains("(")) code for string based approach
							stack.push("(");
						}
						if(ch[i] == ')') {	// checking for ')' if not throws
							stack.pop();
						}
						//if i is on final possible iteration from for loop and stack is empty then the read line is balanced, otherwise not
						if (i == ch.length - 1) {
							if (stack.isEmpty()) {
								System.out.println("Line is Balanced");
								stack.clear();	//clearing stack for new line to be read without prev remnants. ditto for all proceeding instances 
								break;
							}
							System.out.println("Line is Unbalanced");
							stack.clear();
							break;
						}		
					} catch (EmptyStackException e) {
						System.out.println("Line is Unbalanced");
						stack.clear();
						break;
					}
				}
			}
		}
	}
}