package BoardCover;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MainBoardCover {
	static final int way[][][] = {
								  {{0, 0}, {1, 0}, {1, 1}},
								  {{0, 0}, {0, 1}, {1, 1}},
								  {{0, 0}, {0, 1}, {-1, 1}},
								  {{0, 0}, {1, 0}, {0, 1}}
								 };
	static int wayCnt = 4;
	static int blockSize = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringTokenizer tok;
		int t = Integer.parseInt(scan.nextLine().trim());
		for(int i = 0;i < t;i++){
			int h, w;
			String line = scan.nextLine().trim();
			tok = new StringTokenizer(line, " ");
			h = Integer.parseInt(tok.nextToken());
			w = Integer.parseInt(tok.nextToken());
			boolean board[][] = new boolean[h][w];
			for(int j = 0;j < h;j++){
				line = scan.nextLine().trim();
				for(int k = 0;k < w;k++){
					board[j][k] = (line.charAt(k) == '.');
				}
			}
//			System.out.println(Arrays.deepToString(board).replace("],", "],\n"));
			System.out.println(F(board, h, w));
		}
	}
	public static int F(boolean board[][], int h, int w){
		int restWhite = countWhite(board, h, w);
		if(restWhite % blockSize != 0){
			return 0;
		}
		return F(board, h, w, restWhite);
	}
	public static int F(boolean board[][], int h, int w, int restWhite){
		if(restWhite == 0)
			return 1;
		int res = 0;
		int target_x, target_y;
		target_x = target_y = 0;

		for(int i = 0;i < h;i++){
			for(int j = 0;j < w;j++){
				if(board[i][j]){
					target_x = j;
					target_y = i;
					j = w;
					i = h;
				}
			}
		}
		for(int i = 0;i < wayCnt;i++){
			if(set(board, way[i], target_x, target_y, w, h, false)){
				res += F(board, h, w, restWhite - blockSize);
				set(board, way[i], target_x, target_y, w, h, true);
			}
		}
		return res;
	}
	
	public static boolean set(boolean board[][], int block[][], int x, int y, int w, int h, boolean value){
		for(int i = 0;i < blockSize;i++){
			int tx = x + block[i][0];
			int ty = y + block[i][1];
			if(tx < 0 || tx >= w || ty < 0 || ty >= h){
				return false;
			}
			if(board[ty][tx] == value){
				return false;
			}
		}
		for(int i = 0;i < blockSize;i++){
			board[y + block[i][1]][x + block[i][0]] = value;
		}
		return true;
	}
	public static int countWhite(boolean board[][], int h, int w){
		int cnt = 0;
		for(int i = 0;i < h;i++)
			for(int j = 0;j < w;j++)
				if(board[i][j])
					cnt++;
		return cnt;
	}
	
}
