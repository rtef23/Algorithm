package prev_solve.StackedNumberArray;

import java.util.Scanner;
import java.util.Stack;

public class Main1874 {
	private static final char push = '+';
	private static final char pop = '-';
	private static final String no = "NO";
	/*
	4 3 6 8 7 5 2 1
	
	1 2 3 4 5 6 7 8
			[]
	push	[1]
	push	[1, 2]
	push	[1, 2, 3]
	push	[1, 2, 3, 4]
	pop		[1, 2, 3] 4
	pop		[1, 2] 3 4
	push	[1, 2, 5] 4 3
	push	[1, 2, 5, 6] 4 3
	pop		[1, 2, 5] 4 3 6
	push	[1, 2, 5, 7] 4 3 6
	push	[1, 2, 5, 7, 8] 4 3 6
	pop		[1, 2, 5, 7] 4 3 6 8
	pop		[1, 2, 5] 4 3 6 8 7
	pop		[1, 2] 4 3 6 8 7 5
	pop		[1] 4 3 6 8 7 5 2
	pop		[] 4 3 6 8 7 5 2 1
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num_arr[] = new int[n];
		
		for(int i = 0;i < n;i++){
			num_arr[i] = scan.nextInt();
		}
		
		String res = buildStackedNumber(n, num_arr);
		System.out.println(res);
		scan.close();
	}
	public static String buildStackedNumber(int n, int num_arr[]){
		StringBuilder res = new StringBuilder();
		int arr_index = 0;
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		
		for(int n_tracer = 1;n_tracer <= n;n_tracer++){
			while(stk.peek() == num_arr[arr_index]){
				stk.pop();
				res.append(pop);
				res.append("\n");
				arr_index++;
			}				
			stk.push(n_tracer);
			res.append(push);
			res.append("\n");
		}
		while(stk.peek() == num_arr[arr_index]){
			stk.pop();
			res.append(pop);
			res.append("\n");
			arr_index++;
			if(arr_index == num_arr.length){
				break;
			}
		}
		
		return (stk.peek() == -1)?res.toString():no;
	}
	
}
