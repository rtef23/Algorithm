package LikeFibbonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class MainPro14495 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		scan.close();
		System.out.printf("%s", F(n).toString());
	}
	public static BigInteger F(int n){
		HashMap<Integer, BigInteger> memo = new HashMap<>();
		return F(memo, n);
	}
	public static BigInteger F(HashMap<Integer, BigInteger> memo, int n){
		if(n <= 3){
			return BigInteger.ONE;
		}
		if(memo.containsKey(n)){
			return memo.get(n);
		}
		
		memo.put(n, F(memo, n-1).add(F(memo, n-3)));
		return memo.get(n);
	}
}