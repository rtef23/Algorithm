package prev_solve.OneNumber;

import java.util.HashMap;
import java.util.Scanner;

public class MainPro1065 {
	private static final int not_one_number = -10;
	private static final int can_be_anything = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		
		n = scan.nextInt();
		
		System.out.printf("%d\n", countOneNumber(n));
		
		scan.close();
	}
	private static int countOneNumber(int n){
		HashMap<Integer, Integer> memo = new HashMap<>();
		int cnt = 0;
		
		for(int i = 1;i <= n;i++){
			if(isOneNumber(memo, i) != not_one_number){
				cnt++;
			}
		}
		
		return cnt;
	}
	private static int isOneNumber(HashMap<Integer, Integer>memo, int n){
		if(memo.containsKey(n)){
			return memo.get(n);
		}
		if(n < 10){
			return can_be_anything;
		}
		int front_num = n / 10;
		int last_num = n % 10;
		int diff = (front_num % 10) - last_num;
		int front_res = isOneNumber(memo, front_num);
		
		switch (front_res) {
		case can_be_anything:
			memo.put(n, diff);
			break;
		case not_one_number:
			memo.put(n, not_one_number);
			break;
		default:
			if(front_res == diff){
				memo.put(n, diff);
			}else{
				memo.put(n, not_one_number);
			}
			break;
		}
		
		return memo.get(n);
	}
}
