package Combination;

import java.util.HashMap;
import java.util.Scanner;

public class MainPro11051 {
	private static int limit = 10007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		scan.close();
		
		System.out.println(Combination(n, k));
	}
	public static int Combination(int n, int k){
		if(k > n || k < 0){
			return 0;
		}
		HashMap<Integer, Integer>memo = new HashMap<>();
		return ((factorial(memo, n) % limit) * (modReverse(((factorial(memo, k) * factorial(memo, (n-k)) % limit)), limit) % limit) % limit);
	}
	public static int factorial(HashMap<Integer, Integer>memo, int n){
		if(n == 1 || n == 0){
			return 1;
		}
		if(memo.containsKey(n)){
			return memo.get(n);
		}
		memo.put(n, (factorial(memo, n-1) * n) % limit);
		return memo.get(n);
	}
	public static int modReverse(int n, int p){
		for(int i = 0;i <= p;i++){
			if((n * i) % p == 1){
				return i;
			}
		}
		return -1;
	}
}
