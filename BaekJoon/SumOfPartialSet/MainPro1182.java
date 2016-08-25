package SumOfPartialSet;

import java.util.HashMap;
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
	
		System.out.println(getSol(n, s, set));
		
		scan.close();
	}
	public static int getSol(int N, int S, int set[]){
		/*
		 * M[n] : with n th atom, return the number of subset
		 * M[n] = All(M[n - 1]) + set[n - 1]
		 * 
		 * M[-1] : empty set
		 * M[0] : with set[0]
		 * */
		//hashmap<key : sum	of subset, value : the number of subset>
		HashMap<Integer, Integer> initial_set = new HashMap<>();
		
		initial_set.put(0, 0);//empty subset, not to contain empty subset make this value 0
		return go1(initial_set, set, 0, N, S);
	}
	private static int go1(HashMap<Integer, Integer> subset, int set[], int n, int N, int S){
		if(n >= N)
			return (!subset.containsKey(S))? 0 : subset.get(S);
		
		HashMap<Integer, Integer> temp = (HashMap<Integer, Integer>)subset.clone();//before state
		for(Integer i : temp.keySet()){
			if(subset.containsKey(i + set[n])){
				subset.put(i + set[n], subset.get(i + set[n]) + subset.get(set[n]) + 1);
			}else{
				subset.put(i + set[n], 1);
			}
		}
		return go1(subset, set, n + 1, N, S);
	}
}
