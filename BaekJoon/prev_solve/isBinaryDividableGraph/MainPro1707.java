package prev_solve.isBinaryDividableGraph;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro1707 {
	static String yes = "YES";
	static String no = "NO";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int k = scan.nextInt();
		
		for(int i = 0;i < k;i++){
			int v = scan.nextInt();//the number of vertex
			int e = scan.nextInt();//the number of edge
			boolean graph[][] = new boolean[v+1][v+1];
			
			for(int j = 1;j <= v;j++){
				Arrays.fill(graph[j], false);				
			}
			for(int j = 0;j < e;j++){
				int i1 = scan.nextInt();
				int i2 = scan.nextInt();
				graph[i1][i2] = graph[i2][i1] = true;
			}
			
			System.out.printf("%s\n", isBipartiteGraph(graph, v, e)?yes:no);
		}
		
		scan.close();
	}
	public static boolean isBipartiteGraph(boolean graph[][], int v, int e){
		return !isCycleExist(graph, v, e);
	}
	static boolean isCycleExist(boolean graph[][], int v, int e){
		boolean visited[] = new boolean[v + 1];
		boolean addedSet[] = new boolean[v + 1];
		Arrays.fill(visited, false);
		Arrays.fill(addedSet, false);
		addedSet[1] = true;
		
		return isCycleExist(visited, graph, v, addedSet);
	}
	static boolean isCycleExist(boolean visited[], boolean graph[][], int v, boolean addedSet[]){
		for(int i = 1;i <= v;i++){
			if(addedSet[i]){
				for(int j = 1;j <= v;j++){
					if(graph[i][j]){//iff connected
						
					}
				}
				
				addedSet[i] = false;
				visited[i] = true;
			}
		}
		
		return false;
	}
}
