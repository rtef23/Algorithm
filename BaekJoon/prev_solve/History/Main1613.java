package prev_solve.History;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main1613 {
	private static final int prev = -1;
	private static final int next = 1;
	private static final int unknown = 0;
	private static final int undefined = 2;
	/*
	 1 <= n <= 400
	 1 <= k <= 50000
	 1 <= s <= 50000
	 
	 n^2 = 160000 * 4 byte = 640000 byte := 640 KB
	 
	 M[i][j] : order from i to j
	 M[i][j] = 
	 	iff 0
	 		i j ?
	 	iff -1
	 		i -> j
	 		
	 	iff 1
	 		j -> i
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();
		int n = scan.nextInt();
		int k = scan.nextInt();
		int s;
		int map[][] = new int[n+1][n+1];
		
		for(int i = 0;i < k;i++){
			int from = scan.nextInt();
			int to = scan.nextInt();
			
			map[from][to] = prev;
			map[to][from] = next;
		}
		
		s = scan.nextInt();
		for(int i = 0;i < s;i++){
			int s1 = scan.nextInt();
			int s2 = scan.nextInt();
			System.out.println(getCost(memo, n, map, s1, s2));
		}
		
		scan.close();
	}
	public static int getCost(HashMap<Integer, HashMap<Integer, Integer>>memo, int n, int map[][], int s1, int s2){
		//O(n^3) := 400 400 400 == 64000000
		if(memo.containsKey(s1)){
			return memo.get(s1).get(s2);
		}
		if(memo.containsKey(s2)){
			HashMap<Integer, Integer> target = memo.get(s2);
			if(!target.containsKey(s1)){
				return unknown;
			}
			return (target.get(s1) == prev)?next:prev;
		}

		HashMap<Integer, Integer>arr = new HashMap<>();
		boolean isChanged = true;
		boolean enterSet[] = new boolean[n+1];

		Arrays.fill(enterSet, false);
		enterSet[s1] = true;
		
		while(isChanged){
			isChanged = false;
			for(int i = 1;i <= n;i++){
				if(enterSet[i]){
					for(int j = 1;j <= n;j++){
						if(!arr.containsKey(j) && map[i][j] != unknown){
							if(i == s1){
								isChanged = true;
								enterSet[j] = true;
								arr.put(j, map[i][j]);
								continue;
							}
							if(arr.get(i) == prev && map[i][j] == prev){//s1 -> i, i -> j
								isChanged = true;
								enterSet[j] = true;
								arr.put(j, prev);
							}else if(arr.get(i) == next && map[i][j] == next){//next, i -> s1, j -> i
								isChanged = true;
								enterSet[j] = true;
								arr.put(j, next);
							}
						}
					}
					enterSet[i] = false;
				}
			}
		}
		
		memo.put(s1, arr);
		if(!arr.containsKey(s2)){
			return unknown;
		}
		return arr.get(s2);
	}
	
}
