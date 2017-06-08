package Quantization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainQuantization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int s = scan.nextInt();
			ArrayList<Integer> A = new ArrayList<>();
			for(int j = 0;j < n;j++){
				A.add(scan.nextInt());
			}
			System.out.printf("%d\n", (int)F(A, n, s));
		}
		scan.close();
	}
	public static double F(ArrayList<Integer> A, int n, int s){
		double memo[][][] = new double[s][n][n];
		for(int i = 0;i < s;i++)
			for(int j = 0;j < n;j++)
				Arrays.fill(memo[i][j], -1);
		A.sort(null);
		return F(memo, A, s, 0, n - 1); 
	}
	public static double F(double memo[][][], ArrayList<Integer> A, int s, int si, int ei){
 	 	if(memo[s-1][si][ei] != -1)
			return memo[s-1][si][ei];
 	 	if(s == 0)
 	 		return -1;
		if(s == 1){
			double ret = 0;
			double m = avg(A, si, ei);
			for(int i = si;i <= ei;i++){
				double tmp = A.get(i) - m;
				ret += (tmp * tmp);
			}
			memo[s-1][si][ei] = ret;
			return memo[s-1][si][ei];
		}
		double ret = -1;
		for(int i = si;i < ei;i++){
			double t1 = F(memo, A, 1, si, i);
			double t2 = F(memo, A, s - 1, i + 1, ei);
			if(t1 < 0 || t2 < 0)
				continue;
			if(ret < 0)
				ret = t1 + t2;
			else
				ret = min(ret, t1 + t2);
		}
		memo[s-1][si][ei] = ret;
		return memo[s-1][si][ei];
	}
	public static double min(double a, double b){
		return (a > b)?b:a;
	}
	public static double avg(ArrayList<Integer> A, int si, int ei){
		double ret = 0;
		for(int i = si;i <= ei;i++){
			ret += A.get(i);
		}
		return Math.round(ret / (ei - si + 1));
	}
}
