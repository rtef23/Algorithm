package PI;

import java.util.Arrays;
import java.util.Scanner;

public class MainPi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = Integer.parseInt(scan.nextLine().trim());
		for(int i = 0;i < c;i++){
			String s = scan.nextLine().trim();
			System.out.println(F(s));
		}
		scan.close();
	}
	public static int F(String s){
		int memo[] = new int[s.length()];
		Arrays.fill(memo, -1);
		return F(s, memo, s.length() - 1);
	}
	public static int F(String s, int memo[], int si){
		if(si <= 1)
			return -1;
		if(memo[si] != -1)
			return memo[si];
		if(si <= 4){
			memo[si] = hard(s, 0, si + 1);
			return memo[si];
		}
		int min = Integer.MAX_VALUE;
		for(int len = 3;len <= 5;len++){
			int tmp = F(s, memo, si - len);
			if(tmp < 0)
				continue;
			min = min(min, tmp + hard(s, si - len + 1, len));
		}
		memo[si] = min;
		return memo[si];
	}
	public static int min(int a, int b){
		return (a > b)?b:a;
	}
	public static int hard(String s, int startIndex, int len){
		boolean isDiffValid = true;
		boolean toggle = true;
		int diff = s.charAt(startIndex + 1) - s.charAt(startIndex);
		
		for(int i = startIndex + 1;i < startIndex + len;i++){
			if(s.charAt(i) - s.charAt(i - 1) != diff){
				isDiffValid = false;
			}
			if(i - 2 >= startIndex && s.charAt(i) != s.charAt(i - 2)){
				toggle = false;
			}
		}
		if(isDiffValid){
			switch (diff) {
			case 0:
				return 1;
			case -1:
			case 1:
				return 2;
			default:
				return 5;
			}
		}else{
			if(toggle)
				return 4;
			return 10;
		}
	}
}
