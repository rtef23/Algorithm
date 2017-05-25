package GreedyPanda;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro1937 {
	private static final int dx[] = {-1, 0, 1, 0};
	private static final int dy[] = {0, -1, 0, 1};
	private static final int dlen = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int map[][] = new int[n][n];
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				map[i][j] = scan.nextInt();
			}
		}
		scan.close();
		System.out.println(F(map, n));
	}
	public static int F(int map[][], int n){
		int memo[][] = new int[n][n];
		
		for(int i = 0;i < n;i++){
			Arrays.fill(memo[i], -1);
		}
		
		int max = -1;
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				int tmp = G(map, memo, j, i, n);
				max = (tmp > max)?tmp:max;
			}
		}
		return max;
	}
	public static int G(int map[][], int memo[][], int x, int y, int n){
		if(x < 0 || y < 0){
			return 0;
		}
		if(x >= n || y >= n){
			return 0;
		}
		if(memo[y][x] != -1){
			return memo[y][x];
		}
		
		int max = 0;
		for(int i = 0;i < dlen;i++){
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(tx < 0 || tx >= n || ty < 0 || ty >= n){
				continue;
			}
			if(map[y][x] >= map[ty][tx]){
				continue;
			}
			int tmp = G(map, memo, tx, ty, n);
			max = (max < tmp)?tmp:max;
		}
		memo[y][x] = max + 1;
		return memo[y][x];
	}
}
