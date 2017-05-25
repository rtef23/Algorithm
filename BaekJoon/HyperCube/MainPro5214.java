package HyperCube;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class MainPro5214 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int m = scan.nextInt();
		HashMap<Integer, HashSet<Integer>> vertex = new HashMap<>();
		
		for(int i = 0;i < m;i++){
			LinkedList<Integer> tmp = new LinkedList<>();
			HashSet<Integer> target;
			
			for(int j = 0;j < k;j++){
				tmp.add(scan.nextInt() - 1);
			}
			for(int j = 0;j < k;j++){
				target = (vertex.containsKey(tmp.get(j)))?vertex.get(tmp.get(j)):new HashSet<>();
				for(int l = 0;l < k;l++){
					if(tmp.get(j) == tmp.get(l)){
						continue;
					}
					target.add(tmp.get(l));
				}
				vertex.put(tmp.get(j), target);
			}
		}
		scan.close();
		System.out.println(Dijikstra(1, n, vertex, n));
	}
	public static int Dijikstra(int from, int to, HashMap<Integer, HashSet<Integer>> vertex, int n){
		int memo[] = new int[n];
		LinkedList<Integer> addedSet = new LinkedList<>();
		
		
		Arrays.fill(memo, -1);
		
		memo[from - 1] = 0;
		addedSet.add(from - 1);
		F(addedSet, vertex, n, memo);
		return (memo[to - 1] > 0)?memo[to - 1] + 1:-1;
	}
	public static void F(LinkedList<Integer> addedSet, HashMap<Integer, HashSet<Integer>> vertex, int n, int memo[]){
		if(addedSet.isEmpty()){
			return;
		}
		LinkedList<Integer> nextAddedSet = new LinkedList<>();
		
		while(!addedSet.isEmpty()){
			int target = addedSet.pop();
			HashSet<Integer> tmp = vertex.get(target);
			for(Integer i : tmp){
				if(memo[i] != -1 && memo[target] + 1 >= memo[i]){
					continue;
				}
				nextAddedSet.add(i);
				memo[i] = memo[target] + 1;
			}
		}
		nextAddedSet.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return (memo[o1] < memo[o2])?-1:1;
			};
		});
		F(nextAddedSet, vertex, n, memo);
	}
}
