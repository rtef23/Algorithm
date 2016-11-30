package Algospot_Contest;

import java.util.Arrays;
import java.util.Scanner;

public class D {
	public static final String b_win = "Black";
	public static final String w_win = "White";
	public static final String none = "Neither";
	
	public static final int BO = 0;
	public static final int BI = 1;
	public static final int S = 2;
	public static final int WO = 3;
	public static final int WI = 4;
	
	public static int score[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 A[]
		 	0 : BO
		 	1 : BI
		 	2 : S
		 	3 : WO
		 	4 : WI
		 * */
		Scanner scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		while(testcase > 0){
			testcase--;
			score = new int[5];
			
			for(int i = 0;i < 5;i++)
				score[i] = scan.nextInt();
			System.out.printf("%s\n", F());
		}
		
		scan.close();
	}
	
	public static String F(){
		boolean isChanged;
		
		while(true){
			isChanged = false;
			if(BlackTurn()){
				isChanged = true;
				if(score[WI] == 0 && score[WO] == 0 && score[S] == 0)
					return b_win;
			}
			if(WhiteTurn()){
				isChanged = true;
				if(score[BI] == 0 && score[BO] == 0 && score[S] == 0)
					return w_win;
			}
			if(!isChanged){
				System.out.printf("\n%s\n", toStr(score));
				return none;
			}
		}
	}
	public static String toStr(int a[]){
		String res = "";
		int cnt = 0;
		for(int i : a){
			res += String.format("[%d] : %d\t", cnt, a[cnt]);
			cnt++;
		}
		return res;
	}
	public static boolean BlackTurn(){
		return decreaseWI();
	}
	public static boolean WhiteTurn(){
		return decreaseBI();
	}
	
	public static boolean decreaseBI(){
		if(score[BO] == 0 && score[S] == 0){
			score[BI]--;
			return true;
		}
		return false;
	}
	public static boolean decreaseWI(){
		if(score[WO] == 0 && score[S] == 0){
			score[WI]--;
			return true;
		}
		return false;
	}
}
