package Sat2;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro11280 {
	private static final int dontcare = 0;
	private static final int t = 1;
	private static final int f = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int variables[] = new int[n];
		int clausers[][] = new int[m][2];
		
		Arrays.fill(variables, dontcare);
		for(int i = 0;i < m;i++){
			clausers[i][0] = scan.nextInt();
			clausers[i][1] = scan.nextInt();
		}
		
		scan.close();
		
		
	}
	public static boolean F(int n, int m, int variables[], int clausers[][]){
	}
}
