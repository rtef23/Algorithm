package Tiling2;

import java.util.Arrays;
import java.util.Scanner;

public class MainTiling2 {
	public static final double mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			System.out.println((int)F(n));
		}
		scan.close();
	}
	public static double F(int n){
		double memo[] = new double[n + 1];
		Arrays.fill(memo, -1);
		return F(memo, n);
	}
	public static double F(double memo[], int n){
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		if(memo[n] != -1)
			return memo[n];
		memo[n] = ((F(memo, n - 1)) + (F(memo, n - 2))) % mod;
		return memo[n];
	}
}
