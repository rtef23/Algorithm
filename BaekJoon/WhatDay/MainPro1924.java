package WhatDay;

import java.util.Scanner;

public class MainPro1924 {
	private static final String day[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt(); //month
		int y= scan.nextInt(); //date
		//let 2007's 1/1 monday
		
		int tmp = y;
		while(x > 1){
			x--;
			tmp += getTotDay(x);
		}
		tmp %= 7;
		System.out.printf("%s\n", day[tmp]);
		
		scan.close();
	}
	public static int getTotDay(int m){
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return 28;
		default:
			return -1;
		}
	}
}
