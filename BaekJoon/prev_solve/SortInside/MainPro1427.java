package prev_solve.SortInside;

import java.util.LinkedList;
import java.util.Scanner;

public class MainPro1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String target = scan.nextLine();
		scan.close();
		LinkedList<Character> q = new LinkedList<>();
		for(int i = 0;i < target.length();i++){
			q.add(target.charAt(i));
		}
		System.out.println(F(q));
	}
	public static String F(LinkedList<Character> q){
		LinkedList<Character> res = divide(q);
		StringBuilder sb = new StringBuilder();
		while(!res.isEmpty()){
			sb.append(res.pop());
		}
		return sb.toString();
	}
	public static LinkedList<Character> divide(LinkedList<Character> q){
		if(q.size() <= 1){
			return q;
		}
		int mid = q.size() / 2;
		LinkedList<Character> left = new LinkedList<>();
		LinkedList<Character> right = new LinkedList<>();
		
		for(int i = 0;!q.isEmpty();i++){
			if(mid > i){
				left.add(q.pop());
			}else{
				right.add(q.pop());
			}
		}
		
		LinkedList<Character> left_res = divide(left);
		LinkedList<Character> right_res = divide(right);
		return merge(left_res, right_res);
	}
	public static LinkedList<Character> merge(LinkedList<Character> left, LinkedList<Character> right){
		LinkedList<Character> res = new LinkedList<>();
		while(!left.isEmpty() && !right.isEmpty()){
			Character target = (left.peek() > right.peek())?left.pop():right.pop();
			res.add(target);
		}
		while(!left.isEmpty()){
			res.add(left.pop());
		}
		while(!right.isEmpty()){
			res.add(right.pop());
		}
		return res;
	}
}
