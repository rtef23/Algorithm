package Robot;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro1726 {
	private static int IMPOSSIBLE = 99999;
	private static int dlen = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		boolean map[][] = new boolean[M][N];
		
		for(int i = 0;i < M;i++){
			for(int j = 0;j < N;j++){
				map[i][j] = (scan.nextInt() == 0);
			}
		}
		int start_point[] = new int[3];
		int end_point[] = new int[3];
		
		start_point[0] = scan.nextInt();
		start_point[1] = scan.nextInt();
		start_point[2] = scan.nextInt();
		
		end_point[0] = scan.nextInt();
		end_point[1] = scan.nextInt();
		end_point[2] = scan.nextInt();
		System.out.println(F(map, M, N, start_point, end_point));
		scan.close();
		
		
	}
	public static int F(boolean map[][], int M, int N, int start_point[], int end_point[]){
		int memo[][][] = new int[M][N][4];
		
		for(int i = 0;i < M;i++){
			for(int j = 0;j < N;j++){
				for(int k = 0;k < 4;k++){
					memo[i][j][k] = -1;
				}
			}
		}
		
		/*
		 * 0 : East
		 * 1 : West
		 * 2 : South
		 * 3 : North
		 * */
//		System.out.println(Arrays.deepToString(memo).replace("]],", "]],\n"));
		int ret = IMPOSSIBLE;
		int curX = start_point[1];
		int curY = start_point[0];
		int curDir = start_point[2] - 1;
		int destiX = end_point[1];
		int destiY = end_point[0];
		int destiDir = end_point[2] - 1;

		
		return Go(memo, map, curX, curY, curDir, destiX, destiY, destiDir);
	}
	public static int Go(int memo[][][], boolean map[][], int curX, int curY, int curDir, int destiX, int destiY, int destiDir){
		
	}
	public static int turnLeft(int dir){
		int ret;
		switch (dir) {
		case 0://east
			ret = 3;
			break;
		case 1://west
			ret = 2;
			break;
		case 2://south
			ret = 0;
			break;
		default://3, north
			ret = 1;
			break;
		}
		return ret;
	}
	public static int turnRight(int dir){
		int ret;
		switch (dir) {
		case 0:
			ret = 2;
			break;
		case 1:
			ret = 3;
			break;
		case 2:
			ret = 1;
			break;
		default:
			ret = 0;
			break;
		}
		return ret;
	}
	public static int min(int a, int b){
		return (a < b)?a:b;
	}
}
