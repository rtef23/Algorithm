package prev_solve.kaingCal;

import java.util.HashMap;
import java.util.Scanner;

public class MainPro6064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int T;
		int M, N, x, y;
		
		T = scan.nextInt();
		
		for(int i = 0;i < T;i++){
			M = scan.nextInt();
			N = scan.nextInt();
			x = scan.nextInt();
			y = scan.nextInt();
	
			System.out.printf("%d\n", F(M, N, x, y));
		}
		scan.close();
	}
	public static int F(int m, int n, int x, int y){
		/*
		 * X(k) = (X(k-1) % (m - 1)) + 1
		 * Y(k) = (Y(k-1) % (n - 1)) + 1
		 * 
		 * X(k) - 1 = X(k - 1) % (m - 1)
		 * Y(k) - 1 = Y(k - 1) % (n - 1)
		 * 
		 * X(1) = 1
		 * Y(1) = 1
		 * */
		int k = 1;
		HashMap<Integer, Integer> xmap = new HashMap<>();
		HashMap<Integer, Integer> ymap = new HashMap<>();
		
		for(;;k++){
			int tx = X(xmap, k, m);
			int ty = Y(ymap, k, n);
			
			if(tx == x && ty == y){
				System.out.printf("tx : %d\tty : %d\n", tx, ty);
				break;
			}
			if(tx == m && ty == n)
				return -1;
		}
		return k;
	}
	public static int X(HashMap<Integer, Integer> map, int k, int m){
		if(k == 1)
			return 1;
		if(map.containsKey(k))
			return map.get(k);
		map.put(k, (X(map, k - 1, m) % m) + 1);
		return map.get(k);
	}
	public static int Y(HashMap<Integer, Integer> map, int k, int n){
		if(k == 1)
			return 1;
		if(map.containsKey(k))
			return map.get(k);
		map.put(k, (Y(map, k - 1, n) % n) + 1);
		return map.get(k);
	}
}
