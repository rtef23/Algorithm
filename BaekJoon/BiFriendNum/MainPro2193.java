package BiFriendNum;

import java.util.Scanner;

public class MainPro2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		System.out.println(getSol(n));

		scan.close();
	}

	private static long getSol(int n) {
		long memo[][] = new long[n + 1][2];
		memo[1][1] = 1;

		return go(memo, n, 0) + go(memo, n, 1);
	}

	private static long go(long M[][], int n, int l) {
		/*
		 M[n] = M[n][0] + M[n][1]
		 	M[n][0] = M[n - 1][0] + M[n - 1][1]
		 	M[n][1] = M[n - 1][0]
		 * */
		if (n <= 0 || (n == 1 && l == 0))
			return 0;
		if (M[n][l] > 0)
			return M[n][l];
		if (l == 1) {
			M[n][l] = go(M, n - 1, 0);
			return M[n][l];
		} else {//l == 0
			M[n][l] = go(M, n - 1, 0) + go(M, n - 1, 1);
			return M[n][l];
		}
	}
}
