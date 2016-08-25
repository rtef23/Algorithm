package Algorithm;

public class Main_Center {
	private static final int inf = -1;
	static int index_map[];
	static int tot_cost[];
	static int cost_map[][];
	static boolean isUpdate[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * to Do builting trading center, find center index which index has the
		 * largest profit
		 * 
		 * assume 1) at the directed graph 2) there is n centers 3) provide
		 * direct graph in a array form 4) every center is connected 5) it can
		 * be possible that there is minimum path which is not directly
		 * connected
		 * 
		 * total running time : O(n{for finding minimum cost} * n{for getting
		 * total cost} * n{for getting minimum cost})
		 * 
		 * M[n] : with n centers and at the directed graph, return minimum cost
		 * center index M[n] = (A[M[n-1]] < A[n])? M[n-1] : n M[1] = 0 M[0] = -1
		 * 
		 * running time : O(n)
		 * 
		 * 
		 * A[m] : return m th center's total cost A[m] = Sum(C[i][m]) +
		 * Sum(C[m][i]) (i != m, i : from 0 to n)
		 * 
		 * running time : O(n)
		 * 
		 * 
		 * C[a][b] : return minimum cost from a center to b center( = dijkstra
		 * algorithm) C[a][b] = Min((Min(C[s][e])) + G[e][b], C[a][b]) (e which
		 * center is adjacent to a center is index, s which center is from
		 * center is index, until all cost is updated)
		 * 
		 * initial state : C[a][a] = 0
		 * 
		 * running time : O(n)
		 * 
		 * 
		 * G[a][b] : at the directed graph, return cost which cost is direct
		 * cost between a center and b center, this graph information is
		 * provided
		 * 
		 * running time : O(1)
		 * 
		 * [directed graph form]
		 * 
		 * to index [] [] [] from index [] [] [] [] [] []
		 */
		
		int n = 10;
		int d_graph[][] = { { inf, inf, 5, 2, 7, 3, inf, inf, inf, inf }, // from
																			// 1
				{ 1, inf, 1, inf, inf, inf, inf, inf, inf, inf }, // from 2
				{ inf, inf, inf, 2, inf, inf, 9, 2, inf, inf }, // from 3
				{ 3, 3, inf, inf, inf, inf, inf, inf, inf, inf }, // from 4
				{ inf, inf, inf, inf, inf, inf, inf, 7, inf, 4 }, // from 5
				{ 5, inf, inf, inf, inf, inf, inf, inf, inf, 1 }, // from 6
				{ inf, inf, inf, 2, inf, inf, inf, inf, inf, inf }, // from 7
				{ inf, inf, 9, inf, inf, inf, inf, inf, inf, 3 }, // from 8
				{ inf, inf, inf, inf, inf, inf, inf, inf, inf, inf }, // from 9
				{ inf, inf, inf, inf, 2, 3, inf, 1, inf, inf }// from 10
		};
		
		for(int i = n;i >= 0;i--)
			System.out.println(getPosCenter(d_graph, i, n));
		
		printArr(cost_map, n);
	}

	private static int getPosCenter(int d_graph[][], int n, int tot_n) {
		/*
		 * M[n] : with n centers and at the directed graph, return minimum cost
		 * center index M[n] = (A[M[n-1]] < A[n])? M[n-1] : n M[1] = 0 M[0] = -1
		 * 
		 * running time : O(n)
		 */
		if(index_map == null)
			index_map = new int[n + 1];
		
		return getPosCenter(index_map, n, d_graph, tot_n);
	}

	private static int getPosCenter(int index_map[], int n, int d_graph[][], int tot_n) {
		if (n <= 1)
			return 0;
		if (index_map[n] > 0)
			return index_map[n];
		index_map[n] = (getTotCost(d_graph, tot_n, getPosCenter(index_map, n - 1, d_graph, tot_n)) < getTotCost(d_graph,
				tot_n, n - 1)) ? getPosCenter(index_map, n - 1, d_graph, tot_n)
						: n - 1;
		return index_map[n];
	}

	public static int getTotCost(int d_graph[][], int tot_n, int n) {
		/*
		 * A[m] : return m th center's total cost A[m] = Sum(C[i][m]) + Sum(C[m][i]) (i != m, i : from 0 to n)
		 * 
		 * running time : O(n)
		 */
		if(tot_cost == null)
			tot_cost = new int[tot_n];
		
		return getTotCost(tot_cost, d_graph, tot_n, n);
	}
	
	private static int getTotCost(int tot_cost[], int d_graph[][], int tot_n, int n){
		if(tot_cost[n] > 0)
			return tot_cost[n];
		
		for(int i = 0;i < tot_n;i++)
			if(i != n){
				int tmp = getCost(d_graph, tot_n, i, n);
				if(tmp != inf)
					tot_cost[n] += tmp;
				tmp = getCost(d_graph, tot_n, n, i);
				if(tmp != inf)
					tot_cost[n] += tmp;
			}
		tot_cost[n] /= tot_n;
		
		return tot_cost[n];
	}
	
	public static int getCost(int d_graph[][], int tot_n, int a, int b){
		/*
		 * C[a][b] : return minimum cost from a center to b center( = dijkstra algorithm) 
		 * C[a][b] = Min((Min(C[s][e])) + G[e][b], C[a][b]) 
		 * (e which center is adjacent to a center is index, s which center is from
		 * center is index, until all cost is updated)
		 * 
		 * initial state : 
		 * 	C[a][a] = 0
		 * 	C[a][b] = G[a][b]
		 * 
		 * running time : O(n)
		 */
		if(cost_map == null){
			cost_map = new int[tot_n][];
			//initialize cost map with inf
		}else if(cost_map[a] != null){
			return cost_map[a][b];
		}
		//in case cost_map[a] == null
		//initialize
		cost_map[a] = new int[tot_n];
		
		isUpdate = new boolean[tot_n];
		for(int i = 0;i < tot_n;i++){
			isUpdate[i] = false;
			cost_map[a][i] = inf;
		}
		
		cost_map[a][a] = 0;
		
		return getCost(isUpdate, cost_map[a], d_graph, tot_n, a, b);
	}
	private static int getCost(boolean isUpdate[] ,int cost_map[], int d_graph[][], int tot_n, int s, int e){
		if(isAllUpdate(isUpdate, tot_n))
			return cost_map[e];
		
		int adjacent_minimum_cost = inf;
		int adjacent_minimum_cost_index = inf;
		
		for(int i = 0;i < tot_n;i++){
			if(!isUpdate[i] && cost_map[i] != inf){//at the solution set find node which node is to be updated
				if(adjacent_minimum_cost_index != inf){
					if(adjacent_minimum_cost > cost_map[i]){
						adjacent_minimum_cost = cost_map[i];
						adjacent_minimum_cost_index = i;
					}
				}else{
					adjacent_minimum_cost = cost_map[i];
					adjacent_minimum_cost_index = i;
				}
			}
		}
		
		if(adjacent_minimum_cost_index == inf)
			return inf;
		
		//update adjacent nodes
		isUpdate[adjacent_minimum_cost_index] = true;
		for(int i = 0;i < tot_n;i++){
			if(d_graph[adjacent_minimum_cost_index][i] != inf){
				if(cost_map[i] != inf)
					cost_map[i] = min(cost_map[adjacent_minimum_cost_index] + d_graph[adjacent_minimum_cost_index][i], cost_map[i]);
				else
					cost_map[i] = cost_map[adjacent_minimum_cost_index] + d_graph[adjacent_minimum_cost_index][i];
			}
		}
		return getCost(isUpdate, cost_map, d_graph, tot_n, s, e);
	}
	
	private static int min(int a, int b){
		return (a < b)? a:b;
	}
	private static boolean isAllUpdate(boolean isUpdate[], int tot_n){
		for(int i = 0;i < tot_n;i++)
			if(!isUpdate[i])
				return false;
		return true;
	}
	private static void printArr(int arr[][], int n){
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++)
				System.out.printf("[%d, %d] : %s\t", i+1, j+1, (arr[i][j] == inf)? "inf" : String.format("%03d", arr[i][j]));
			System.out.println();
		}
	}
}
