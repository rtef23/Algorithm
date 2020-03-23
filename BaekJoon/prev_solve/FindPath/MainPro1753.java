package prev_solve.FindPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class MainPro1753 {
	/*
8 9
1
1 2 5
1 3 3 
1 4 2
2 6 3
3 5 2
4 7 7
5 2 1
6 8 2
7 8 4
	 * */
	private static final String inf = "INF";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int v = scan.nextInt();
		int e = scan.nextInt();
		int start_point = scan.nextInt();
		HashMap<Integer, HashMap<Integer, Integer>>map = new HashMap<>();
		
		for(int i = 0;i < e;i++){
			int u = scan.nextInt();
			int v1 = scan.nextInt();
			int w = scan.nextInt();
			
			HashMap<Integer, Integer>target = (map.containsKey(u))?map.get(u):new HashMap<>();
			int target_weight = weight(map, u, v1);
			
			if(target_weight > 0){
				target.put(v1, min(target_weight, w));
			}else{
				target.put(v1, w);
			}
			map.put(u, target);
		}
		int res[] = Dijikstra(map, v, start_point);
		
		for(int i = 1;i < res.length;i++){
			System.out.println((i != start_point && res[i] == 0)?inf:res[i]);
		}
		
		scan.close();
	}
	public static int[] Dijikstra(HashMap<Integer, HashMap<Integer, Integer>>map, int v, int start_point){
		int res[] = new int[v+1];
		ArrayList<Integer> search_set = new ArrayList<>();
		
		res[start_point] = 0;
		search_set.add(start_point);
		
		F(map, search_set, res, start_point);
		return res;
	}
	public static void F(HashMap<Integer, HashMap<Integer, Integer>>map, ArrayList<Integer> search_set, int res[], int start_point){
		if(search_set.isEmpty()){
			return;
		}
		
		search_set.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (res[o1] > res[o2])?-1:(res[o1] == res[o2])?0:1;
			}
		});
		
		int search_size = search_set.size();
		
		for(int i = 0;i < search_size;i++){
			int from = search_set.remove(0);
			HashMap<Integer, Integer> connected = map.get(from);

			if(connected == null){
				continue;
			}
			
			for(Integer to : connected.keySet()){
				if(to == start_point){
					continue;
				}
				if(res[to] == 0){
					res[to] = res[from] + connected.get(to);
					if(!search_set.contains(to))
						search_set.add(to);
				}else{
					int compute_value = res[from] + connected.get(to);
					if(res[to] > compute_value){
						res[to] = compute_value;
						if(!search_set.contains(to))
							search_set.add(to);
					}
				}
			}
		}
		F(map, search_set, res, start_point);
	}
	public static int weight(HashMap<Integer, HashMap<Integer, Integer>> map, int from, int to){
		if(!map.containsKey(from)){
			return 0;
		}
		HashMap<Integer, Integer> target = map.get(from);
		if(!target.containsKey(to)){
			return 0;
		}
		return target.get(to);
	}
	public static int min(int a, int b){
		return (a > b)?b:a;
	}
}
