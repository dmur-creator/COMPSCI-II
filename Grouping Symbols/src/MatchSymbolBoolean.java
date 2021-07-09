import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class MatchSymbolBoolean {
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
				Boolean parenFlag = false;
				Boolean bracketFlag = false;
				Boolean curlyFlag = false;
				for (int i = 0; i < ch.length; i++) {
					//try catch established for pushing any found open syms and throws EmptyStackException in the case that are unbalanced syms
					String str = Character.toString(ch[i]);
					if (ch[i] == '(') {	// checking for applicable sym
						parenFlag =! parenFlag;
					}
					if (ch[i] == '[') {
						bracketFlag =! bracketFlag;
					}
					if (ch[i] == '{') {
						curlyFlag =! curlyFlag;
					}
					if (ch[i] == ')' && parenFlag == true) {	// checking for applicable sym if not throws
						parenFlag =! parenFlag;
					}
					if (ch[i] == ']' && bracketFlag == true) {
						bracketFlag =! bracketFlag;
					}
					if (ch[i] == '}' && curlyFlag == true) {
						curlyFlag =! curlyFlag;
					}
					if (i == ch.length - 1 && parenFlag == false && bracketFlag == false && curlyFlag == false) {
						System.out.println("Symbols are balanced");
						break;
					}
					if (i == ch.length - 1 && parenFlag == true || bracketFlag == true || curlyFlag == false) {
						System.out.println("Symbols are not balanced");
						break;
					}
				}
			}
		}
	}
}


