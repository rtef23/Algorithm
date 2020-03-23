package prev_solve.Tiling;

import java.util.Scanner;

public class MainPro11726 {
	private static final int limit = 10007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		int memo[] = new int[n + 1];
		
		System.out.println(go(memo, n));
		
		scan.close();
	}
	private static int go(int memo[], int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		
		if(memo[n] > 0)
			return memo[n];
		else{
			memo[n] = (go(memo, n - 1) + go(memo, n - 2)) % limit;
			return memo[n];
		}
	}
}
