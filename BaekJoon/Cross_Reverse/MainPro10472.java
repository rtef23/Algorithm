package Cross_Reverse;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPro10472 {
	private static int dx[] = {-1, 0, 0, 1};
	private static int dy[] = {-1, 0, 0, 1};
	private static final Character[][] all_white = 
		{
			{'.', '.', '.'},
			{'.', '.', '.'},
			{'.', '.', '.'}
		};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		Character given_board[][];
		
		for(int i = 0;i < t;i++){
			given_board = new Character[3][3];
			for(int j = 0;j < 3;j++){
				char[] ttmp = scan.next().toCharArray(); 
				for(int k = 0;k < 3;k++)
					given_board[j][k] = ttmp[k];
			}
			System.out.println(getSol(given_board));
		}
		
		scan.close();
	}
	private static int getSol(Character given_board[][]){
		/*
		 * * : black
		 * . : white
		 * initial board state is all white
		 * return the minimum number of click to change the board state from initial state to given board state
		 * 
		 * */
		ArrayList<Character[][]> memo_board = new ArrayList<>();
		memo_board.add(all_white);
		return go(memo_board, given_board, 0);
	}
	private static int go(ArrayList<Character[][]> memo_board, Character given_board[][], int cnt){
		/*
		 * using BFS, find minimum click count
		 * */
		System.out.printf("go cnt : %d\n", cnt);
		for(Character[][] a : memo_board)
			if(isEqualBoard(a, given_board))
				return cnt;
		
		ArrayList<Character[][]> new_memo = new ArrayList<>();
		for(int i = 0;i < memo_board.size();i++){
			Character tmp[][] = memo_board.get(i);
			for(int j = 0;j < 3;j++){
				for(int k = 0;k < 3;k++){
					Character ttmp[][] = tmp.clone();
					flip(ttmp, j, k);
					new_memo.add(ttmp);
				}
			}
		}
		memo_board = new_memo;
		
		return go(memo_board, given_board, cnt + 1);
	}
	private static void flip(Character board[][], int cur_x, int cur_y){
		for(int i = 0;i < 4;i++){
			if(cur_x + dx[i] >= 0 && cur_x + dx[i] <= 2 && cur_y + dy[i] >= 0 && cur_y + dy[i] <= 2)
				board[cur_x + dx[i]][cur_y + dy[i]] = (board[cur_x + dx[i]][cur_y + dy[i]] == '.')? '*':'.';
		}
		board[cur_x][cur_y] = (board[cur_x][cur_y] == '.')?'*':'.';
	}
	private static boolean isEqualBoard(Character[][] a, Character[][] b){
		for(int i = 0;i < 3;i++)
			for(int j = 0;j < 3;j++)
				if(a[i][j] != b[i][j])
					return false;
		return true;
	}
}
