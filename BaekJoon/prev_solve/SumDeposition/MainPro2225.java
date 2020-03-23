package prev_solve.SumDeposition;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro2225 {
	private static final float mod = 1000000000f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		scan.close();
		
		System.out.printf("%.0f", F(n, k));
	}
	public static float F(int n, int k){
		float memo[][] = new float[n+1][k+1];
		for(int i = 0;i <= n;i++){
			Arrays.fill(memo[i], -1);
		}
		return F(memo, n, k);
	}
	public static float F(float memo[][], int n, int k){
		/*
		 * F(n, k) : k개의 정수의 합이 n이 되는 갯수 
		 * F(n, k) = Sum(F(n, k - 1) + ... + F(n, 1))
		 * F(n, 1) = 1
		 * F(n, 0) = 0
		 * F(1, k) = k
		 * F(0, k) = 1
		 * */
		if(memo[n][k] != -1)
			return memo[n][k];
		if(k == 0)
			return 0;
		if(k == 1)
			return 1;
		if(n == 0)
			return 1;
		if(n == 1)
			return k;
		
		float ret = 0;
		for(int i = 0;i <= n;i++){
			ret += (F(memo, n - i, k - 1) % mod);
			ret %= mod;
		}
		return (memo[n][k] = ret);
	}
}
