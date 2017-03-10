package StrRepeat;

import java.util.Scanner;

public class MainPro2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i = 0;i < T;i++){
			int r = scan.nextInt();
			String s = scan.next();
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j < s.length();j++){
				for(int k = 0;k < r;k++){
					sb.append(s.charAt(j));
				}
			}
			System.out.println(sb.toString());
		}
		
		scan.close();
	}

}
