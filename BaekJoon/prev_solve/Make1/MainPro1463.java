package prev_solve.Make1;

import java.util.Scanner;

public class MainPro1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		int memo[][] = new int[2][n];//memorize operator count
		
		//initialize
		if(n % 3 == 0)//function 1
			memo[0][n / 3] = 1;
		if(n % 2 == 0)//function 2
			memo[0][n / 2] = 1;
		if(n - 1 > 0)//function 3
			memo[0][n - 1] = 1;
		
		System.out.println(goWay(0, memo, n));
		
		scan.close();
	}
	private static int goWay(int depth, int memo[][], int n){
		int prev_depth = depth % 2;
		int cur_depth = (depth + 1) % 2;

		if(memo[prev_depth][1] > 0)
			return memo[prev_depth][1];
		
		for(int i = 0;i < n;i++){
			if(memo[prev_depth][i] > 0){
				if(i % 3 == 0)//function 1
					if(memo[cur_depth][i / 3] > 0)
						memo[cur_depth][i / 3] = min(memo[cur_depth][i / 3], memo[prev_depth][i] + 1);
					else
						memo[cur_depth][i / 3] = memo[prev_depth][i] + 1;
				if(i % 2 == 0)//function 2
					if(memo[cur_depth][i / 2] > 0)
						memo[cur_depth][i / 2] = min(memo[cur_depth][i / 2], memo[prev_depth][i] + 1);
					else
						memo[cur_depth][i / 2] = memo[prev_depth][i] + 1;
				if(i - 1 > 0)//function 3
					if(memo[cur_depth][i - 1] > 0)
						memo[cur_depth][i - 1] = min(memo[cur_depth][i - 1], memo[prev_depth][i] + 1);
					else
						memo[cur_depth][i - 1] = memo[prev_depth][i] + 1;
				
				memo[prev_depth][i] = 0;
			}
		}
		return goWay(depth + 1, memo, n);
	}
	private static int min(int a, int b){
		return (a>b)? b:a;
	}
}
