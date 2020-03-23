package prev_solve.MarsMath;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPro5355 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine().trim());
		
		for(int i = 0;i < t;i++){
			String line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line, " ");
			float target = Float.parseFloat(tok.nextToken());
			
			while(tok.hasMoreTokens()){
				String op = tok.nextToken();
				switch (op) {
					case "@":
					{
						target *= 3;
					}
					break;
					case "%":
					{
						target += 5;
					}
					break;
					default://#
					{
						target -= 7;
					}
					break;
				} 
			}
			System.out.printf("%.2f\n", target);
		}
		scan.close();
	}

}
