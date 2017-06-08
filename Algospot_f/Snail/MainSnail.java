package Snail;

import java.util.Arrays;
import java.util.Scanner;

public class MainSnail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int m = scan.nextInt();
			System.out.printf("%.10f\n", F(n, m));
		}
		scan.close();
	}
	public static double F(int n, int m){
		double memo[][] = new double[n + 1][m + 1];
		for(int i = 0;i < n + 1;i++)
			Arrays.fill(memo[i], -1);
		return F(memo, n, m, 0, 0);
	}
	public static double F(double memo[][], int n, int m, int curN, int curM){
		if(curN >= n && curM <= m)
			return 1;
		if(curM > m)
			return 0;
		if(memo[curN][curM] != -1)
			return memo[curN][curM];
		memo[curN][curM] = 0.75 * F(memo, n, m, curN + 2, curM + 1) + 
						   0.25 * F(memo, n, m, curN + 1, curM + 1);
		return memo[curN][curM];
	}
}
