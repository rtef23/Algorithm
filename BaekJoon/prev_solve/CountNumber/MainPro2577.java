package prev_solve.CountNumber;

import java.util.Scanner;

public class MainPro2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		int memo[] = new int[10];
		double res = a * b * c;

		while(res >= 10){
			int t = (int)(res % 10);
			res /= 10;
			memo[t]++;
		}
		memo[(int)(res % 10)]++;

		for(int i = 0;i < memo.length;i++){
			System.out.printf("%d\n", memo[i]);
		}
	}

}
