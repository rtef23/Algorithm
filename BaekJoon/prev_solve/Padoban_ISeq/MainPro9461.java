package prev_solve.Padoban_ISeq;

import java.util.Scanner;

public class MainPro9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i = 0;i < t;i++)
			System.out.println(getSol(scan.nextInt()));
		
		scan.close();
	}
	private static long getSol(int n){
		/*
		 * P[n] : the length of line which is on the spiral
		 * P[n] = P[n - 1] + P[n - 5]
		 * 
		 * P[1] = 1
		 * P[2] = 1
		 * P[3] = 1
		 * P[4] = 2
		 * P[5] = 2
		 * */
		long P[] = new long[n + 1];
		
		return go(P, n);
	}
	private static long go(long P[], int n){
		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 1;
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 2;
		default://0
			break;
		}
		if(P[n] > 0)
			return P[n];
		P[n] = go(P, n - 1) + go(P, n - 5);
		return P[n];
	}
}
