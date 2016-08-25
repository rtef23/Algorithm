package BaseBall;

import java.util.Scanner;

public class MainBaseBall {
	private static final int line = 9;
	private static String yonsei = "Yonsei";
	private static String korea = "Korea";
	private static String draw = "Draw";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();
		for(int i = 0;i < t;i++){
			int sco_yon = 0;
			int sco_kor = 0;
			
			for(int j = 0;j < line;j++){
				sco_yon += scan.nextInt();
				sco_kor += scan.nextInt();
			}
			//end input

			if(sco_yon > sco_kor)
				System.out.println(yonsei);
			else if(sco_yon < sco_kor)
				System.out.println(korea);
			else
				System.out.println(draw);
		}
		
		scan.close();
	}

}
