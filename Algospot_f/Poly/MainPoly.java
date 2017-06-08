package Poly;

import java.util.Arrays;
import java.util.Scanner;

public class MainPoly {
	public static final int mod = 10000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			System.out.println(F(n));
		}
		scan.close();
	}
	public static int F(int n){
		int memo[][] = new int[n + 1][n + 1];
		int ret = 0;
		
		for(int i = 0;i < n + 1;i++)
			Arrays.fill(memo[i], -1);
		for(int i = 1;i <= n;i++){
			ret = (ret % mod + G(memo, n, i) % mod) % mod;
		}
		return ret;
	}
	public static int G(int memo[][], int n, int firstWidth){
		if(n == 0 || firstWidth > n)
			return 0;
		if(n == firstWidth)
			return 1;
		if(memo[n][firstWidth] != -1)
			return memo[n][firstWidth];
		int ret = 0;
		for(int i = 1;i <= n;i++){
			ret = (ret % mod + (((firstWidth + i - 1) % mod) * (G(memo, n - firstWidth, i) % mod)) % mod) % mod;
		}
		memo[n][firstWidth] = ret;
		return memo[n][firstWidth];
	}
}
