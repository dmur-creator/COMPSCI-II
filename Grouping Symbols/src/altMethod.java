/** Test code that uses multiple stacks to store symbols 
 * NOTE: potentially inefficient due to its use of multiple stacks
 * and will show illegal statements as balanced!!! */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class altMethod {

// all stacks are made to be static globals for cleaner code when clearing the stacks
static Stack<String> stackParen = new Stack<String>();	// (
static Stack<String> stackCurly = new Stack<String>();	// {
static Stack<String> stackBraket = new Stack<String>();	// [

public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub		
	//obvious
	System.out.println("Checking txt doc for balanced parens... \n");
	//buffered reader 'br' established and is reading file 'Parens.txt'
	try (BufferedReader br = new BufferedReader(new FileReader("MatchingSymbols.txt")))	{
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
				//try catch established for pushing any found open syms and throws EmptyStackException in the case that are unbalanced syms
				try {
					String str = Character.toString(ch[i]);
					if (ch[i] == '(') {	// checking for applicable sym
						stackParen.push(str);
					}
					if (ch[i] == '[') {
						stackBraket.push(str);
					}
					if (ch[i] == '{') {
						stackCurly.push(str);
					}
					if (ch[i] == ')') {	// checking for applicable sym if not throws
						stackParen.pop();
					}
					if (ch[i] == ']') {
						stackBraket.pop();
					}
					if (ch[i] == '}') {
						stackCurly.pop();
					}
					//if i is on final possible iteration from for loop and all stacks are empty then the read line is balanced, otherwise not
					if (i == ch.length - 1) {
						if (stackParen.isEmpty() && stackCurly.isEmpty() && stackBraket.isEmpty()) {
							System.out.println("Line is Balanced");
							clearStacks();	//clearing stack for new line to be read without prev remnants. ditto for all proceeding instances 
							break;
						}
						System.out.println("Line is Unbalanced");
						clearStacks();
						break;
					}		
				} catch (EmptyStackException e) {
					System.out.println("Line is Unbalanced");
					clearStacks();
					break;
				}
			}
		}
	}
}
//as is the name, clearStacks() clears all applicable stacks 
public static void clearStacks() {
	stackParen.clear();
	stackCurly.clear();
	stackBraket.clear();
}

}