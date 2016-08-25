package Moving;

import java.util.Scanner;

public class MainPro11048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int map[][] = new int[n][m];
		int M[][] = new int[n][m];
		
		for(int i = 0;i < n;i++)
			for(int j = 0;j < m;j++){
				map[i][j] = scan.nextInt();
				M[i][j] = -1;
			}
		
		System.out.println(getSol(n, m, map, M));
		
		scan.close();
	}
	private static int getSol(int n, int m, int map[][], int M[][]){
		/*
		 * return the number of candy which obtains going to map[N][M]
		 * start index : 0, 0
		 * destination index : n - 1, m - 1
		 * way : (i + 1, j), (i, j + 1), (i + 1, j + 1)
		 * M[i][j] : return the maximum number of candy from (0, 0) to (i - 1, j - 1)
		 * M[i][j] = MAX(M[i - 1][j], M[i][j - 1], M[i - 1][j - 1]) + map[i][j]
		 * //actually moving to (i-1, j-1) is not useful, because (i - 1, j) -> (i, j - 1) or (i, j - 1) -> (i - 1, j) > (i - 1, j - 1)
		 * */
		return go(map, M, n, m, n - 1, m - 1);
	}
	private static int go(int map[][], int M[][], int n, int m, int cur_x, int cur_y){
		if(cur_x < 0 || cur_x >= n)
			return 0;
		if(cur_y < 0 || cur_y >= m)
			return 0;
		if(M[cur_x][cur_y] >= 0)
			return M[cur_x][cur_y];
		M[cur_x][cur_y] = max(go(map, M, n, m, cur_x - 1, cur_y), go(map, M, n, m, cur_x, cur_y - 1), go(map, M, n, m, cur_x - 1, cur_y - 1)) + map[cur_x][cur_y];
		return M[cur_x][cur_y];
	}
	private static int max(int a, int b, int c){
		return max(a, max(b, c));
	}
	private static int max(int a, int b){
		return (a > b)? a:b;
	}
}
