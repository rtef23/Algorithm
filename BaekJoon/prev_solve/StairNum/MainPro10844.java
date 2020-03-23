package prev_solve.StairNum;

import java.util.Scanner;

public class MainPro10844 {
	private static final int limit = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		int memo[][] = new int[n + 1][10];
		
		memo[1][1] = 1;
		memo[1][2] = 1;
		memo[1][3] = 1;
		memo[1][4] = 1;
		memo[1][5] = 1;
		memo[1][6] = 1;
		memo[1][7] = 1;
		memo[1][8] = 1;
		memo[1][9] = 1;

		System.out.println(getSol(memo, n));

		scan.close();
	}

	private static int getSol(int memo[][], int n) {
		int res = 0;
		for (int i = 0; i < 10; i++){
			res += go(memo, n, i);
			res %= limit;
		}
		return res;
	}

	private static int go(int memo[][], int n, int l) {
		// n : length l : last number
		if(n == 0)
			return 0;
		if(l == 0){
			if(memo[n][l] > 0)
				return memo[n][l];
			memo[n][l] = go(memo, n - 1, l + 1);
			return memo[n][l];
		}else if(l == 9){
			if(memo[n][l] > 0)
				return memo[n][l];
			memo[n][l] = go(memo, n - 1, l - 1);
			return memo[n][l];
		}else{
			if(memo[n][l] > 0)
				return memo[n][l];
			memo[n][l] = (go(memo, n - 1, l - 1) + go(memo, n - 1, l + 1)) % limit;
			return memo[n][l];
		}
	}
}
