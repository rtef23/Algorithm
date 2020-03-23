package prev_solve.Terret;

import java.util.Scanner;

public class MainTerret {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		for(int i = 0;i < t;i++){
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			double r1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			double r2 = scan.nextInt();
			
			double d = getDist(x1, y1, x2, y2);
			int num_pos = 0;
			
			if(d == 0){
				if(r1 == r2)
					num_pos = -1;
				else
					num_pos = 0;
			}else{
				double max = Math.max(r1, r2);
				double min = Math.min(r1, r2);
				
				if(max > d){
					if(max - d < min){
						num_pos = 2;
					}else if(max - d > min){
						num_pos = 0;
					}else{//max - d == min
						num_pos = 1;
					}
				}else if(max == d){
					num_pos = 2;
				}else{//max < d
					if(r1 + r2 > d){
						num_pos = 2;
					}else if(r1 + r2 < d){
						num_pos = 0;
					}else{//r1 + r2 == d
						num_pos = 1;
					}
				}
			}
			System.out.println(num_pos);
		}
		
		scan.close();
	}
	static double getDist(int x1, int y1, int x2, int y2){
		int x2_x1 = (x2 - x1);
		int y2_y1 = (y2 - y1);
		return Math.sqrt(((x2_x1 * x2_x1) + (y2_y1 * y2_y1))); 
	}
}
