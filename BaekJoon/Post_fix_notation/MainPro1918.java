package Post_fix_notation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class MainPro1918 {
	private static HashSet<Character> op_set;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String in = scan.next();
		
		op_set.add('+');
		op_set.add('-');
		op_set.add('*');
		op_set.add('/');
		op_set.add('(');
		op_set.add(')');
		
		System.out.println(toPostFix(in));
		
		scan.close();
	}
	public static String toPostFix(String input){
		Stack<Character> data = new Stack<>();
		Stack<Character> op = new Stack<>();
		
		for(int i = 0;i < input.length();i++){
			if(op_set.contains(input.charAt(i))){
				//this character is operator
				
			}else{
				//this character is data
				
			}
		}
		return null;
	}
}
