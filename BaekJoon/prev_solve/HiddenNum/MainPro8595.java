package prev_solve.HiddenNum;

import java.util.Scanner;

public class MainPro8595 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		String input = scan.next();
		long res = 0;
		int pos_num = 1;
		
		for(int i = n - 1;i >= 0;i--){
			if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
				res += (pos_num * (input.charAt(i) - '0'));
				pos_num *= 10;
				if(pos_num > 100000)
					pos_num = 1;
			}else
				pos_num = 1;
		}
		System.out.println(res);

		scan.close();
	}

}
