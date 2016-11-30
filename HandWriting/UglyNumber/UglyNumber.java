package UglyNumber;

import java.util.Scanner;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter n : ");
		int n = scan.nextInt();
		
		System.out.printf("n : %d\tisUgly number? : %b\n", n, isUgly(n));
		
		scan.close();
	}
	
	public static boolean isUgly(int num){
		if(num < 1)
			return false;
		if(num == 1)
			return true;
		if(num % 2 == 0)
			return isUgly(num / 2);
		if(num % 3 == 0)
			return isUgly(num / 3);
		if(num % 5 == 0)
			return isUgly(num / 5);
		return false;
	}
}
