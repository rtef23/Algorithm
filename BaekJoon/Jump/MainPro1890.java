package Jump;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro1890 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int map[][] = new int[n][n];
		int memo[][] = new int[n][n];


		for(int i = 0;i < n;i++){
			Arrays.fill(memo[i], -1);
			for(int j = 0;j < n;j++){
				map[i][j] = scan.nextInt();
			}
		}
		
		System.out.printf("%d", F(map, memo, n));
		scan.close();
	}
	public static int F(int map[][], int memo[][], int n){
		//O(n^4), n <= 100 simillar to 10^8
		/*
		 * P(i, j) : return the number of method that from (0, 0) to (i, j)
		 * P(i, j) = sum[x <= i, y <= j]((i + map[x][y] == x && j == y) || (i == x && j + map[x][y] == y))?P(x, y):0
		 * */
		memo[0][0] = 1;
		return P(map, memo, n - 1, n - 1);
	}
	public static int P(int map[][], int memo[][], int i, int j){
		if(memo[i][j] >= 0){
			return memo[i][j];
		}
		int cnt = 0;
		for(int x = 0;x <= i;x++){
			for(int y = 0;y <= j;y++){
				if(x == i && y == j){
					continue;
				}
				if((x + map[x][y] == i && y == j) || (x == i && y + map[x][y] == j)){
					cnt += P(map, memo, x, y);
				}
			}
		}
		memo[i][j] = cnt;
		return memo[i][j];
	}
}
