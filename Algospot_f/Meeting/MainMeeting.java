package Meeting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		for(int i = 0;i < testcase;i++){
			int n = scan.nextInt();
			ArrayList<Integer> men_point = new ArrayList<>();
			ArrayList<Integer> women_point = new ArrayList<>();
			
			for(int j = 0;j < n;j++){
				men_point.add(scan.nextInt());
			}
			for(int j = 0;j < n;j++){
				women_point.add(scan.nextInt());
			}
			
			Collections.sort(men_point);
			Collections.sort(women_point);
			int res = 0;
			
			for(int j = 0;j < men_point.size();j++)
				res += Math.abs(men_point.get(j) - women_point.get(j));
			System.out.printf("%d\n", res);
		}
		
		scan.close();
	}
}
