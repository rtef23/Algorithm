package Quick_right_most_side;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort_right_most_side {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(new FileInputStream(new File("in.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
			
			int t;//test case

			t = scan.nextInt();
			for(int i = 0;i < t;i++){
				int n = scan.nextInt();//array size
				int arr[] = new int[n];
				StringBuffer sbuf = new StringBuffer();
				
				sbuf.append("original : ");
				for(int j = 0;j < n;j++){
					arr[j] = scan.nextInt();
					sbuf.append(arr[j] + "\t");
				}
				sbuf.append("\n");
				
				quick(arr, 0, n - 1);
				
				for(int j = 0;j < n;j++)
					sbuf.append(arr[j] + "\t");
				sbuf.append("\n");
				
				bw.write(sbuf.toString());
			}
			
			bw.close();
			scan.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static void quick(int arr[], int l, int r){
		int pivot = partition(arr, l, r);
		if(l < pivot)
			quick(arr, l, pivot - 1);
		if(r > pivot)
			quick(arr, pivot + 1, r);
	}
	private static int partition(int arr[], int l, int r){
		//return pivot position
		//pivot is on the right most side
		int pivot_val = arr[r];
		
		while(l <= r){
			for(;l <= r && arr[l] <= pivot_val;l++);
			for(r--;l <= r && arr[r] >= pivot_val;r--)
				arr[r + 1] = arr[r];
			if(l <= r){
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r + 1] = tmp;
				l++;
			}
		}
		arr[r + 1] = pivot_val;
		return r + 1;
	}
}
