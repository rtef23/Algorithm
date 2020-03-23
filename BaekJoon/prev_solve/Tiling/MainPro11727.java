package prev_solve.Tiling;

import java.util.Scanner;

public class MainPro11727 {
	private static final int limit = 10007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int memo[];
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		memo = new int[n + 1];
		
		System.out.println(go(memo, n));
		
		scan.close();
	}
	
	static int go(int memo[], int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 3;
		
		if(memo[n] > 0)
			return memo[n];
		else{
			memo[n] = (go(memo, n - 1) + (2 * go(memo, n - 2))) % limit;
			return memo[n];
		}
	}
}
