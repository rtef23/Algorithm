package Inventory;

import java.util.Arrays;
import java.util.Scanner;

public class MainInventory {
	/*
	 F(n, r, d) : the number of method which fills col[n] with r rings, d daggers
	 T(space, r, d) : the number of method which fills space with r rings, d daggers
	 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		for(int i = 0;i < testcase;i++){
			boolean inventory[][];
			int r = scan.nextInt();
			int c = scan.nextInt();
			int n = scan.nextInt();//rings
			int m = scan.nextInt();//daggers
			
			inventory = new boolean[r][c];
			for(int j = 0;j < r;j++)
				Arrays.fill(inventory[r], false);
			for(int j = 0;j < r;j++){
				String tmp = scan.next();
				for(int k = 0;k < c;k++){
					if(tmp.charAt(k) == '.')
						inventory[j][k] = true;
					else
						inventory[j][k] = false;
				}
			}
			
		}
		
		scan.close();
	}

}
