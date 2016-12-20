package SugarShuttle;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro2839 {
	private static final int inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int arr[] = new int[n + 1];
		
		Arrays.fill(arr, inf);
		System.out.printf("%d\n", F(n, arr));
		
		scan.close();
	}
	public static int F(int n, int memo[]){
		if(n < 0)
			return -1;
		if(n == 0)
			return 0;
		if(memo[n] != inf)
			return memo[n];
		int tmp = min(F(n - 3, memo), F(n - 5, memo));
		if(tmp < 0)
			memo[n] = -1;
		else
			memo[n] = tmp + 1;
		return memo[n];
	}
	public static int min(int a, int b){
		if(a < 0 && b < 0)
			return -1;
		if(a < 0)
			return b;
		if(b < 0)
			return a;
		return (a > b)? b:a;
	}
}