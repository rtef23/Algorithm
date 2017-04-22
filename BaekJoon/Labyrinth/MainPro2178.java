package Labyrinth;

import java.util.Scanner;

public class MainPro2178 {
	private static final int dlen = 4;
	private static final int dx[] = {-1, 0, 1, 0};
	private static final int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n, m;
		boolean map[][];
		String input;
		
		n = scan.nextInt();
		m = scan.nextInt();
		
		map = new boolean[n][m];
		for(int i = 0;i < n;i++){
			input = scan.next();
			for(int j = 0;j < m;j++){
				map[i][j] = (input.charAt(j) == '1')?true:false;
			}
		}
		
		System.out.println(computeWay(map, n, m));
		
		scan.close();
	}
	public static int computeWay(boolean map[][], int n, int m){
		int memo[][] = new int[n][m];
		memo[0][0] = 1;
		return computeWay(map, n, m, memo, 1);
	}
	public static int computeWay(boolean map[][], int n, int m, int memo[][], int depth){
		if(memo[n-1][m-1] != 0){
			return memo[n-1][m-1];
		}
		
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				if(memo[i][j] == depth){
					for(int k = 0;k < dlen;k++){
						int target_y = i + dy[k];
						int target_x = j + dx[k];
						
						if(target_x < 0 || target_x >= m){
							continue;
						}
						if(target_y < 0 || target_y >= n){
							continue;
						}
						if(!map[target_y][target_x] || memo[target_y][target_x] != 0){
							continue;
						}
						memo[target_y][target_x] = depth+1;
					}
				}
			}
		}
		return computeWay(map, n, m, memo, depth+1);
	}
}
