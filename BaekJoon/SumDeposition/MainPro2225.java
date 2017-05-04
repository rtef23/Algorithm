package SumDeposition;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro2225 {
	private static final float limit = 1000000000f;
	private static final float init = -1f;
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
			Arrays.fill(memo[i], init);
		}
		return F(memo, n, k);
	}
	public static float F(float memo[][], int n, int k){
		if(memo[n][k] != init){
			return memo[n][k];
		}
		if(k <= 1 || n <= 0){
			return 1;
		}
		int cnt = 0;
		int mid = (n % 2 == 0)?n/2-1:n/2;
		for(int i = 0;i <= mid;i++){
			for(int j = 1;j < k;j++){
				cnt += (2 * ((F(memo, i, k-j) % limit) * (F(memo, n-i, j) % limit))) % limit;
				cnt %= limit;
			}
		}
		if(n % 2 == 0){
			for(int j = 1;j < k;j++){
				cnt += (F(memo, n/2, k - j) % limit) * (F(memo, n/2, j) % limit) % limit;
				cnt %= limit;
			}
		}
		memo[n][k] = cnt;
		return memo[n][k];
	}
}
