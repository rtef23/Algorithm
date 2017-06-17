package SumOfNums;

import java.util.Scanner;

public class MainPro1789 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		float s = scan.nextFloat();
		System.out.printf("%.0f\n", F(s));
		scan.close();
	}
	public static double F(double s){
		double n = (-1 + Math.sqrt(1 + 8 * s)) / 2;
		double diff = n - (int)n;
		if(diff == 0){
			return n;
		}else{
			double frontHalf = F(s / 2);
			return frontHalf * 2;
		}
	}
}
