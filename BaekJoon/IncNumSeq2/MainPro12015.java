package IncNumSeq2;

import java.util.Scanner;

public class MainPro12015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int arr[] = new int[n];
		int M[] = new int[n + 1];
		
		for(int i = 0;i < n;i++){
			arr[i] = scan.nextInt();
		}
		
		scan.close();

		int max = 0;
		for(int i = 0;i < n;i++)
			if(max < getSol(M, arr, i + 1))
				max = getSol(M, arr, i + 1);
		System.out.println(max);
	}
	private static int getSol(int M[], int arr[], int n){
		/*
		 * M[n] : the maximum length of integer sequence which last value is arr[n]
		 *
		 * M[n] = MAX(M[i]) + 1, {A[i] < A[n], 0 <= i < n}
		 * M[1] = 1
		 * M[0] = 0
		 * */
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		
		if(M[n] > 0)
			return M[n];
		
		int max = 0;
		for(int i = 0;i < n;i++)
			if(arr[n - 1] > arr[i] && max < getSol(M, arr, i + 1))
				max = getSol(M, arr, i + 1);
		M[n] = max + 1;
		return M[n];
	}
}
