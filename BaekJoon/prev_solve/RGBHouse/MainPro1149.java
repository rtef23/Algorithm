package prev_solve.RGBHouse;

import java.util.Scanner;

public class MainPro1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int cost[][] = new int[n][3];
		
		for(int i = 0;i < n;i++)
			for(int j = 0;j < 3;j++)
				cost[i][j] = scan.nextInt();
		
		System.out.println(getSol(n, cost));
		
		scan.close();
	}
	private static int getSol(int n, int cost[][]){
		/*
		M[N] = min(M[N][R], M[N][G], M[N][B])
		M[N][C] : the cost when n th house is colored with C
		M[N][C] = min(M[n - 1][C'[1]], M[n - 1][C'[2]]) + Cost[N][C]
		*/
		int M[][] = new int[n + 1][3];//0 : R 1 : G 2 : B
		
		return min(go(n, 0, cost, M), go(n, 1, cost, M), go(n, 2, cost, M));
	}
	private static int go(int n, int color, int cost[][], int M[][]){
		if(n == 0)
			return 0;
		if(M[n][color] > 0)
			return M[n][color];
		M[n][color] = min(go(n - 1, (color + 1) % 3, cost, M), go(n - 1, (color + 2) % 3, cost, M)) + cost[n - 1][color];
		return M[n][color];
	}
	private static int min(int a, int b){
		return (a > b)? b:a;
	}
	private static int min(int a, int b, int c){
		return min(a, min(b, c));
	}
}
