package NQueen;

import java.util.Scanner;

public class MainPro3344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int start_index = 2;

		while(start_index <= n){
			System.out.println(start_index);
			start_index += 2;
		}
		start_index = 1;
		
		while(start_index <= n){
			System.out.println(start_index);
			start_index += 2;
		}
		
		scan.close();
	}

}
