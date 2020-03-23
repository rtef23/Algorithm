package prev_solve.Dictionary;

import java.util.Scanner;

public class MainPro1256 {
	private static final int notExt = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		
		scan.close();
		float p = P(n+m, n);
		if(p < k){
			System.out.println(notExt);
		}else{
			
		}
	}
	public static float P(int f, int b){
		float res = 1;
		for(int i = b+1;i <= f;i++){
			res *= i;
		}
		return res / factorial(f-b);
	}
	public static float factorial(int n){
		float res = 1;
		for(int i = n;i > 1;i--){
			res *= i;
		}
		return res;
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
