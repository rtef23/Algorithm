package SumOfPartialSet;

import java.util.HashMap;
import java.util.Scanner;

public class MainPro1182 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int s = scan.nextInt();
		int set[] = new int[n];
		
		for(int i = 0;i < n;i++)
			set[i] = scan.nextInt();
	
		System.out.println(F(n, s, set));
		
		scan.close();
	}
	public static int F(int n, int s, int set[]){
		
	}
	public static int S(HashMap<Integer, HashMap<Integer, Integer>>memo, int s, int n, int set[]){
		/*
		 e[n] : n th element
		 S[n, s] : when with n elements, return the number of set which sum is s
		 S[n, s] = S[n - 1, s - e[n]] + S[n - 1, s]
		 S[0, s] = 0
		 * */
	}
}
