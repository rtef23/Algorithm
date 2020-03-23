package prev_solve.Encrypt;

import java.util.Scanner;

public class MainPro2011 {
	private static final long limit = 1000000;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		int len = input.length();

		System.out.println(getSol(input, len));
		scan.close();
	}

	private static long getSol(String str, int n) {
		/*
		 * M[n] : return the number of method which can be decryptable with n characters
		 * S[i] : return the character which index is n at the string
		 * 
		 * M[n] = Sum(M[n][i])
		 * M[0][l] = 0
		 * M[n][0] = 0
		 * 
		 * M[1][1] = (S[1] != '0')? 1 : 0
		 * M[n][1] = (S[n] != '0')? M[n - 1] : 0
		 * M[n][2] = (1 <= to_INT(S[n-1] + S[n]) <= 26)? M[n - 1][1] : 0
		 * */
		long M[][] = new long[n + 1][3];
		boolean ischanged[][] = new boolean[n + 1][3];
		long tmp =  M_tot(ischanged, M, str, n);
		return tmp;
	}
	private static long M_sng(boolean ischanged[][], long M[][], String str, int n, int l){
		if(l <= 0)
			return 0;
		if(n <= 0)
			return 0;
		if(ischanged[n][l])
			return M[n][l];
		
		ischanged[n][l] = true;
		if(n == 1){
			if(l == 1){
				M[n][1] = (str.charAt(0) - '0' > 0)?1:0;
				return M[n][1];
			}else{//l == 2
				return 0;
			}
		}
		//n > 1
		if(l == 1){
			if(str.charAt(n - 1) != '0')
				M[n][1] = M_tot(ischanged, M, str, n - 1);
			else
				M[n][0] = 0;
		}else if(l == 2){
			int tmp = ((str.charAt(n - 2) - '0') * 10) + (str.charAt(n - 1) - '0');
			if(tmp >= 1 && tmp <= 26)
				M[n][2] = M_sng(ischanged, M, str, n - 1, 1);
			else
				M[n][2] = 0;
		}
		return M[n][l];
	}
	private static long M_tot(boolean ischanged[][], long M[][], String str, int n){
		long tot = 0;
		for(int i = 0;i < 3;i++){
			tot += M_sng(ischanged, M, str, n, i);
			tot %= limit;
		}
		return tot;
	}
}
