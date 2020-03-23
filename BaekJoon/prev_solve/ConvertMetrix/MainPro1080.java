package prev_solve.ConvertMetrix;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPro1080 {
	public static final int impossible = -1;
	public static final int dlen = 9;
	public static final int dx[] = {0, 1, 2, 0, 1, 2, 0, 1, 2};
	public static final int dy[] = {0, 0, 0, 1, 1, 1, 2, 2, 2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line;
		int n, m;
		
		line = scan.nextLine();
		StringTokenizer tok = new StringTokenizer(line, " ");
		n = Integer.parseInt(tok.nextToken());
		m = Integer.parseInt(tok.nextToken());
		boolean metrixA[][] = new boolean[n][m];
		boolean metrixB[][] = new boolean[n][m];
		
		for(int i = 0;i < 2;i++){
			boolean target[][] = (i == 0)?metrixA:metrixB;
			for(int j = 0;j < n;j++){
				line = scan.nextLine();
				for(int k = 0;k < m;k++){
					target[j][k] = (line.charAt(k) == '1');
				}
			}
		}
		
		System.out.println(F(metrixA, metrixB, n, m));
		
		scan.close();
	}
	public static int F(boolean metrixA[][], boolean metrixB[][], int n, int m){
		//Greedy
		int min_count = 0;
		
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				if(isSameMetrix(metrixA, metrixB, n, m)){
					return min_count;
				}
				if(metrixA[i][j] != metrixB[i][j]){
					if(canBeConvert(j, i, n, m)){
						convertMetrix(metrixA, j, i);
						min_count++;
					}else{
						return impossible;
					}
				}
			}
		}
		return impossible;
	}
	public static int min(int a, int b){
		return (a < b)?a:b;
	}
	public static boolean isSameMetrix(boolean metrixA[][], boolean metrixB[][], int n, int m){
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				if(metrixA[i][j] != metrixB[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	public static void convertMetrix(boolean metrix[][], int left_up_x, int left_up_y){
		for(int i = 0;i < dlen;i++){
			metrix[left_up_y + dy[i]][left_up_x + dx[i]] = !metrix[left_up_y + dy[i]][left_up_x + dx[i]];
		}
	}
	public static boolean canBeConvert(int left_up_x, int left_up_y, int n, int m){
		return (m - left_up_x < 3 || n - left_up_y < 3)?false:(left_up_x < 0 || left_up_y < 0)?false:true;
	}
}
