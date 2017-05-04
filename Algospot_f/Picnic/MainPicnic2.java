package Picnic;

import java.util.Arrays;
import java.util.Scanner;

public class MainPicnic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int m = scan.nextInt();
			boolean mate[][] = new boolean[n][n];
			
			for(int j = 0;j < n;j++){
				Arrays.fill(mate[j], false);				
			}
			for(int j = 0;j < m;j++){
				int n1,n2;
				n1 = scan.nextInt();
				n2 = scan.nextInt();
				mate[n1][n2] = mate[n2][n1] = true;
			}
			System.out.println(F(mate, n, m));
		}
		
		
		scan.close();
	}
	public static int F(boolean mate[][], int n, int m){
		//return the number of mating
		
	}

}
