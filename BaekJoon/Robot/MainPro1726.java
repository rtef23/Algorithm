package Robot;

import java.util.Scanner;

public class MainPro1726 {
	private static int dlen = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		boolean map[][] = new boolean[M][N];
		
		for(int i = 0;i < M;i++){
			for(int j = 0;j < N;j++){
				map[i][j] = (scan.nextInt() == 1);
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
		
		scan.close();
		
		
	}
	public static int F(boolean map[][], int M, int N, int start_point[], int end_point[]){
		int memo[][] = new int[M][N];
		
		for(int i = 0;i < dlen;i++){
			
		}
	}
	public static int min(int a, int b){
		return (a < b)?a:b;
	}
}
