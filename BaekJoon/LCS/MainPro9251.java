package LCS;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro9251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String s1 = scan.next();
		String s2 = scan.next();
		
		System.out.printf("%d\n", S(s1, s2));
		
		scan.close();
	}
	public static int S(String s1, String s2){
		int map[][] = new int[s1.length()][s2.length()];

		//initialize
		for(int i = 0;i < s1.length();i++){
			Arrays.fill(map[i], -1);
		}
		return F(map, s1, s2, s1.length() - 1, s2.length() - 1);
	}
	public static int F(int map[][], String s1, String s2, int n1, int n2){
		if(n1 < 0 || n2 < 0)
			return 0;
		if(map[n1][n2] >= 0)
			return map[n1][n2];
		if(s1.charAt(n1) == s2.charAt(n2)){
			map[n1][n2] = max(F(map, s1, s2, n1 - 1, n2 - 1) + 1, F(map, s1, s2, n1, n2 - 1), F(map, s1, s2, n1 - 1, n2));
			return map[n1][n2];
		}else{
			map[n1][n2] = max(F(map, s1, s2, n1, n2 - 1), F(map, s1, s2, n1 - 1, n2));
			return map[n1][n2];
		}
	}
	public static int max(int a, int b){
		return (a > b)? a:b;
	}
	public static int max(int a, int b, int c){
		return max(a, max(b, c));
	}
}
