import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BracketSolution {
	public static boolean isBalanced(String expression) {
		Stack<Character> s = new Stack<Character>();
			char[] expArray = expression.toCharArray(); 
			for(char c: expArray){
				switch(c){
				case '{': s.push('}');break;
				case '[': s.push(']');break;
				case '(': s.push(')'); break;
				default: if(!s.empty()  && c == (s.peek())) s.pop();
				else if(s.empty() || c != s.peek()){
					return false;
				}
				}           
			}
        if(s.empty()) return true;
        else return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			boolean answer = isBalanced(expression);
			if(answer)
				System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
