package JLIS;

import java.util.Arrays;
import java.util.Scanner;

public class MainJLIS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int m = scan.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for(int j = 0;j < n;j++)
				a[j] = scan.nextInt();
			for(int j = 0;j < m;j++)
				b[j] = scan.nextInt();
			System.out.println(F(a, b));
		}
		scan.close();
	}
	public static int F(int a[], int b[]){
		int memo[][] = new int[a.length][b.length];
		for(int i = 0;i < a.length;i++)
			Arrays.fill(memo[i], -1);
		int ret = 0;
		for(int i = 0;i < a.length;i++){
			for(int j = 0;j < b.length;j++){
				ret = max(ret, F(a, b, memo, i, j));
			}
		}
		System.out.println(Arrays.deepToString(memo).replace("],", "],\n"));
		return ret;
	}
	public static int F(int a[], int b[], int memo[][], int i, int j){
		if(i == 0 && j == 0){
			return (a[i] == b[j])?1:2;
		}
		if(memo[i][j] >= 0)
			return memo[i][j];
		int ret = 0;
		int minVal = min(a[i], b[j]);
		for(int k = 0;k < i;k++){
			if(minVal >= a[k])
				continue;
			ret = max(ret, F(a, b, memo, k, j));
		}
		for(int k = 0;k < j;k++){
			if(minVal >= b[k])
				continue;
			ret = max(ret, F(a, b, memo, i, k));
		}
		memo[i][j] = ret + 1;
		return memo[i][j];
	}
	public static int min(int a, int b){
		return (a > b)?b:a;
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
