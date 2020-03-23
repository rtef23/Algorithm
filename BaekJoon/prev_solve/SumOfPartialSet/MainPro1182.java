package prev_solve.SumOfPartialSet;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPro1182 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int s = scan.nextInt();
		int set[] = new int[n];
		
		for(int i = 0;i < n;i++)
			set[i] = scan.nextInt();
	
		System.out.println(F(n, s, set));
		
		scan.close();
	}
	public static int F(int n, int s, int set[]){
		ArrayList<Integer> sum_set = new ArrayList<>();
		sum_set.add(0);
		
		return F(s, 0, 0, set, sum_set);
	}
	public static int F(int s, int count, int set_index, int set[], ArrayList<Integer> sum_set){
		if(set_index >= set.length){
			return count;
		}
		int size = sum_set.size();
		for(int i = 0;i < size;i++){
			int val = sum_set.get(i) + set[set_index];
			if(val == s){
				count++;
			}
			sum_set.add(val);
		}
		return F(s, count, set_index + 1, set, sum_set);
	}
}
