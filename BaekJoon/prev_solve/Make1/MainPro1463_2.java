package prev_solve.Make1;

import java.util.Scanner;

public class MainPro1463_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		int memo[] = new int[n + 1];
		
		memo[n] = 1;
		
		System.out.println(getSol(memo, 1, n));
		
		scan.close();
	}
	static int getSol(int memo[], int depth, int n){
		if(memo[1] > 0)
			return memo[1] - 1;
		for(int i = 0;i <= n;i++){
			if(memo[i] == depth){
				if(i % 3 == 0)//act 1
					memo[i / 3] = depth + 1;
				if(i % 2 == 0)//act 2
					memo[i / 2] = depth + 1;
				memo[i - 1] = depth + 1;
			}
		}
		return getSol(memo, depth + 1, n);
	}
}
