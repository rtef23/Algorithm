package Chk2Pow2;

import java.util.Scanner;

public class MainPro11966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		System.out.println(((n & (n - 1)) == 0)? 1:0);
		
		scan.close();
	}

}
