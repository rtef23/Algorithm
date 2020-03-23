package prev_solve.IncNumSeq2;

import java.util.Scanner;

public class MainPro12015_2 {
	//7
	//10 20 40 30 70 50 60
	//6
	//10 20 10 30 20 50
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0;i < n;i++)
			arr[i] = scan.nextInt();
		
		System.out.println(getSol(n, arr));
		
		scan.close();
	}
	private static int getSol(int n, int arr[]){
		/* 
		 * 
		 * M[n][l_i] : after inserting n th value, solution array's status which last index is l_i {n (; timing) l_i (; solution array length)}
		 * 
		 * (M[n - 1][l_i] < arr[n])? M[n][l_i + 1] = arr[n] : M[n - 1][lower_bound(arr[n])] = arr[n]
		 * 
		 * lower_bound(arr[], int val) : return index which does not affect array's sorted status
		 * 
		 * running time : n log(n) {n (; for insert values at solution array) * log2 (n) (; for binary search)}
		 */
		
		int M[] = new int[n];
		int m_index = 0;
		
		M[0] = arr[0];
		
		for(int i = 1;i < n;i++){
			if(M[m_index] < arr[i]){
				m_index++;
				M[m_index] = arr[i];
			}else{
				int lb = lower_bound(M, 0, m_index, arr[i]);
				if(lb >= 0)
					M[lb] = arr[i];
			}
		}
		
		return m_index + 1;
	}
	private static int lower_bound(int arr[], int s, int e, int val){
		//by using binary search, return index which does not affect array's sorted status(ascending order)
		//require O(log2 (n)) 
		if(s == e)
			return s;
		if(arr[s] >= val)
			return s;
		if(arr[e] <= val)
			return e;
		int m = (s + e) / 2;
		return (arr[m] < val)? lower_bound(arr, m + 1, e, val):lower_bound(arr, s, m, val);
	}
}
