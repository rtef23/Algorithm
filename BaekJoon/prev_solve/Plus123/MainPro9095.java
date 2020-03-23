package prev_solve.Plus123;

import java.util.Scanner;

public class MainPro9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;//test case
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		for(int i = 0;i < t;i++){
			int n = scan.nextInt();
			int memo[] = new int[n + 1];
			
			System.out.println(go(memo, n));
		}
		
		scan.close();
	}
	private static int go(int memo[], int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(n == 3)
			return 4;
		
		if(memo[n] > 0)
			return memo[n];
		else{
			memo[n] = (go(memo, n - 1) + go(memo, n - 2) + go(memo, n - 3));
			return memo[n];
		}
	}
}
