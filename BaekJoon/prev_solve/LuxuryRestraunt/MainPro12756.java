package prev_solve.LuxuryRestraunt;

import java.util.Scanner;

public class MainPro12756 {
	private static final String PA = "PLAYER A";
	private static final String PB = "PLAYER B";
	private static final String draw = "DRAW";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int a_atk = scan.nextInt();
		int a_def = scan.nextInt();
		
		int b_atk = scan.nextInt();
		int b_def = scan.nextInt();
		
		double a_time = Math.ceil((double)a_def / (double)b_atk);
		double b_time = Math.ceil((double)b_def / (double)a_atk);
		
		String res;
		
		if(a_time == b_time){
			res = draw;
		}else{
			if(a_time > b_time)
				res = PA;
			else
				res = PB;
		}
		
		System.out.printf("%s\n", res);
		
		scan.close();		
	}

}
