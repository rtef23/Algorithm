package prev_solve.wannaBeMotherKing;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro2775 {
	private static final int MAX_NUM = 14;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int map[][] = new int[MAX_NUM + 1][MAX_NUM];
		
		for(int i = 0;i < MAX_NUM;i++)
			map[0][i] = i + 1;
		for(int i = 1;i < MAX_NUM + 1;i++){
			Arrays.fill(map[i], -1);
		}
		
		for(int i = 0;i < t;i++){
			int k = scan.nextInt();
			int n = scan.nextInt();
			System.out.println(F(map, k, n - 1));
		}
		
		scan.close();
	}

	public static int F(int[][] map, int k, int n){
		if(map[k][n] >= 0){
			return map[k][n];
		}
		int t = 0;
		for(int i = 0;i <= n;i++){
			t += F(map, k - 1, i);
		}
		map[k][n] = t;
		return map[k][n];
	}
}
