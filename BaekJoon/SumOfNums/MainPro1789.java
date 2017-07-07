package SumOfNums;

import java.util.Scanner;

public class MainPro1789 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		float s = scan.nextFloat();
		System.out.printf("%d\n", F(s));
		scan.close();
	}
	public static int F(double s){
		return (int)Math.floor((Math.sqrt(1 + 8 * s) - 1) / 2);
	}
}
