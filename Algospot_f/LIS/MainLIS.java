package LIS;

import java.util.Arrays;
import java.util.Scanner;

public class MainLIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int S[] = new int[n];
			for(int j = 0;j < n;j++){
				S[j] = scan.nextInt();
			}
			System.out.println(F(S));
		}
		scan.close();
	}
	public static int F(int S[]){
		int ret = 0;
		int memo[] = new int[S.length];
		Arrays.fill(memo, -1);
		for(int i = 0;i < S.length;i++){
			ret = max(ret, F(S, memo, i));
		}
		return ret;
	}
	public static int F(int S[], int memo[], int i){
		if(i <= 0)
			return 1;
		if(memo[i] != -1)
			return memo[i];
		int ret = 0;
		for(int j = 0;j < i;j++){
			if(S[j] >= S[i])
				continue;
			ret = max(ret, F(S, memo, j));
		}
		memo[i] = ret + 1;
		return memo[i];
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
