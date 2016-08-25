package Quick_pivot_leftmostside;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort_left_most_side {
	public static void main(String[] args) {
		int t;// test case
		try {
			Scanner scan = new Scanner(new FileInputStream(new File("in.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
			t = scan.nextInt();

			for (int i = 0; i < t; i++) {
				int n;// array length
				int arr[];// array which want to be sorted
				StringBuffer sbuf = new StringBuffer();

				n = scan.nextInt();
				arr = new int[n];

				sbuf.append("original : ");
				for (int j = 0; j < n; j++) {
					arr[j] = scan.nextInt();
					sbuf.append(arr[j] + "\t");
				}
				sbuf.append("\n");

				quick(arr, 0, n - 1);

				for (int j = 0; j < n; j++)
					sbuf.append(arr[j] + "\t");
				sbuf.append("\n");

				bw.write(sbuf.toString());
			}

			scan.close();
			bw.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void quick(int arr[], int l, int r) {
		int pivot = partition(arr, l, r);

		if (l < pivot - 1)
			quick(arr, l, pivot - 1);
		if (r > pivot + 1)
			quick(arr, pivot + 1, r);
	}

	private static int partition(int arr[], int l, int r) {
		// return pivot position
		int pivot_pos = l;
		int pivot_val = arr[pivot_pos];
		
		for(l++;l <= r;){
			//find l pos
			for(;l <= r && arr[l] <= pivot_val;l++);
			//find r pos
			for(;l <= r && arr[r] > pivot_val;r--);
			if(l < r){
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
				l++;
				r--;
			}
		}

		if(pivot_pos < r){
			arr[pivot_pos] = arr[r];
			arr[r] = pivot_val;
		}
		
		return r;
	}
}
