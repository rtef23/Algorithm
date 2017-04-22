package SnowWhite;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPro2309 {
	private static final int NUM_SCOPE = 9;
	private static final int NUM_NAN = 7;
	private static final int TARGET = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int talls[] = new int[NUM_SCOPE];
		
		for(int i = 0;i < NUM_SCOPE;i++){
			talls[i] = scan.nextInt();
		}
		
		
		scan.close();
	}
	public static ArrayList<Integer> F(int talls[]){
		ArrayList<Integer> res = new ArrayList<>();
		
		
		return res;
	}
	public static boolean F(int talls[], ArrayList<Integer> res, int avail_num_nan, int avail_tall, int last_nan_index){
		
	}
	public static boolean canBeNan(int talls[], int target_index){
		return false;
	}
	public static int sum(ArrayList<Integer>arr){
		int res = 0;
		for(int i = 0;i < arr.size();i++){
			res += arr.get(i);
		}
		return res;
	}
}
