package Asymtiling;

import java.util.Arrays;
import java.util.Scanner;

public class MainAsymTiling {
	public static double mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			System.out.printf("%.0f\n", S(n));
		}
		scan.close();
	}
	public static double S(int n){
		double memo[] = new double[n + 1];
		Arrays.fill(memo, -1);
		double ret = F(memo, n);
		ret = (ret - G(memo, n) + mod) % mod;
		return ret;
	}
	public static double F(double memo[], int n){
		if(memo[n] != -1){
			return memo[n];
		}
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		
		memo[n] = (F(memo, n - 1) + F(memo, n - 2)) % mod;
		return memo[n];
	}
	public static double G(double memo[], int n){
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(n % 2 == 0)
			return (F(memo, (n - 2) / 2) + F(memo, n / 2)) % mod;
		else
			return F(memo, (n - 1) / 2) % mod;
		
	}
}
