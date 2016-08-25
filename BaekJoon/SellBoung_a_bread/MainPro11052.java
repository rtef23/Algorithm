package SellBoung_a_bread;

import java.util.Scanner;

public class MainPro11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;// the number of bread
		int p[];//profits : p[n] means n sets profit
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		p = new int[n];
		
		for(int i = 0;i < n;i++){
			p[i] = scan.nextInt();
		}
		int memo[] = new int[n + 1];
		
		System.out.println(go(memo, p, n));
		
		scan.close();
	}
	
	static int go(int memo[], int p[], int n){
		//return MAX(M[N - 1] + p[1], ...)
		if(n == 0)
			return 0;
		if(memo[n] > 0)
			return memo[n];
		else{
			int max = 0;
			for(int i = 0;i < n;i++){
				int tmp = go(memo, p, n - (1 + i)) + p[i];
				if(max < tmp)
					max = tmp;
			}
			memo[n] = max;
			
			return memo[n];
		}
	}
}
