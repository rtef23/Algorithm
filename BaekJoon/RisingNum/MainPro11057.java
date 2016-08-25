package RisingNum;

import java.util.Scanner;

public class MainPro11057 {
	private static final int limit = 10007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		System.out.println(getSol(n));
		
		scan.close();
	}
	private static int getSol(int n){
		//M[n][l] = sum[i = 0 to 9](M[n - 1][i])
		int M[][] = new int[n + 1][10];
		int res = 0;
		
		for(int i = 0;i < 10;i++)
			M[1][i] = 1;
		
		for(int i = 0;i < 10;i++){
			res += go(M, n, i);
			res %= limit;
		}
		return res;
	}
	private static int go(int M[][], int n, int l){
		//n : length	l : last number
		if(n == 0)
			return 0;
		if(M[n][l] > 0)
			return M[n][l];
		//M[n][l] == 0
		for(int i = 0;i <= l;i++){
			M[n][l] += go(M, n - 1, i);
			M[n][l] %= limit;
		}
		return M[n][l];
	}
}
