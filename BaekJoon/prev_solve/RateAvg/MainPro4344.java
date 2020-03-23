package prev_solve.RateAvg;

import java.util.Scanner;

public class MainPro4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for(int i = 0;i < tc;i++){
			int n = scan.nextInt();
			int scores[] = new int[n];
			float avg;
			int high_stu = 0;
			
			avg = 0f;
			for(int j = 0;j < n;j++){
				scores[j] = scan.nextInt();
				avg += (float)scores[j];
			}
			avg /= n;
			for(int j = 0;j < n;j++){
				if(scores[j] > avg){
					high_stu++;
				}
			}
			System.out.printf("%.3f%%\n", (((float)high_stu / (float)n) * 100));
		}
		
		scan.close();
	}

}
