package Algorithm;

public class Main_Center1 {
	private static final int inf = -1;
	private static int index_map[];
	private static float poss[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ToDo 
		 * 	get largest trading center index
		 * 
		 * Condition 
		 * 	1. at the directed graph 
		 * 	2. there is no unconnected node
		 * 
		 * M[n] : return index which has the largest possibility, when look up n
		 * centers M[n] = (A[M[n - 1]] < A[n])? n : M[n - 1]
		 *
		 * A[n] : return center n's possibility
		 * A[n] = (IE[n] + OE[n]) / (IC[n] + OC[n])
		 * 
		 * IE[n] : return the number of inner edge which destination is center n
		 * IE[n] = CNT(G[i][n] != inf)
		 * 
		 * OE[n] : return the number of outer edge which departure is center n
		 * OE[n] = CNT(G[n][i] != inf)
		 * 
		 * IC[n] : return the total inner cost which destination is center n
		 * IC[n] = Sum(G[i][n] != inf)
		 * 
		 * OC[n] : return the total outer cost which departure is center n
		 * OC[n] = Sum(G[n][i] != inf)
		 */
		int n = 10;
		int d_graph[][] = { 
				{ inf, inf, 5, 2, 7, 3, inf, inf, inf, inf }, // from 1
				{ 1, inf, 1, inf, inf, inf, inf, inf, inf, inf }, // from 2
				{ inf, inf, inf, 2, inf, inf, 9, 2, inf, inf }, // from 3
				{ 3, 7, inf, inf, inf, 2, inf, inf, 5, inf }, // from 4
				{ inf, inf, inf, inf, inf, inf, inf, 7, inf, 4 }, // from 5
				{ 5, inf, inf, inf, inf, inf, inf, inf, inf, 1 }, // from 6
				{ inf, inf, inf, 2, inf, inf, inf, inf, inf, inf }, // from 7
				{ inf, inf, 9, inf, inf, inf, inf, inf, inf, 3 }, // from 8
				{ inf, inf, inf, inf, inf, inf, inf, inf, inf, inf }, // from 9
				{ inf, inf, inf, inf, 2, 3, inf, 1, inf, inf }// from 10
		};

		for(int i = n;i >= 0;i--)
			System.out.println(getPosCenterIndex(d_graph, n, i) + 1);

		printArr(poss, n);
	}

	public static int getPosCenterIndex(int d_graph[][], int tot_n, int n) {
		/*
		 * M[n] = (A[M[n-1]] > A[n])? M[n-1] : n - 1
		 * M[1] = 0
		 * 
		 * */
		if (index_map == null)
			index_map = new int[tot_n + 1];
		return getPosCenterIndex(index_map, d_graph, tot_n, n);
	}

	private static int getPosCenterIndex(int index_map[], int d_graph[][], int tot_n, int n) {
		if (n <= 1)
			return 0;
		if (index_map[n] > 0)
			return index_map[n];
		index_map[n] = (getPossibility(d_graph, tot_n,
				getPosCenterIndex(index_map, d_graph, tot_n, n - 1)) < getPossibility(d_graph, tot_n, n - 1)) ? n - 1
						: getPosCenterIndex(index_map, d_graph, tot_n, n - 1);
		return index_map[n];
	}

	public static float getPossibility(int d_graph[][], int tot_n, int n) {
		/*
		 * A[n] : return n center's possibility
		 * A[n] = (IE[n] + OE[n]) / (IC[n] + OC[n]) 
		 * */
		if (poss == null)
			poss = new float[tot_n];
		return getPossibility(poss, d_graph, tot_n, n);
	}

	private static float getPossibility(float poss[], int d_graph[][], int tot_n, int n) {
		if (poss[n] > 0f)
			return poss[n];

		int edge_cnt = 0;
		int total_cost = 0;

		for (int i = 0; i < tot_n; i++) {
			if (d_graph[i][n] != inf) {
				edge_cnt++;
				total_cost += d_graph[i][n];
			}
			if (d_graph[n][i] != inf) {
				edge_cnt++;
				total_cost += d_graph[n][i];
			}
		}

		poss[n] = (float)edge_cnt / (float)(total_cost);

		return poss[n];
	}

	private static void printArr(float arr[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.printf("[%d] : %s\t", i + 1, (arr[i] == inf) ? "inf" : String.format("%.03f", arr[i]));
		}
	}
}
