package prev_solve.DrinkWine;

import java.util.Scanner;

public class MainPro2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int W[] = new int[n];

		for (int i = 0; i < n; i++)
			W[i] = scan.nextInt();

		System.out.println(MaxWine(n, W));

		scan.close();
	}

	private static int MaxWine(int n, int W[]) {
		int M[][] = new int[n + 1][3];

		M[1][1] = W[0];

		int max = 0;
		for (int i = 0; i < 3; i++) {
			int tmp = go(M, W, n, i);
			if (max < tmp)
				max = tmp;
		}
		
		return max;
	}

	private static int go(int M[][], int W[], int n, int h) {
		if (n <= 0 || (n == 1 && h == 2))
			return 0;
		if (M[n][h] > 0)
			return M[n][h];

		switch (h) {
		case 0:
		{
			int max = 0;
			
			for(int i = 0;i < 3;i++){
				int tmp = go(M, W, n - 1, i);
				if(max < tmp)
					max = tmp;
			}
			M[n][h] = max;
		}
			break;
		case 1: 
		{
			int max = 0;

			for (int i = 0; i < 3; i++) {
				int tmp = go(M, W, n - 2, i);
				if (max < tmp)
					max = tmp;
			}
			M[n][h] = max + W[n - 1];
		}
			break;
		default:// h == 2
		{
			M[n][h] = go(M, W, n - 1, 1) + W[n - 1];
		}
			break;
		}
		return M[n][h];

	}

	private static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.printf("[%02d] : %02d\t", i, arr[i]);
		System.out.println();
	}
}
