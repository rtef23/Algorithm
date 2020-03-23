package prev_solve.PlugCom;

import java.util.Scanner;

public class MainPro2010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	
		int multi_tab_hole[];
		int n = scan.nextInt();
		int tot_hole = 0;
		
		multi_tab_hole = new int[n];
		for(int i = 0;i < n;i++){
			multi_tab_hole[i] = scan.nextInt();
			tot_hole += multi_tab_hole[i];
		}
		
		System.out.println(tot_hole - n + 1);
		
		scan.close();
	}
}
