package TrianglePath;

import java.util.Arrays;
import java.util.Scanner;

public class MainTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int tri[][] = new int[n][];
			for(int j = 0;j < n;j++){
				tri[j] = new int[j + 1];
				for(int k = 0;k <= j;k++){
					tri[j][k] = scan.nextInt();
				}
			}
			System.out.println(F(tri, n));
		}
		scan.close();
	}
	public static int F(int tri[][], int n){
		int memo[][] = new int[n][];
		for(int i = 0;i < n;i++){
			memo[i] = new int[i + 1];
			Arrays.fill(memo[i], -1);
		}
		return F(tri, n, memo, n-1);
	}
	public static int F(int tri[][], int n, int memo[][], int y){
		int ret = 0;
		for(int i = 0;i <= y;i++)
			ret = max(ret, F(tri, n, memo, i, y));
		return ret;
	}
	public static int F(int tri[][], int n, int memo[][], int x, int y){
		if(x == 0 && y == 0){
			return tri[0][0];
		}
		if(x < 0 || y < 0)
			return -1;
		if(x > y)
			return -1;
		if(memo[y][x] != -1){
			return memo[y][x];
		}
		memo[y][x] = max(F(tri, n, memo, x, y-1), F(tri, n, memo, x-1, y-1)) + tri[y][x];
		return memo[y][x];
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
