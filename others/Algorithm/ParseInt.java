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
		int maxlen = target.length() - 1;
		for(int i = 0;i < target.length();i++){
			int t = parseInt(target.charAt(i));
			if(i == 0 && t < 0){
				positive = -1;
				maxlen --;
				continue;
			}
			res += (t * upper(10, maxlen--));
		}
		return positive * res;
	}
	public static int parseInt(char c){
		if(c == '-')
			return -1;
		return c - '0';
	}
	public static int upper(int down, int up){
		if(down == 0)
			return 0;
		if(down == 1)
			return 1;
		if(up == 1)
			return down;
		if(up == 0)
			return 1;
		if(up % 2 == 0){
			int t = upper(down, up / 2);
			return t * t;
		}else{
			return down * upper(down, up - 1);
		}
	}
}
