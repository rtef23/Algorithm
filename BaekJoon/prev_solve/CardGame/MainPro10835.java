package prev_solve.CardGame;

import java.util.Scanner;

public class MainPro10835 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int l_max = 0;
		int score = 0;
		int A[] = new int[n];
		int B[] = new int[n];
		
		for(int i = 0;i < n;i++){
			A[i] = scan.nextInt();
			if(l_max < A[i])
				l_max = A[i];
		}
		for(int i = 0;i < n;i++){
			B[i] = scan.nextInt();
			if(l_max > B[i])
				score += B[i];
		}
		
		System.out.println(score);
		
		scan.close();
	}

}
