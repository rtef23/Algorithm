package prev_solve.NthFibonacci;

import java.util.Scanner;

public class MainPro10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		System.out.println(getNthFibonacci(n));
		
		scan.close();
	}
	private static int getNthFibonacci(int n){
		int M[] = new int[n + 1];
		
		//initialize
		if(n > 0)
			M[1] = 1;
		
		return (n < 2)? M[n]:go(M, n);
	}
	private static int go(int M[], int n){
		//M[n] = M[n - 1] + M[n - 2]
		if(n <= 0)
			return 0;
		if(M[n] > 0)
			return M[n];
		M[n]  = go(M, n - 1) + go(M, n - 2);
		return M[n];
	}
}
