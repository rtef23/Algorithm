package prev_solve.SWtest;

import java.util.Scanner;

public class MainPro13448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		int Mi[] = new int[n];
		int Pi[] = new int[n];
		int Ri[] = new int[n];
		
		for(int i = 0;i < n;i++){
			Mi[i] = scan.nextInt();
		}
		for(int i = 0;i < n;i++){
			Pi[i] = scan.nextInt();
		}
		for(int i = 0;i < n;i++){
			Ri[i] = scan.nextInt();
		}
		scan.close();
		
		
	}

}
