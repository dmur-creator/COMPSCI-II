/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// March 31, 2021
// Lab 6 - Grouping Symbols (20.11)
//
/////////////////////////////////////////////////////////

/** This program checks for balanced symbols ( { [ in a txt
 * doc using a stack. If there is an unbalanced line such as
 * [something} than a unbalanced/illegal expression message 
 * will print, otherwise a balanced message will print. */
//use boolean
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class matchSymbols {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String type Stack stack created for pushing and popping parens scanned from Parens.txt
		Stack<String> stack = new Stack<String>();
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
				char currentSym = ' ';
				for (int i = 0; i < ch.length; i++) {
					//try catch established for pushing any found open syms and throws EmptyStackException in the case that are unbalanced syms
					try {
						//converting individual char back to string to check and .push to stack 
						String str = Character.toString(ch[i]);
						if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {	// checking for applicable sym
							stack.push(str);
							currentSym = ch[i];
//							System.out.println(stack);//bug tester
						}
						//if the closed sym char matches to an open sym in the stack, .pop
						if (ch[i] == ')' && stack.contains("(") && currentSym == '(') {	// was ch[i] == ')' && stack.contains("(") // checking for applicable sym if not throws
							stack.pop();
//							System.out.println(stack);//bug tester
						}
						if (ch[i] == ']' && stack.contains("[") && currentSym == '[') {
							stack.pop();
//							System.out.println(stack);//bug tester
						}
						if (ch[i] == '}' && stack.contains("{") && currentSym == '{') {
							stack.pop();
//							System.out.println(stack);//bug tester
						}
							//illegal expression checks
						if (ch[i] == ')' && stack.contains("(") && currentSym != '(') {	// was ch[i] == ')' && stack.contains("(") // checking for applicable sym if not throws
							System.out.println("Illegal expression");
							break;
						}
						if (ch[i] == ']' && stack.contains("[") && currentSym != '[') {
							System.out.println("Illegal expression");
							break;
						}
						if (ch[i] == '}' && stack.contains("{") && currentSym != '{') {
							System.out.println("Illegal expression");
							break;
						}
						//if i is on final possible iteration from for loop and all stacks are empty then the read line is balanced, otherwise not
						if (i == ch.length - 1) {
							if (stack.isEmpty() ) {
								System.out.println("Line is Balanced");
								stack.clear();	//clearing stack for new line to be read without prev remnants. ditto for all proceeding instances 
								break;
							}
							System.out.println("Unbalanced expression");
							stack.clear();
							break;
						}
//						else {
//							System.out.println("Illegal expression");
//							break;
//						}
					} catch (EmptyStackException e) {
						System.out.println("Unbalanced expression");
						stack.clear();
						break;
					}
				}
			}
		}
	}
}