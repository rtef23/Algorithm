package prev_solve.DFSnBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainPro1260 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int v = scan.nextInt();
		int e = scan.nextInt();
		int startV = scan.nextInt();
		
		boolean map[][] = new boolean[v + 1][v + 1];
		
		//initialize
		for(int i = 1;i <= v;i++){
			Arrays.fill(map[i], false);
		}
		
		for(int i = 0;i < e;i++){
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			map[v1][v2] = map[v2][v1] = true;
		}
		
		ArrayList<Integer> dfs = getDFS(map, v, e, startV);
		ArrayList<Integer> bfs = getBFS(map, v, e, startV);
		
		for(Integer i : dfs){
			System.out.printf("%d ", i);
		}
		System.out.println();
		for(Integer i : bfs){
			System.out.printf("%d ", i);
		}
		
		scan.close();
	}
	public static ArrayList<Integer> getBFS(boolean map[][], int v, int e, int startV){
		ArrayList<Integer> r = new ArrayList<>();
		boolean isVisited[] = new boolean[v + 1];
		
		Arrays.fill(isVisited, false);
		BFSgo(r, map, startV, isVisited);
		
		return r;
	}
	public static ArrayList<Integer> getDFS(boolean map[][], int v, int e, int startV){
		ArrayList<Integer> r = new ArrayList<>();
		boolean isVisited[] = new boolean[v + 1];
		
		Arrays.fill(isVisited, false);
		DFSgo(r, map, startV, isVisited);
		
		return r;
	}
	private static void DFSgo(ArrayList<Integer> r, boolean map[][], int curV, boolean isVisited[]){
		if(isVisited[curV]){
			return;
		}
		isVisited[curV] = true;
		r.add(curV);
		for(int i = 1;i < map.length;i++){
			if(map[curV][i]){
				DFSgo(r, map, i, isVisited);
			}
		}
	}
	private static void BFSgo(ArrayList<Integer> r, boolean map[][], int curV, boolean isVisited[]){
		r.add(curV);
		isVisited[curV] = true;

		for(int cur_index = 0;cur_index < r.size();cur_index++){
			for(int i = 1;i < map.length;i++){
				if(map[r.get(cur_index)][i] && !isVisited[i]){
					r.add(i);
					isVisited[i] = true;
				}
			}
		}
	}
}
