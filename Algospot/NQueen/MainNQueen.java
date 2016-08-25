package NQueen;

import java.util.Arrays;
import java.util.Scanner;

public class MainNQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();

		for (int i = 0; i < t; i++) {
			int n;// size of chess board
			n = scan.nextInt();

			System.out.println();
			System.out.println(getSol(n));
		}

		scan.close();
	}

	private static int getSol(int n) {
		int chess_board[][][] = new int[n][n][n];

		for (int i = 0; i < n; i++)
			chess_board[i][0][i] = 1;

		for (int i = 0; i < n; i++)
			goWay(1, 0, n, chess_board[i]);

		int res = 0;
		for(int i = 0;i < n;i++){
			for(int x = 0;x < n;x++){
				res += chess_board[i][n - 1][x];
			}
		}
		System.out.println(Arrays.deepToString(chess_board).replace("[", "").replace("]", "\n"));
		System.out.println(res);
		return 0;
	}

	private static void goWay(int queen, int cur_line, int n, int memo[][]) {
		if (cur_line >= n)
			return;
		for (int x = 0; x < n; x++) {
			if (memo[cur_line][x] >= queen) {
				
			}
		}
		goWay(queen + 1, cur_line + 1, n, memo);
	}
}
