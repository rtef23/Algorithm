package TripathCnt;

import java.util.Arrays;
import java.util.Scanner;

public class MainTriPathCnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int tri[][] = new int[n][];
			for(int j = 0;j < n;j++){
				tri[j] = new int[j + 1];
				for(int k = 0;k <= j;k++){
					tri[j][k] = scan.nextInt();
				}
			}
			System.out.println(F(n, tri));
		}
		scan.close();
	}
	public static int F(int n, int tri[][]){
		int Gmemo[][] = new int[n][];
		int Fmemo[][] = new int[n][];
		for(int i = 0;i < n;i++){
			Fmemo[i] = new int[i + 1];
			Gmemo[i] = new int[i + 1];
			Arrays.fill(Gmemo[i], -1);
			Arrays.fill(Fmemo[i], -1);
		}
		return F(Fmemo, Gmemo, n, tri, 0, 0);
	}
	public static int F(int Fmemo[][], int Gmemo[][], int n, int tri[][], int x, int y){
		if(y == n - 1){
			return 1;
		}
		if(Fmemo[y][x] != -1){
			return Fmemo[y][x];
		}
		if(G(Gmemo, n, tri, x + 1, y + 1) > G(Gmemo, n, tri, x, y + 1)){
			Fmemo[y][x] = F(Fmemo, Gmemo, n, tri, x + 1, y + 1); 
		}else if(G(Gmemo, n, tri, x + 1, y + 1) == G(Gmemo, n, tri, x, y + 1)){
			Fmemo[y][x] = F(Fmemo, Gmemo, n, tri, x, y + 1) + F(Fmemo, Gmemo, n, tri, x + 1, y + 1);
		}else{
			Fmemo[y][x] = F(Fmemo, Gmemo, n, tri, x, y + 1);
		}
		return Fmemo[y][x];
	}
	public static int G(int Gmemo[][], int n, int tri[][], int x, int y){
		if(y == n - 1){
			return tri[y][x];
		}
		if(Gmemo[y][x] != -1){
			return Gmemo[y][x];
		}
		Gmemo[y][x] = max(G(Gmemo, n, tri, x + 1, y + 1), G(Gmemo, n, tri, x, y + 1)) + tri[y][x];
		return Gmemo[y][x];
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
