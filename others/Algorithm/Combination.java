package Algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();//factorial map
		
		for(int i = 0;i < testcase;i++){
			int n = scan.nextInt();
			int k = scan.nextInt();
			System.out.printf("%dC%d = %d\t", n, k, nCk(map, n, k));
		}
		
		
		scan.close();
	}
	public static int factorial(HashMap<Integer, Integer>map, int t){
		/* Dynamic Programing 
		 * return t!, t should LTE zero(0)
		 * F(t) = F(t - 1) * t
		 * F(1) = F(0) = 1
		 * */
		if(t <= 1)
			return 1;
		if(map.containsKey(t))
			return map.get(t);
		map.put(t, factorial(map, t - 1) * t);
		return map.get(t);
	}
	public static int nCk(HashMap<Integer, Integer> map, int n, int k){
		if(n == 0 || k == 0){
			return 1;
		}
		int n_fac = factorial(map, n);
		int k_fac = factorial(map, k);
		int n_k_fac = factorial(map, n - k);
		return n_fac / (k_fac * n_k_fac);
	}
}
