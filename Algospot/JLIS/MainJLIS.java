package JLIS;

import java.util.Scanner;

public class MainJLIS {
	private static final int unknown = -1;

	public static void main(String[] args) {
		int t;// test case
		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n, m;
			int arr_n[], arr_m[];

			n = scan.nextInt();
			m = scan.nextInt();

			arr_n = new int[n];
			arr_m = new int[m];

			for (int j = 0; j < n; j++)
				arr_n[j] = scan.nextInt();
			for (int j = 0; j < m; j++)
				arr_m[j] = scan.nextInt();

			System.out.println(getJLIS(arr_n, arr_m, n, m));
		}

		scan.close();
	}

	private static int getJLIS(int arr_n[], int arr_m[], int n, int m) {
		int memo[][] = new int[n + 1][m + 1];

		// initialize
		int incre_tier = 0;
		int largest = -1;
		int max = max(n + 1, m + 1);

		memo[0][0] = incre_tier;
		incre_tier++;
		memo[1][0] = incre_tier;
		memo[0][1] = incre_tier;

		for (int i = 2; i < max; i++) {
			if (i < n + 1) {
				int max_tier_val = 1;
				//int max_tier_index = 1;
				boolean isext = false;

				// find max tier index
				for (int j = 1; j < i; j++) {
					if (arr_n[j - 1] < arr_n[i - 1]) {
						isext = true;
						if (max_tier_val < memo[j][0]) {
							max_tier_val = memo[j][0];
					//		max_tier_index = j;
						}
					}
				}
				if(isext)
					max_tier_val++;
				memo[i][0] = max_tier_val;
			}

			if (i < m + 1) {
				int max_tier_val = 1;
				//int max_tier_index = 1;
				boolean isext = false;
				
				// find max tier index
				for (int j = 1; j < i; j++) {
					if (arr_m[j - 1] < arr_m[i - 1]) {
						isext = true;
						if (max_tier_val < memo[0][j]) {
							max_tier_val = memo[0][j];
					//		max_tier_index = j;
						}
					}
				}
				if(isext)
					max_tier_val++;
				memo[0][i] = max_tier_val;
			}
		}

		// initialize end
		// printArr(memo);
		// System.out.println();

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// compute arr elements
				boolean ext_n = false;// cur val(which exist in m) is ext in
										// arr_n
				boolean ext_m = false;

				// search before integer sequence there is cur val
				for (int k = 1; k < i; k++) {
					// search n
					if (memo[i][0] > memo[k][0] && arr_n[i - 1] > arr_n[k - 1]) {
						if (arr_n[k - 1] == arr_m[j - 1]) {
							ext_n = true;
						}
					}
				}
				for (int k = 1; k < j; k++) {
					// search m
					if (memo[0][j] > memo[0][k] && arr_m[j - 1] > arr_m[k - 1]) {
						if (arr_m[k - 1] == arr_n[i - 1]) {
							ext_m = true;
						}
					}
				}

				if (ext_n || ext_m || arr_n[i - 1] == arr_m[j - 1]) {
					memo[i][j] = max(memo[i - 1][j], memo[i][j - 1]);
					if (largest < memo[i][j] && memo[i][j] > 1)
						largest = memo[i][j];
				} else {// not ext in both arr

					memo[i][j] = memo[i][0] + memo[0][j];
					if (largest < memo[i][j] && memo[i][j] > 1)
						largest = memo[i][j];
				}
			}
		}
		//printArr(memo);

		if (largest == unknown)
			return 0;
		return largest;
	}

	private static void printArr(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.printf("[%d][%d] : %d\t", i, j, arr[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static int min(int a, int b) {
		return (a > b) ? b : a;
	}
}
