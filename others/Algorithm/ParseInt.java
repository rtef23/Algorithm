package Algorithm;

import java.util.Scanner;

public class ParseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String target = scan.next();
		
		System.out.printf("original: %s\tconverted : %d\n", target, parseInt(target));
		
		scan.close();
	}
	public static int parseInt(String target){
		int res = 0;
		int positive = 1;
		int pos = 1;
		for(int i = target.length() - 1;i >= 0;i--){
			int t = parseInt(target.charAt(i));
			if(i == 0 && t < 0){
				positive = -1;
				continue;
			}
			res += (t * pos);
			pos *= 10;
		}
		return positive * res;
	}
	private static int parseInt(char c){
		if(c == '-')
			return -1;
		return c - '0';
	}
}
